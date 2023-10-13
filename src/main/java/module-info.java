module com.phhs.app.tracker.phhsnjrotctrackerapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.phhs.app.tracker.phhsnjrotctrackerapp to javafx.fxml;
    exports com.phhs.app.tracker.phhsnjrotctrackerapp;
    exports com.phhs.app.tracker.phhsnjrotctrackerapp.controller;
    opens com.phhs.app.tracker.phhsnjrotctrackerapp.controller to javafx.fxml;
}