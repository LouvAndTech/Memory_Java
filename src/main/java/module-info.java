module com.memory.memory {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.memory.memory to javafx.fxml;
    exports com.memory.memory;
}