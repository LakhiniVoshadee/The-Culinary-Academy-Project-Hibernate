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

public class AdminSidePanelController implements Initializable {

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
        Navigation.switchPaging(pagingPane, "adminHomeForm.fxml");

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("mainForm.fxml", event);


    }

    @FXML
    void btnProgramsOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "adminProgramForm.fxml");

    }

    @FXML
    void btnRegistrationOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "adminRegistrationForm.fxml");

    }

    @FXML
    void btnStudentsOnAction(ActionEvent event) throws IOException {
   Navigation.switchPaging(pagingPane, "adminStudentsForm.fxml");
    }

    @FXML
    void btnUsersOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "adminUserForm.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pagingPane.setVisible(true);
        try {
            Navigation.switchPaging(pagingPane, "adminHomeForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
