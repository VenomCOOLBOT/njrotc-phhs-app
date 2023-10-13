package com.phhs.app.tracker.phhsnjrotctrackerapp;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class TrackerApplication extends Application {
    private static TrackerApplication instance;
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
        loginPrompt();

        adminWindow = new WindowInit("NJROTC ADMIN", "admin-view.fxml", false, "/images/cool_logo.png");
        educationsWindow = new WindowInit("NJROTC EDUCATIONS", "educations-view.fxml", false, "/images/cool_logo.png");
        operationsWindow = new WindowInit("NJROTC OPERATIONS", "operations-view.fxml", false, "/images/cool_logo.png");
        supplyWindow = new WindowInit("NJROTC SUPPLY", "supply-view.fxml", false, "/images/cool_logo.png");
        paWindow = new WindowInit("NJROTC PUBLIC AFFAIRS", "pa-view.fxml", false, "/images/cool_logo.png");
        itWindow = new WindowInit("NJROTC INFORMATION TECHNOLOGY", "it-view.fxml", false, "/images/cool_logo.png");
    }
    private void loginPrompt() {
        loginWindow = new WindowInit("NJROTC LOGIN", "login-view.fxml", false, "/images/cool_logo.png");
        loginWindow.showWindow();
    }
    public static TrackerApplication getInstance() {
        return instance;
    }
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
