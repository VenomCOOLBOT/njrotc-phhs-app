package com.phhs.app.tracker.phhsnjrotctrackerapp;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class TrackerApplication extends Application {
    private static TrackerApplication instance;

    private static final String APP_ICON_PATH = "/images/cool_logo.png";
    private static final String WINDOW_TITLE_PREFIX = "NJROTC";

    private WindowInit loginWindow;
    private WindowInit adminWindow;
    private WindowInit educationsWindow;
    private WindowInit operationsWindow;
    private WindowInit supplyWindow;
    private WindowInit paWindow;
    private WindowInit itWindow;

    @Override
    public void start(Stage primaryStage) throws IOException {
        instance = this;
        loginWindow = createWindow("LOGIN", "login-view.fxml");
        adminWindow = createWindow("ADMIN", "admin-view.fxml");
        educationsWindow = createWindow("EDUCATIONS", "educations-view.fxml");
        operationsWindow = createWindow("OPERATIONS", "operations-view.fxml");
        supplyWindow = createWindow("SUPPLY", "supply-view.fxml");
        paWindow = createWindow("PUBLIC AFFAIRS", "pa-view.fxml");
        itWindow = createWindow("INFORMATION TECHNOLOGY", "it-view.fxml");

        loginWindow.showWindow();
    }

    private WindowInit createWindow(String title, String fxmlFile) {
        return new WindowInit(WINDOW_TITLE_PREFIX + " " + title, fxmlFile, false, APP_ICON_PATH);
    }

    public static TrackerApplication getInstance() {
        return instance;
    }

    // Getters for your windows
    public WindowInit getLoginWindow() {
        return loginWindow;
    }

    public WindowInit getAdminWindow() {
        return adminWindow;
    }

    public WindowInit getEducationsWindow() {
        return educationsWindow;
    }

    public WindowInit getOperationsWindow() {
        return operationsWindow;
    }

    public WindowInit getSupplyWindow() {
        return supplyWindow;
    }

    public WindowInit getPAWindow() {
        return paWindow;
    }

    public WindowInit getITWindow() {
        return itWindow;
    }

    public static void main(String[] args) {
        launch();
    }
}
