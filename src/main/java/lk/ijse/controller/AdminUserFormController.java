package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.UserDTO;
import lk.ijse.service.BOFactory;
import lk.ijse.service.custom.UserBO;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminUserFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colMobile;

    @FXML
    private TableColumn<?, ?> colPassword;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private TableColumn<?, ?> colUserName;

    @FXML
    private AnchorPane pagingPane;

    @FXML
    private TableView<?> tblUser;

    @FXML
    private TextField userAddress;

    @FXML
    private TextField userEmail;

    @FXML
    private TextField userID;

    @FXML
    private TextField userMobile;

    @FXML
    private TextField userName;

    @FXML
    private TextField userPassword;

    UserBO userBO = BOFactory.getBoFactory().getBO(BOFactory.BOTypes.UserBO);

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
        new Alert(Alert.AlertType.CONFIRMATION,"Clear Successfully").show();
    }

    private void clearFields() {
        userID.clear();
        userName.clear();
        userPassword.clear();
        userEmail.clear();
        userMobile.clear();
        userAddress.clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if(userID.getText().isEmpty() || userName.getText().isEmpty() || userPassword.getText().isEmpty()  || userEmail.getText().isEmpty()|| userMobile.getText().isEmpty() || userAddress.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please Fill All Empty Fileds Before Add New User !").show();
        }  else {
            String id = userID.getText();
            String name = userName.getText();
            String password = userPassword.getText();
            String mobile = userEmail.getText();
            String email = userMobile.getText();
            String address = userAddress.getText();


                UserDTO userDTO = new UserDTO(id,name,password,mobile,email,address);
                boolean saved =   userBO.saveUsers(userDTO);
                if(saved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved Successfully").show();
                    loadAllUsers();
                }
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllUsers();
    }

    private void loadAllUsers() {

    }
}
