package org.jfractals.ui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;

public class MainWindowController {
    private final FractalExportDialog exportDialog = new FractalExportDialog();
    private final ViewOptions viewOptions = new ViewOptions();
    @FXML private FractalController fractalViewController;
    @FXML private CheckMenuItem showScaleMenuItem;
    @FXML private CheckMenuItem showInfoLabel;
    @FXML private CheckMenuItem showZoomMenuItem;
    @FXML private CheckMenuItem showCenterCoordinatesMenuItem;
    @FXML private CheckMenuItem showAxesMenuItem;

    @FXML
    private void initialize() {
        showScaleMenuItem.selectedProperty().bindBidirectional(viewOptions.getShowScaleProperty());
        showInfoLabel.selectedProperty().bindBidirectional(viewOptions.getShowInfoLabelProperty());
        showZoomMenuItem.selectedProperty().bindBidirectional(viewOptions.getShowZoomProperty());
        showCenterCoordinatesMenuItem.selectedProperty().bindBidirectional(viewOptions.getShowCenterCoordinatesProperty());
        showAxesMenuItem.selectedProperty().bindBidirectional(viewOptions.getShowAxesProperty());
        fractalViewController.setViewOptions(viewOptions);
    }

    @FXML private void resetView() {
        fractalViewController.resetView();
    }

    @FXML private void showSettings() {
        fractalViewController.showSettings();
    }

    @FXML private void showExportDialog() {
        exportDialog.show();
    }

    public void onViewReady(Scene scene) {
        fractalViewController.onViewReady(scene);
    }

    public void close() {
        fractalViewController.close();
    }
}
