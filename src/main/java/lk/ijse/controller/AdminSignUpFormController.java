package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import lk.ijse.entity.Admin;
import lk.ijse.util.Navigation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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



