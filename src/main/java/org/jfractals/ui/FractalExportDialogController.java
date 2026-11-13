package org.jfractals.ui;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class FractalExportDialogController {
    @FXML private TextField exportPathTextField;
    @FXML private TextField widthTextField;
    @FXML private TextField heightTextField;
    @FXML private TextField aspectRatioWidthTextField;
    @FXML private TextField aspectRatioHeightTextField;

    @FXML
    private void initialize() { }

    @FXML
    private void onBrowseClicked() {
        FileChooser fchooser = new FileChooser();
        fchooser.setTitle("Choose a file to export the fractal");
        fchooser.setInitialFileName("fractal_image.png");
        fchooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png"));
        File selectedFile = fchooser.showSaveDialog(null);
        if (selectedFile != null) {
            exportPathTextField.setText(selectedFile.getAbsolutePath());
        }
    }

    @FXML void onExportClicked() {
        String exportPath = exportPathTextField.getText();
        if (exportPath != null && !exportPath.isEmpty()) {
            // TODO: Implement the actual export logic here
            System.out.println("Exporting fractal to: " + exportPath);
        } else {
            System.out.println("Export path is empty.");
        }
    }
}
