package dataStructures;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Observable;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.*;

public class VisualRepresentation extends Application{

	Label value, index;
	TextField noValue, noIndex;
	Button insert, delete, find, sort;
	final ToggleGroup findGroup = new ToggleGroup(), sortGroup = new ToggleGroup();
	RadioButton ascending, descending, linear, binary;
	TableView<Table> table;
	int i;

	public static void main(String[] args){
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception{
		// Title
		window.setTitle("Graphical Visualization of Basic Algorithms");

		// Layout
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 30, 15, 30));
		grid.setVgap(8);
		grid.setHgap(10);

		// Labels and Text fields
		value = new Label("Value");

		int input = 0;

		noValue = new TextField();
		noValue.setPrefWidth(2);
		noValue.getText();

		insert = new Button("Insert");
		insert.setOnAction(e -> {
			isInt(noValue, noValue.getText());
			insertButtonClicked();
		});

		find = new Button("Find");
		find.setOnAction(e -> isInt(noValue, noValue.getText()));

		index = new Label("Index");

		noIndex = new TextField();
		noIndex.setPrefWidth(2);
		noIndex.getText();

		delete = new Button("Delete");
		delete.setOnAction(e -> {
			isInt(noIndex, noIndex.getText());
			deleteButtonClicked();
		});

		// Adding Labels and Text fields to the grid
		grid.setConstraints(index, 0, 0);
		grid.setConstraints(noIndex, 1, 0);
		grid.setConstraints(value, 5, 0);
		grid.setConstraints(noValue, 6, 0);

		// Buttons
		sort = new Button("Sort");

		// Adding Buttons to the grid
		grid.setConstraints(delete, 2, 0);
		grid.setConstraints(insert, 7, 0);
		grid.setConstraints(sort, 0, 2);
		grid.setConstraints(find, 5, 2);

		// Radio Buttons
		linear = new RadioButton("Linear");
		linear.setToggleGroup(findGroup);
		binary = new RadioButton("Binary");
		binary.setToggleGroup(findGroup);
		ascending = new RadioButton("Ascending");
		ascending.setToggleGroup(sortGroup);
		descending = new RadioButton("Descending");
		descending.setToggleGroup(sortGroup);

		// Adding Radio Buttons to grid
		grid.setConstraints(linear, 6, 2);
		grid.setConstraints(binary, 7, 2);
		grid.setConstraints(ascending, 1, 2);
		grid.setConstraints(descending, 2, 2);

		// Creating a table to display the visual representation of what is happening
		TableColumn<Table, Integer> indexColumn = new TableColumn<>("Index");
		indexColumn.setMinWidth(20);
		indexColumn.setCellValueFactory(new PropertyValueFactory<>("index"));

		TableColumn<Table, Integer> valueColumn = new TableColumn<>("Value");
		valueColumn.setMinWidth(20);
		valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

		grid.getChildren().addAll(value, noValue, index, noIndex, insert, delete, find, sort, ascending, descending, linear, binary);

		table = new TableView<>();
		table.setItems(getTables());
		table.getColumns().addAll(indexColumn, valueColumn);

		VBox vBox = new VBox();
		vBox.getChildren().addAll(table);

		// Overall layout
		BorderPane layout = new BorderPane();
		layout.setTop(grid);
		layout.setCenter(vBox);

		Scene scene = new Scene(layout, 500, 520);
		window.setScene(scene);
		window.show();
	}

	private int isInt(TextField input, String text){
		// TODO Auto-generated method stub
		try{
			int Input = Integer.parseInt(text);
			System.out.println(Input);
			return Input;
		}
		catch(NumberFormatException e){
			System.out.println("Error! ");
			return -1;
		}
	}

	public void insertButtonClicked(){
		Table insert = new Table();

		int input = isInt(noValue, noValue.getText());

		insert.setValue(input);
		insert.setIndex(i++);
		table.getItems().add(insert);
	}

	public void deleteButtonClicked(){
		ObservableList<Table> index, allIndex;
		allIndex = table.getItems();
		index = table.getSelectionModel().getSelectedItems();

		index.forEach(allIndex::remove);

		Table delete = new Table();
		delete.setIndex(i--);
		table.getItems().add(delete);
	}

	private int findButtonClicked(){
		Table find = new Table();

		if(Integer.parseInt(noValue.getText()) == find.getValue()){
			return Integer.parseInt(noValue.getText());
		}
		else{
			return 0;
		}
	}

	public ObservableList<Table> getTables(){
		ObservableList<Table> table = FXCollections.observableArrayList();

		int arraySize = 15;
		int[] value = new int[50];

		for(int i = 0; i < arraySize; i++)
			value[i] = (int) (Math.random() * 1000);

		for(i = 0; i < arraySize; i++){
			table.add(new Table(i, value[i]));
		}

		return table;
	}

}
