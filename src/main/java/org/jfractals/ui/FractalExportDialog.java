package org.jfractals.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FractalExportDialog implements AutoCloseable {
    private static final String WIN_TITLE = "Fractal Export";

    private Stage stage;

    void show() {
        if (stage != null && stage.isShowing()) {
            stage.toFront();
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FractalExportDialog.fxml"));
            Parent content = loader.load();

            stage = new Stage();
            stage.setTitle(WIN_TITLE);
            stage.setScene(new Scene(content));
            stage.setOnHidden(_ -> stage = null);
            stage.show();
        } catch (IOException e) {
            throw new IllegalStateException("Could not open fractal export dialog", e);
        }
    }

    @Override
    public void close() {
        if (stage != null) stage.close();
    }
}
