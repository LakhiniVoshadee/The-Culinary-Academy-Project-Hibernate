package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.util.Navigation;

import java.io.IOException;

public class UserLoginFormController {

    @FXML
    private Hyperlink hyperFP;

    @FXML
    private Hyperlink hyperSignUp;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;



    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("userSidePanel.fxml", event);

    }

    @FXML
    void linkForgotPassword(ActionEvent event) {

    }

    @FXML
    void linkSignUp(ActionEvent event) {

    }

}
