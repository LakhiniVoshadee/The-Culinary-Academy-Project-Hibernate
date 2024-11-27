package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lk.ijse.util.Navigation;

import java.io.IOException;

public class AdminLoginFormController {

    @FXML
    private Hyperlink hyperFP;

    @FXML
    private Hyperlink hyperSignUp;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private JFXButton btnLeftBack;


    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
       // Navigation.switchNavigation("adminSidePanel.fxml", event);
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        if (userName.equals("admin") && password.equals("admin")) {
            Navigation.switchNavigation("adminSidePanel.fxml", event);
        }else {
            new Alert(Alert.AlertType.ERROR, "Invalid User Name or Password").show();
        }


    }

    @FXML
    void linkForgotPassword(ActionEvent event) {

    }

    @FXML
    void linkSignUp(ActionEvent event) throws IOException {
        Navigation.switchNavigation("adminSignUpForm.fxml", event);


    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        btnLeftBack.getScene().getWindow().hide();
        Navigation.changeStage("/view/mainForm.fxml","MAIN FORM");

    }



}
