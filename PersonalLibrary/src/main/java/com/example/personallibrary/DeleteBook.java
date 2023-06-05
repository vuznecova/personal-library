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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeleteBook {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Back;

    @FXML
    private Button Delete;

    @FXML
    private TextField addID;

    @FXML
    private ImageView errorImg;

    @FXML
    private Text errorMsg;

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void deleteBook(ActionEvent event) throws IOException {
        if (!addID.getText().isBlank()) {

            boolean Exists = false;
            int currentID = Integer.parseInt(addID.getText());

            for (int i = 0; i < SignInController.bookList.size(); i++) {
                if (SignInController.bookList.get(i).ID == currentID) {
                    SignInController.bookList.remove(i);
                    Exists = true;

                    SignInController.bookSave.write(SignInController.bookList, 2);

                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                }
            }

            if (!Exists) {
                errorMsg.setVisible(true);
                errorImg.setVisible(true);
            }
        } else {
            errorMsg.setVisible(true);
            errorImg.setVisible(true);
        }
    }
}
