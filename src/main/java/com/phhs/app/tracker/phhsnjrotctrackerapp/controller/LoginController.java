package com.phhs.app.tracker.phhsnjrotctrackerapp.controller;

import com.phhs.app.tracker.phhsnjrotctrackerapp.TrackerApplication;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.HashMap;
import java.util.Map;

public class LoginController {
    @FXML
    private TextField usernameInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private void handleLoginButtonAction() {
        TrackerApplication trackerApplication = TrackerApplication.getInstance();
        String username = usernameInput.getText();
        String password = passwordInput.getText();

        Map<String, String> usernamePasswordMap = new HashMap<>();
        usernamePasswordMap.put("PHHS-N1", "123");
        usernamePasswordMap.put("PHHS-N2", "456");
        usernamePasswordMap.put("PHHS-N3", "789");
        usernamePasswordMap.put("PHHS-N4", "987");
        usernamePasswordMap.put("PHHS-N5", "vernonisCUTE");
        usernamePasswordMap.put("PHHS-N6", "321");

        boolean isValidUser = usernamePasswordMap.containsKey(username) && usernamePasswordMap.get(username).equals(password);

        if (isValidUser) {
            switch (username) {
                case "PHHS-N1" -> trackerApplication.getAdminWindow().showWindow();
                case "PHHS-N2" -> trackerApplication.getEducationsWindow().showWindow();
                case "PHHS-N3" -> trackerApplication.getOperationsWindow().showWindow();
                case "PHHS-N4" -> trackerApplication.getSupplyWindow().showWindow();
                case "PHHS-N5" -> trackerApplication.getPAWindow().showWindow();
                case "PHHS-N6" -> trackerApplication.getITWindow().showWindow();
            }
            trackerApplication.getLoginWindow().closeWindow();
        } else {
            System.out.println("WRONG INPUT");
        }
    }
}
