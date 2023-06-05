package com.example.project_oop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class First {

    @FXML
    void empbtn(ActionEvent event) throws IOException {
        Parent SceneParent = FXMLLoader.load(getClass().getResource("EmpLogin.fxml"));
        Scene NewScene = new Scene(SceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NewScene);

        window.setTitle("Login Page");
        window.show();
    }

    @FXML
    void travellerbtn(ActionEvent event) throws IOException {
        Parent SceneParent = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene NewScene = new Scene(SceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NewScene);

        window.setTitle("Login Page");
        window.show();

    }

}
