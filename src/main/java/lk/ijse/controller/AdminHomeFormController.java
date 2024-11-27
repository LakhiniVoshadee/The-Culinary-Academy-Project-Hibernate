package lk.ijse.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lk.ijse.service.BOFactory;
import lk.ijse.service.custom.AdminHomeBO;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminHomeFormController implements Initializable {

    @FXML
    private Label lblProgramCount;

    @FXML
    private Label lblStudentCount;

    @FXML
    private Label lblUsersCount;

    AdminHomeBO adminHomeBO = BOFactory.getBoFactory().getBO(BOFactory.BOTypes.AdminHomeBO);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentCount();
        programCount();
        userCount();
    }

    private void userCount() {lblUsersCount.setText(String.valueOf(adminHomeBO.userCount()));}

    private void programCount() {lblProgramCount.setText(String.valueOf(adminHomeBO.programCount()));}

    private void studentCount() {lblStudentCount.setText(String.valueOf(adminHomeBO.studentCount()));}
}
