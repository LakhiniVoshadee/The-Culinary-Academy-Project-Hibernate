package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import lk.ijse.util.Navigation;

import java.io.IOException;

public class AdminSignUpFormController {

    @FXML
    private ImageView btnBackOnAction;

    @FXML
    private JFXButton btnLeftBack;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private TextField txtPwd;

    @FXML
    private TextField txtUserId;

    @FXML
    private TextField txtUserName;


    @FXML
    void btnBackOnAction(ActionEvent event) {
        btnLeftBack.getScene().getWindow().hide();
        Navigation.changeStage("/view/adminLoginForm.fxml", "ADMIN Login FORM");

    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("adminLoginForm.fxml", event);

    }
}



