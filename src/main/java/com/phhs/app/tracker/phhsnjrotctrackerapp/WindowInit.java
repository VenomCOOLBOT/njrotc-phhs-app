package com.phhs.app.tracker.phhsnjrotctrackerapp;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class WindowInit {
    private Stage stage;

    public WindowInit(String windowTitle, String fxmlString, boolean resizable, String imageIconPath) {
        try {
            if (fxmlString == null || fxmlString.isEmpty()) {
                throw new IllegalArgumentException("FxmlString cannot be null or empty.");
            }

            FXMLLoader loader = new FXMLLoader(TrackerApplication.class.getResource(fxmlString));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            this.stage = new Stage();
            this.stage.setTitle(windowTitle);
            this.stage.setResizable(resizable);
            this.stage.setScene(scene);

            // Set the application icon
            if (imageIconPath != null && !imageIconPath.isEmpty()) {
                Image icon = new Image(Objects.requireNonNull(TrackerApplication.class.getResourceAsStream(imageIconPath)));
                stage.getIcons().add(icon);
            }
        } catch (IOException e) {
            handleException(e);
        }
    }

    public void showWindow() {
        ensureJavaFXThread();
        stage.show();
    }

    public void closeWindow() {
        ensureJavaFXThread();
        stage.close();
    }

    private void ensureJavaFXThread() {
        if (!Platform.isFxApplicationThread()) {
            // Call the method on the JavaFX Application Thread
            Platform.runLater(this::ensureJavaFXThread);
        }
    }

    private void handleException(Exception e) {
        // Handle exceptions more gracefully (e.g., show an error dialog, log to a file)
        e.printStackTrace();
    }
}
