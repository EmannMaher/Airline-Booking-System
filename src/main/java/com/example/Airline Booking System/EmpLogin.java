package com.example.project_oop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class EmpLogin{

    @FXML
    private PasswordField txtpassword;
    @FXML
    private TextField txtusername;
    @FXML
    private Label label;
    File file = new File("IN\\Employees.txt");
    Scanner s;

    {
        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void login(ActionEvent event) throws IOException {
        String d;
        while ( (d = s.next()) != null)
        {
            String[] data = d.split(",");
            if (txtusername.getText().equals("") && txtpassword.getText().equals(""))
            {
                label.setText("Enter Username and Password !!");
                break;
            }

            else if (txtusername.getText().equals(data[0]) && txtpassword.getText().equals(data[1]))
            {
                Parent SceneParent = FXMLLoader.load(getClass().getResource("hello-emp.fxml"));
                Scene NewScene = new Scene(SceneParent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(NewScene);
                window.setTitle("Welcome Back !!");
                window.show();
                break;
            }
            else
            {
                label.setText("Wrong Username or Password :(");
            }
        }
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent SceneParent = FXMLLoader.load(getClass().getResource("First.fxml"));
        Scene NewScene = new Scene(SceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.setTitle("Login Page");
        window.show();
    }
}
