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

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AddFlight {
        @FXML
        private TextField txtid;

        @FXML
        private TextField txtname;

        @FXML
        private TextField txtsource;

        @FXML
        private TextField txtdest;

        @FXML
        private TextField txtdate;

        @FXML
        private TextField txtarr;

        @FXML
        private TextField txtdeparture;

        @FXML
        private TextField txtprice;
        @FXML
        private TextField txtcapacity;
        @FXML
        private Label label;

        ArrayList<Flight> flights=new ArrayList<>();
        @FXML
        void btadd(ActionEvent event) throws Exception {
                if (txtid.getText().equals("") || txtname.getText().equals("") || txtsource.getText().equals("")
                || txtdest.getText().equals("") || txtarr.getText().equals("") || txtdeparture.getText().equals("")
                        ||txtprice.getText().equals(""))
                        label.setText("Fill the empty fields!!");
                Flight f = new Flight(txtid.getText(),txtname.getText() ,txtdate.getText() ,txtsource.getText()
                        ,txtdest.getText(),txtarr.getText() ,txtdeparture.getText(),txtcapacity.getText(), txtprice.getText());
                flights.add(f);
                try (FileWriter file = new FileWriter("IN\\Flights.txt",true);
                     PrintWriter in = new PrintWriter(file);){
                        in.println(txtid.getText()+","+txtname.getText()+","+txtdate.getText()+","+txtsource.getText()+","+
                                txtdest.getText()+","+txtarr.getText()+","+txtdeparture.getText()+","+txtcapacity.getText()+","+txtprice.getText());
                        label.setText("ADDED SUCCESSFULLLY!!!");
                }

        }

        @FXML
        void bthome(ActionEvent event) throws IOException {
                Parent SceneParent = FXMLLoader.load(getClass().getResource("hello-emp.fxml"));
                Scene NewScene = new Scene(SceneParent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(NewScene);
                window.setTitle("Arline Ticket Booking System");
                window.show();

        }



}
