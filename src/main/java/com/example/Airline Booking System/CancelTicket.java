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
import java.util.Scanner;

public class CancelTicket {

        @FXML
        private Label TxtArrival;

        @FXML
        private Label TxtDeparture;

        @FXML
        private Label TxtDest;

        @FXML
        private Label TxtFlightID;

        @FXML
        private Label TxtFlightName;

        @FXML
        private Label TxtName;

        @FXML
        private Label TxtPrice;

        @FXML
        private Label TxtSeats;

        @FXML
        private Label TxtSource;

        @FXML
        private TextField TxtTicketNum;

        @FXML
        private Label label;
        Scanner s1;
        Scanner s2;

        {
                try {
                        s1 = new Scanner(new File("IN\\Tickets.txt"));
                        s2 = new Scanner(new File("IN\\Temp.txt"));
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
        }
        @FXML
        void BtnCancel(ActionEvent event) throws IOException {
                String d;
                try (FileWriter f = new FileWriter("IN\\Tickets.txt");
                     PrintWriter in = new PrintWriter(f);) {
                        in.println("");
                }
                File file = new File("IN\\Temp.txt");
                Scanner s = new Scanner(file);
                if (TxtTicketNum.getText().equals("")) {
                        label.setText("Fill The Empty Fields !!");
                        try {
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                } else {
                        while ((d = s.next()) != null) {
                                String[] data = d.split(",");
                                try (FileWriter f = new FileWriter("IN\\Tickets.txt", true);
                                     PrintWriter in = new PrintWriter(f);) {
                                        in.println(d);
                                }
                                label.setText("CANCELLED SUCCESSFULLY !!");
                        }
                }
        }


        @FXML
        void BtnHome(ActionEvent event) throws IOException {
                Parent SceneParent = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
                Scene NewScene = new Scene(SceneParent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(NewScene);
                window.setTitle("Arline Ticket Booking System");
                window.show();
        }


        @FXML
        void BtnSearch(ActionEvent event) throws IOException {
                try (FileWriter f = new FileWriter("IN\\Temp.txt");
                     PrintWriter in = new PrintWriter(f);) {
                        in.println("");
                }
                String d;
                File file = new File("IN\\Tickets.txt");
                Scanner s = new Scanner(file);
                if (TxtTicketNum.getText().equals("")) {
                        label.setText("Fill The Empty Fields !!");
                        try {
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                } else {
                        while ((d = s.next()) != null) {
                                String[] data = d.split(",");

                                if (TxtTicketNum.getText().equals(data[0])) {
                                        TxtFlightID.setText(data[1]);
                                        TxtFlightName.setText(data[2]);
                                        TxtSource.setText(data[3]);
                                        TxtDest.setText(data[4]);
                                        TxtArrival.setText(data[5]);
                                        TxtDeparture.setText(data[6]);
                                        TxtPrice.setText(data[7]);
                                        TxtSeats.setText(data[8]);
                                        TxtName.setText(data[9]);
                                } else {
                                        try (FileWriter f = new FileWriter("IN\\Temp.txt", true);
                                             PrintWriter in = new PrintWriter(f);) {
                                                in.println(d);
                                        }
                                }
                        }
                }
        }

}
