package org.jfractals.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import org.jfractals.ui.MainWindowController;

/** Creates and owns the primary application window. */
public final class JFractalsApplication extends Application {
    private static final double INITIAL_WIN_WIDTH_PX = 720;
    private static final double INITIAL_WIN_HEIGHT_PX = 480;
    private static final String WIN_TITLE = "JFractals";

    private MainWindowController mainWindowController;

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = getClass().getResource("/org/jfractals/ui/main-window.fxml");
        FXMLLoader loader = new FXMLLoader(resource);
        Parent root = loader.load();
        mainWindowController = loader.getController();

        primaryStage.setTitle(WIN_TITLE);
        Scene scene = new Scene(root, INITIAL_WIN_WIDTH_PX, INITIAL_WIN_HEIGHT_PX);
        primaryStage.setScene(scene);
        primaryStage.setOnShown(_ -> mainWindowController.onViewReady(scene));

        URL logo = getClass().getResource("/org/jfractals/ui/logo_mandelbrot.png");
        if (logo != null) {
            primaryStage.getIcons().add(new Image(logo.toExternalForm()));
        }
        primaryStage.show();
    }

    @Override
    public void stop() {
        if (mainWindowController != null) {
            mainWindowController.close();
        }
    }
}
