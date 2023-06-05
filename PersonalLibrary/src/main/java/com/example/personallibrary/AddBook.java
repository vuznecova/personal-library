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
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;

public class AddBook {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Add;

    @FXML
    private Button Back;

    @FXML
    private ImageView Image;

    @FXML
    private TextField addAuthor;

    @FXML
    private TextField addID;

    @FXML
    private TextField addRating;

    @FXML
    private TextField addTitle;

    @FXML
    private Text errorMsg;

    @FXML
    private ImageView errorImg;

    @FXML
    void addBook(ActionEvent event) throws IOException {


        if (!addID.getText().isBlank() && !addRating.getText().isBlank() && !addTitle.getText().isBlank() && !addAuthor.getText().isBlank()) {
            try {
                int tempI = Integer.parseInt(addID.getText());
                double tempD = Double.parseDouble(addRating.getText());

                for (int i = 0; i < SignInController.bookList.size(); i++) {
                    if (SignInController.bookList.get(i).ID == (tempI)) {
                        throw new RuntimeException();
                    }
                }

                if (tempD > 10) {
                    errorMsg.setVisible(true);
                    errorImg.setVisible(true);
                    Image.setVisible(false);
                } else {

                    Book book = new Book(addTitle.getText(), addAuthor.getText(), tempI, tempD);
                    SignInController.bookList.add(book);
                    SignInController.bookSave.write(SignInController.bookList, 2);

                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
                    Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                }
            } catch (Exception e) {
                errorMsg.setVisible(true);
                errorImg.setVisible(true);
                Image.setVisible(false);
            }
        } else {
            errorMsg.setVisible(true);
            errorImg.setVisible(true);
            Image.setVisible(false);
        }
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}