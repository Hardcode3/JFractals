package org.jfractals.ui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;

public class MainWindowController {
    private final ViewOptions viewOptions = new ViewOptions();
    @FXML private FractalController fractalViewController;
    @FXML private CheckMenuItem showScaleMenuItem;

    @FXML
    private void initialize() {
        showScaleMenuItem.selectedProperty().bindBidirectional(viewOptions.getShowScaleProperty());
        fractalViewController.setViewOptions(viewOptions);
    }

    @FXML private void resetView() {
        fractalViewController.resetView();
    }

    @FXML private void showSettings() {
        fractalViewController.showSettings();
    }

    public void onViewReady(Scene scene) {
        fractalViewController.onViewReady(scene);
    }

    public void close() {
        fractalViewController.close();
    }
}
