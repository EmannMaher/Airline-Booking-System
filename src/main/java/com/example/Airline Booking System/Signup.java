package com.example.project_oop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;

public class Signup {
    @FXML
    private Label label;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPass;

    @FXML
    private TextField txtUser;
    @FXML
    void btnBack(ActionEvent event) throws IOException {
        Parent SceneParent = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene NewScene = new Scene(SceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NewScene);

        window.setTitle("Login Page");
        window.show();
    }
    ArrayList<Passengers> passengersList = new ArrayList<>() ;


    @FXML
    void btnCreate(ActionEvent event) throws Exception {
        if (txtName.getText().equals("") || txtUser.getText().equals("") || txtPass.getText().equals(""))
            throw new Exception();
        Passengers passenger = new Passengers(txtName.getText(),txtUser.getText(),txtPass.getText());
        passengersList.add(passenger);
        try (FileWriter file = new FileWriter("IN\\Data.txt",true);
             PrintWriter in = new PrintWriter(file);){
            in.println(txtUser.getText()+","+txtPass.getText());
            label.setText("ADDED SUCCESSFULLY!!!");
        }
        }

}
