package org.jfractals.ui;

import javafx.fxml.FXML;
import javafx.scene.Scene;

public class MainWindowController {
    @FXML private FractalController fractalViewController;

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
