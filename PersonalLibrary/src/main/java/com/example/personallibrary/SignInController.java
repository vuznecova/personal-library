package com.example.personallibrary;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignInController {

    public static List < User > userList;
    public static Save < List < User >> userSave;
    public static List < Book > bookList;
    public static Save < List < Book >> bookSave;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Login1;

    @FXML
    private Button NewAccount;

    @FXML
    private PasswordField Password1;

    @FXML
    private Button SignIn;

    @FXML
    void logIn(ActionEvent event) throws IOException {

        for (int i = 0; i < SignInController.userList.size(); i++) {
            if (SignInController.userList.get(i).Login.equals(Login1.getText())) {
                if (SignInController.userList.get(i).Password.equals(Password1.getText())) {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
                    Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                }
            }
        }
    }

    @FXML
    void newAccount(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewAccController.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void initialize() {
        userSave = new Save < > ();
        userList = (List < User > ) userSave.read(1);
        if (userList == null) {
            userList = new ArrayList < > ();
        }

        bookSave = new Save < > ();
        bookList = (List < Book > ) bookSave.read(2);
        if (bookList == null) {
            bookList = new ArrayList < > ();
        }
    }
}