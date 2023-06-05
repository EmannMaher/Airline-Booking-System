package com.example.project_oop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloEmp {

    @FXML
    void AddAirLine(ActionEvent event) throws IOException {
        Parent SceneParent = FXMLLoader.load(getClass().getResource("AddFlight.fxml"));
        Scene NewScene = new Scene(SceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.setTitle("Add New Airline");
        window.show();
    }

    @FXML
    void AddEmp(ActionEvent event) throws IOException {
        Parent SceneParent = FXMLLoader.load(getClass().getResource("SystemEmp.fxml"));
        Scene NewScene = new Scene(SceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.setTitle("Add New Employee");
        window.show();
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent SceneParent = FXMLLoader.load(getClass().getResource("EmpLogin.fxml"));
        Scene NewScene = new Scene(SceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.setTitle("Login Page");
        window.show();
    }

}
