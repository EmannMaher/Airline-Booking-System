package com.example.project_oop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class BookTicket implements Initializable {
    @FXML
    private Label TxtArrival;

    @FXML
    private Label TxtDeparture;

    @FXML
    private Label TxtDest;

    @FXML
    private TextField TxtDestFlight;

    @FXML
    private Label TxtFlightName;

    @FXML
    private Label TxtFlightNum;

    @FXML
    private Label TxtID;

    @FXML
    private TextField TxtName;

    @FXML
    private Label TxtPrice;

    @FXML
    private TextField TxtSeats;

    @FXML
    private Label TxtSource;

    @FXML
    private TextField TxtSourceFlight;

    @FXML
    private Label TxtTotalPrice;

    @FXML
    private Label label;

    @FXML
    private TextField txtdate1;

    @FXML
    private Label txtdate2;

    @FXML
    private ComboBox SpecialAdditions;
    @FXML
    private ComboBox TypeOfSeats;

    Random rand = new Random();
    int upperbound = 9999999;
    int ticket = rand.nextInt(upperbound);
    File file = new File("IN\\Flights.txt");
    File file2 = new File("IN\\Tickets.txt");
    Scanner s;
    Scanner s2;

    {
        try {
            s = new Scanner(file);
            s2= new Scanner(file2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public  BookTicket() {

    }

    public void BtnSearch(ActionEvent event) {
        String d;
        if (TxtSourceFlight.getText().equals("") || TxtDestFlight.getText().equals("") || txtdate1.getText().equals("")) {
            label.setText("Fill The Empty Fields !!");
        } else {
            while ((d = s.next()) != null) {
                String[] data = d.split(",");


                if (TxtSourceFlight.getText().equals(data[3]) && TxtDestFlight.getText().equals(data[4]) && txtdate1.getText().equals(data[2])) {
                    TxtID.setText(data[0]);
                    TxtFlightName.setText(data[1]);
                    txtdate2.setText(data[2]);
                    TxtSource.setText(data[3]);
                    TxtDest.setText(data[4]);
                    TxtArrival.setText(data[5]);
                    TxtDeparture.setText(data[6]);
                    TxtPrice.setText(data[8]);
                    TxtFlightNum.setText(String.valueOf(ticket));
                    break;
                } else {
                    label.setText("This Flight is not available :(");
                }
            }
        }
    }

        @FXML
        void BtnBook(ActionEvent event) throws Exception {
            if (!label.getText().equals("") || TxtName.getText().equals("") || TxtFlightNum.getText().equals("")){
                label.setText("Fill The Empty Fields");
                throw new Exception("Must Enter Valid Data");
            }
            else {
                try (FileWriter file = new FileWriter("IN\\Tickets.txt", true);
                     PrintWriter in = new PrintWriter(file);) {
                    in.println(TxtFlightNum.getText()+","+TxtID.getText()+","+TxtFlightName.getText()+","+TxtSource.getText()+","
                    +TxtDest.getText()+","+TxtArrival.getText()+","+TxtDeparture.getText()+","+TxtTotalPrice.getText()
                    +","+TxtSeats.getText()+","+TxtName.getText());
                    label.setText("BOOKED SUCCESSFULLY!!!");
                }
            }
        }

    @Override
    public void initialize (URL url , ResourceBundle rb){
        ObservableList<String> list = FXCollections.observableArrayList("Economy Seats","Main Cabin Seats");
        ObservableList<String> list1 = FXCollections.observableArrayList("WIFI","TV","Special Meal","Nothing");
        TypeOfSeats.setItems(list);
        SpecialAdditions.setItems(list1);
    }

        @FXML
        void getPrice(ActionEvent event) {
            Double S = Double.parseDouble(TxtSeats.getText());
            String s = TypeOfSeats.getSelectionModel().getSelectedItem().toString();
            String y = SpecialAdditions.getSelectionModel().getSelectedItem().toString();
            if (s.equals("Economy Seats") && y.equals("Nothing")){
                Seats Seat = new EconomySeat(Double.parseDouble(TxtPrice.getText()));
                Double C = (Seat.getCost());
                TxtTotalPrice.setText(String.valueOf(S*C));
            }
            else if (s.equals("Economy Seats") && y.equals("WIFI")){
                Seats Seat = new WiFi(new EconomySeat(Double.parseDouble(TxtPrice.getText()))) ;
                Double C = (Seat.getCost());
                TxtTotalPrice.setText(String.valueOf(S*C));
            }
            else if (s.equals("Economy Seats") && y.equals("TV")){
                Seats Seat = new TV(new EconomySeat(Double.parseDouble(TxtPrice.getText()))) ;
                Double C = (Seat.getCost());
                TxtTotalPrice.setText(String.valueOf(S*C));
            }
            else if (s.equals("Economy Seats") && y.equals("Special Meal")){
                Seats Seat = new SpecialMeal(new EconomySeat(Double.parseDouble(TxtPrice.getText()))) ;
                Double C = (Seat.getCost());
                TxtTotalPrice.setText(String.valueOf(S*C));
            }
            else if (s.equals("Main Cabin Seats") && y.equals("Nothing")){
                Seats Seat = new MainCabinSeat(Double.parseDouble(TxtPrice.getText()));
                Double C = (Seat.getCost());
                TxtTotalPrice.setText(String.valueOf(S*C));
            }
            else if (s.equals("Main Cabin Seats") && y.equals("WIFI")){
                Seats Seat = new WiFi(new MainCabinSeat(Double.parseDouble(TxtPrice.getText()))) ;
                Double C = (Seat.getCost());
                TxtTotalPrice.setText(String.valueOf(S*C));
            }
            else if (s.equals("Main Cabin Seats") && y.equals("TV")){
                Seats Seat = new TV(new MainCabinSeat(Double.parseDouble(TxtPrice.getText()))) ;
                Double C = (Seat.getCost());
                TxtTotalPrice.setText(String.valueOf(S*C));
            }
            else if (s.equals("Main Cabin Seats") && y.equals("Special Meal")){
                Seats Seat = new SpecialMeal(new MainCabinSeat(Double.parseDouble(TxtPrice.getText()))) ;
                Double C = (Seat.getCost());
                TxtTotalPrice.setText(String.valueOf(S*C));
            }
            else
            {
                label.setText("Invalid Input");
            }

        }

        @FXML
        void BtnHome(ActionEvent event) throws IOException {
            Parent SceneParent = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
            Scene NewScene = new Scene(SceneParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(NewScene);
            window.show();

        }
    @FXML
    void BtnPrint(ActionEvent event) {
        label.setText("Go To The Nearest Copy Center OR Take Screen Shot");
    }

}
