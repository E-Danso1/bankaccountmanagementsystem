module com.example.bankaccountmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bankaccountmanagementsystem to javafx.fxml;
    exports com.example.bankaccountmanagementsystem;
}