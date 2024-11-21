package main;
//author -Shifan, GenAi (showError()) 

import main.InputFiles;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.control.Alert;

public class InputController {
    private final InputViewBuilder view;
    private File file1;
    private File file2;

    public InputController(InputViewBuilder view) {
        this.view = view;

        // File 1 selection action
        view.getFile1Button().setOnAction(e -> {
            file1 = view.chooseFile();
            view.getFile1Label().setText(file1 != null ? file1.getName() : "No file selected");
            toggleProcessButton();
        });

        // File 2 selection action
        view.getFile2Button().setOnAction(e -> {
            file2 = view.chooseFile();
            view.getFile2Label().setText(file2 != null ? file2.getName() : "No file selected");
            toggleProcessButton();
        });

        // Process files action
        view.getProcessButton().setOnAction(e -> {
            if (file1 != null && file2 != null) {
                try {
                    ArrayList<Transaction> transactions = InputFiles.read(file1.getAbsolutePath(), file2.getAbsolutePath());
                    view.updateTable(transactions);
                } catch (IOException ex) {
                    showError("Error reading files: " + ex.getMessage());
                }
            }
        });
    }

    // Enable the process button when both files are selected
    private void toggleProcessButton() {
        view.getProcessButton().setDisable(file1 == null || file2 == null);
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
