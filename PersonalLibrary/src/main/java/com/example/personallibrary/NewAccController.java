package com.example.personallibrary;

import java.io.IOException;
import java.net.URL;
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

public class NewAccController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NewLogin;

    @FXML
    private PasswordField NewPassword;

    @FXML
    private Button Register;

    @FXML
    private Button SignIn;

    @FXML
    void signIn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignInController.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void register(ActionEvent event) throws IOException {
        if (!NewLogin.getText().isBlank() && !NewPassword.getText().isBlank()) {
            User user = new User();
            user.Login = NewLogin.getText();
            user.Password = NewPassword.getText();
            SignInController.userList.add(user);
            SignInController.userSave.write(SignInController.userList, 1);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }
    }
}
