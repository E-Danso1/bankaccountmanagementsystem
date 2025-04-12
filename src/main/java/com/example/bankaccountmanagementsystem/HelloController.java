package com.example.bankaccountmanagementsystem;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Text earn;

    @FXML
    private Text ok;

    @FXML
    private Text good;

    @FXML
    private TextField amount;



    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void withdraw() {
        ok.setText("Withdrawal successfull" + amount.getText());
    }

    @FXML
    protected void createAccount() {
        good.setText("Account Successfully Created");
    }


    @FXML
    protected void deposit() {
       earn.setText("deposit successfull" + amount.getText());


        System.out.print(amount.getText());
    }
}
