package com.phhs.app.tracker.phhsnjrotctrackerapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class WindowInit {
    private Stage stage;
    private FXMLLoader loader;
    private Scene scene;
    private Parent root;

    public WindowInit(String windowTitle, String fxmlString, boolean resizable, String imageIconPath) {
        try {
            this.loader = new FXMLLoader(TrackerApplication.class.getResource(fxmlString));
            this.root = loader.load();
            this.scene = new Scene(root);
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
            e.printStackTrace();
        }
    }

    public void showWindow() {
        stage.show();
    }

    public void closeWindow() {
        stage.close();
    }

}
