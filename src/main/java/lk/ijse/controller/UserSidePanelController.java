package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import lk.ijse.util.Navigation;

import java.io.IOException;

public class UserSidePanelController {

    @FXML
    private Pane pagingPane;

    @FXML
    void btnDashBoardOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "userHomeForm.fxml");

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("mainForm.fxml", event);

    }

    @FXML
    void btnRegistrationOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "userRegistrationForm.fxml");

    }

}
