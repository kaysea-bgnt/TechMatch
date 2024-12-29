module appdev.techmatch {
    requires javafx.controls;
    requires javafx.fxml;


    opens appdev.techmatch to javafx.fxml;
    exports appdev.techmatch;
}