package com.phhs.app.tracker.phhsnjrotctrackerapp.controller;

import com.phhs.app.tracker.phhsnjrotctrackerapp.TrackerApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    public Button loginButton;
    @FXML
    private TextField usernameInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private void handleLoginButtonAction() {
        TrackerApplication trackerApplication = TrackerApplication.getInstance();
        String username = usernameInput.getText();
        String password = passwordInput.getText();

        if (isValidUser(username, password)) {
            openRelevantWindow(username, trackerApplication);
            trackerApplication.getLoginWindow().closeWindow();
            clearPasswordInput();
        } else {
            System.out.println("Invalid login credentials. Please try again.");
            clearPasswordInput();
        }
    }

    private boolean isValidUser(String username, String password) {
        // JDBC connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/dblogincredentials";
        String dbUser = "venom";
        String dbPassword = "Iamironman1!";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            // SQL query to check user credentials
            String query = "SELECT username, password FROM users WHERE username = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");

                // Verify the password (add password hashing here)
                if (password.equals(storedPassword)) {
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                    return true;
                }
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void openRelevantWindow(String username, TrackerApplication trackerApplication) {
        switch (username) {
            case "PHHS-N1":
                trackerApplication.getAdminWindow().showWindow();
                break;
            case "PHHS-N2":
                trackerApplication.getEducationsWindow().showWindow();
                break;
            case "PHHS-N3":
                trackerApplication.getOperationsWindow().showWindow();
                break;
            case "PHHS-N4":
                trackerApplication.getSupplyWindow().showWindow();
                break;
            case "PHHS-N5":
                trackerApplication.getPAWindow().showWindow();
                break;
            case "PHHS-N6":
                trackerApplication.getITWindow().showWindow();
                break;
            default:
                break;
        }
    }


    private void clearPasswordInput() {
        passwordInput.clear();
    }
}
