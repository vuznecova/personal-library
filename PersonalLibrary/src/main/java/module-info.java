module com.example.personallibrary {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.personallibrary to javafx.fxml;
    exports com.example.personallibrary;
}