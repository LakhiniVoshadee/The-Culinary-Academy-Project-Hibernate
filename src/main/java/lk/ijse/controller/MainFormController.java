package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.ijse.util.Navigation;

public class MainFormController {

    @FXML
    private JFXButton btnAdmin;

    @FXML
    private JFXButton btnUser;


    @FXML
    void btnAdminOnAction(ActionEvent event) {
        btnAdmin.getScene().getWindow().hide();
        Navigation.changeStage("/view/adminLoginForm.fxml", "Admin Login Form");

    }

    @FXML
    void btnUserOnAction(ActionEvent event) {
        btnUser.getScene().getWindow().hide();
        Navigation.changeStage("/view/userLoginForm.fxml", "User Form");

    }

}
