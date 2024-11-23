package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import lk.ijse.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminSidePanelController implements Initializable {

    @FXML
    private JFXButton btnDashBoard;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnPrograms;

    @FXML
    private JFXButton btnRegistration;

    @FXML
    private JFXButton btnStudents;

    @FXML
    private JFXButton btnUsers;

    @FXML
    private Pane pagingPane;

    @FXML
    void btnDashBoardOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "homeForm.fxml");

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("mainForm.fxml", event);


    }

    @FXML
    void btnProgramsOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "programForm.fxml");

    }

    @FXML
    void btnRegistrationOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "registrationForm.fxml");

    }

    @FXML
    void btnStudentsOnAction(ActionEvent event) throws IOException {
   Navigation.switchPaging(pagingPane, "studentsForm.fxml");
    }

    @FXML
    void btnUsersOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pagingPane.setVisible(true);
        try {
            Navigation.switchPaging(pagingPane, "homeForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
