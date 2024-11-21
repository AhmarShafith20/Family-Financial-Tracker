package main;

//author Shifan, GenAi()(chooseFile(), updateTable())
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.util.ArrayList;

public class InputViewBuilder {
    private final Stage stage;
    private final VBox layout;
    private final Button file1Button;
    private final Button file2Button;
    private final Button processButton;
    private final Label file1Label;
    private final Label file2Label;
    private final TableView<Transaction> tableView;

    public InputViewBuilder(Stage stage) {
        this.stage = stage;
        layout = new VBox(10);
        layout.setPadding(new Insets(10));

        // UI Components
        file1Button = new Button("Select Transactions File");
        file2Button = new Button("Select Buyer Assignment File");
        processButton = new Button("Process Files");
        processButton.setDisable(true);
        file1Label = new Label("No file selected");
        file2Label = new Label("No file selected");

        // TableView
        tableView = createTableView();

        // Layout setup
        layout.getChildren().addAll(
                file1Button, file1Label,
                file2Button, file2Label,
                processButton,
                tableView
        );

        Scene scene = new Scene(layout, 800, 600);
        stage.setScene(scene);
    }

    // Create TableView
    private TableView<Transaction> createTableView() {
        TableView<Transaction> tableView = new TableView<>();

        TableColumn<Transaction, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDate().toString()));

        TableColumn<Transaction, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescription()));

        TableColumn<Transaction, String> debitColumn = new TableColumn<>("Debit");
        debitColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAmount().getDebit().toString()));

        TableColumn<Transaction, String> creditColumn = new TableColumn<>("Credit");
        creditColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAmount().getCredit().toString()));

        TableColumn<Transaction, String> balanceColumn = new TableColumn<>("Balance");
        balanceColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAmount().getBalance().toString()));

        TableColumn<Transaction, String> buyerColumn = new TableColumn<>("Buyer");
        buyerColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBuyer()));

        TableColumn<Transaction, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategory()));

        tableView.getColumns().addAll(dateColumn, descriptionColumn, debitColumn, creditColumn, balanceColumn, buyerColumn, categoryColumn);
        return tableView;
    }

    // Update the TableView with new data
    public void updateTable(ArrayList<Transaction> transactions) {
        ObservableList<Transaction> data = FXCollections.observableArrayList(transactions);
        tableView.setItems(data);
    }

    // Getters for the UI components
    public Button getFile1Button() {
        return file1Button;
    }

    public Button getFile2Button() {
        return file2Button;
    }

    public Button getProcessButton() {
        return processButton;
    }

    public Label getFile1Label() {
        return file1Label;
    }

    public Label getFile2Label() {
        return file2Label;
    }

    public File chooseFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));
        return fileChooser.showOpenDialog(stage);
    }
}
