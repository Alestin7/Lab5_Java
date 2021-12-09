module com.example.lab6java {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires simplejson.to.easyjson;

    opens com.example.lab6java to javafx.fxml;
    exports com.example.lab6java;
}