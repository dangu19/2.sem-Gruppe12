package presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import domain.Account;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import domain.Login;
import javafx.stage.Stage;


public class AdminLoginController {
    Login login = new Login();
    boolean loggedIn;

    @FXML
    TextField userID, passwordID;
    @FXML
    Button signInBtn;
    @FXML
    Label notifierLbl;


    @FXML
    private void login(ActionEvent loginClicked)throws IOException {
        //Use login object to make accounts
        login.makeAccounts();

        String inputUserID = this.userID.getText();
        String inputPasswordID = this.passwordID.getText();

        Parent searchViewParent = FXMLLoader.load(getClass().getResource("adminView.fxml"));
        Scene searchViewScene = new Scene(searchViewParent);
        //This line gets the Stage information
        Stage window = (Stage) ((Node) loginClicked.getSource()).getScene().getWindow();

        for(Account e : login.getAccountsList()) {
            if(e.getUsername().equalsIgnoreCase(inputUserID) && e.getPassword().equalsIgnoreCase(inputPasswordID))
        {
            loggedIn = true;
            window.setTitle("Logget ind som admin");
            window.setScene(searchViewScene);
            window.show();
            break;
        }
        else
        {
            loggedIn = false;
            notifierLbl.setText("Wrong password! Try again.");
        }
        }
        System.out.println("logged in is " + loggedIn);
    }




    //This method will go back to startView
    public void AdminSwitchTostartView(ActionEvent BackClicked) throws IOException {

        //This method switches scene to primary
        Parent startViewParent = FXMLLoader.load(getClass().getResource("startView.fxml"));
        Scene startViewScene = new Scene(startViewParent);
        //This line gets the Stage information
        Stage window = (Stage) ((Node) BackClicked.getSource()).getScene().getWindow();
        window.setTitle("Login");
        window.setScene(startViewScene);
        window.show();

    }




}



