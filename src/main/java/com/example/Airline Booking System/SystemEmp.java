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

public class SystemEmp {
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
        Parent SceneParent = FXMLLoader.load(getClass().getResource("hello-emp.fxml"));
        Scene NewScene = new Scene(SceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NewScene);

        window.setTitle("Welcome!");
        window.show();
    }
    @FXML
    void btnCreate(ActionEvent event) throws Exception {
        if (txtName.getText().equals("") || txtName.getText().equals("") || txtName.getText().equals(""))
            label.setText("Fill the empty fields");
        try (FileWriter file = new FileWriter("D:\\Maryhan\\IN\\Employees.txt",true);
             PrintWriter in = new PrintWriter(file);){
            in.println(txtUser.getText()+","+txtPass.getText()+ "\n");
            label.setText("ADDED SUCCESSFULLY!!!");
        }
    }

}
