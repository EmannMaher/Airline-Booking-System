package com.example.project_oop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AfterLogin {

    @FXML
    void btnBack(ActionEvent event) throws IOException {
        Parent SceneParent = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene NewScene = new Scene(SceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.setTitle("Login Page");
        window.show();
    }

    @FXML
    void btnBookTicket(ActionEvent event) throws IOException {
        Parent SceneParent = FXMLLoader.load(getClass().getResource("BookTicket.fxml"));
        Scene NewScene = new Scene(SceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.setTitle("Book Ticket");
        window.show();
    }

    @FXML
    void btnCancelTicket(ActionEvent event) throws IOException {
        Parent SceneParent = FXMLLoader.load(getClass().getResource("Cancelticket.fxml"));
        Scene NewScene = new Scene(SceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.setTitle("Cancel Ticket");
        window.show();
    }

}
