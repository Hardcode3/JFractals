package org.jfractals.ui;

import java.io.File;
import java.util.function.IntConsumer;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class FractalExportDialogController {
    private final FractalExportSettings settings = new FractalExportSettings();
    private boolean syncingControls;

    @FXML private TextField exportPathTextField;
    @FXML private Spinner<Integer> widthSpinner;
    @FXML private Spinner<Integer> heightSpinner;
    @FXML private Spinner<Integer> aspectRatioWidthSpinner;
    @FXML private Spinner<Integer> aspectRatioHeightSpinner;

    @FXML
    private void initialize() {
        widthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1920 * 10, 1920));
        heightSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1080 * 10, 1080));
        aspectRatioWidthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 16 * 10, 16));
        aspectRatioHeightSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9 * 10, 9));

        connect(widthSpinner, settings::setWidthPx);
        connect(heightSpinner, settings::setHeightPx);
        connect(aspectRatioWidthSpinner, settings::setAspectRatioWidth);
        connect(aspectRatioHeightSpinner, settings::setAspectRatioHeight);
    }

    private void connect(Spinner<Integer> spinner, IntConsumer setter) {
        spinner.getValueFactory().valueProperty().addListener((obs, oldValue, newValue) -> {
            if (syncingControls || newValue == null) {
                return;
            }
            setter.accept(newValue);
            refreshControlsFromSettings();
        });
    }

    private void refreshControlsFromSettings() {
        syncingControls = true;
        try {
            widthSpinner.getValueFactory().setValue(settings.getWidthPx());
            heightSpinner.getValueFactory().setValue(settings.getHeightPx());
            aspectRatioWidthSpinner.getValueFactory().setValue(settings.getAspectRatioWidth());
            aspectRatioHeightSpinner.getValueFactory().setValue(settings.getAspectRatioHeight());
        } finally {
            syncingControls = false;
        }
    }

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
