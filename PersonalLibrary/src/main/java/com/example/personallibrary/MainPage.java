package com.example.personallibrary;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class MainPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Add;

    @FXML
    private Button Delete;

    @FXML
    private Button Edit;

    @FXML
    private TextField editAuthor;

    @FXML
    private TextField editID;

    @FXML
    private TextField editRating;

    @FXML
    private TextField editTitle;

    @FXML
    public TableView < Book > table;

    @FXML
    public TableColumn < Book, Integer > colID;

    @FXML
    public TableColumn < Book, String > colTitle;

    @FXML
    public TableColumn < Book, String > colAuthor;

    @FXML
    public TableColumn < Book, Double > colRating;

    @FXML
    private Button SignOut;

    @FXML
    void add(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AddBook.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void delete(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DeleteBook.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void rowClicked(MouseEvent event) {
        Book clickedBook = table.getSelectionModel().getSelectedItem();
        editID.setText(String.valueOf(clickedBook.getID()));
        editTitle.setText(String.valueOf(clickedBook.getTitle()));
        editAuthor.setText(String.valueOf(clickedBook.getAuthor()));
        editRating.setText(String.valueOf(clickedBook.getRating()));
    }

    @FXML
    void edit(ActionEvent event) {
        ObservableList<Book> currentData = table.getItems();
        int currentID = Integer.parseInt(editID.getText());

        for (Book book : currentData) {
            if (book.getID() == currentID) {
                book.setTitle(editTitle.getText());
                book.setAuthor(editAuthor.getText());
                book.setRating(Double.parseDouble(editRating.getText()));

                SignInController.bookSave.write(SignInController.bookList, 2);

                table.setItems(currentData);
                table.refresh();
                break;
            }
        }
    }

    @FXML
    void Help(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Help1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void signOut(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignInController.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        colID.setCellValueFactory(new PropertyValueFactory < Book, Integer > ("ID"));
        colTitle.setCellValueFactory(new PropertyValueFactory < Book, String > ("Title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory < Book, String > ("Author"));
        colRating.setCellValueFactory(new PropertyValueFactory < Book, Double > ("Rating"));

        ObservableList < Book > bookObservableList = FXCollections.observableList(SignInController.bookList);
        if (bookObservableList != null) {
            table.setItems(bookObservableList);
        }
    }

}