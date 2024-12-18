package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.UserDTO;
import lk.ijse.service.BOFactory;
import lk.ijse.service.custom.UserBO;
import lk.ijse.tm.UserTM;
import lk.ijse.util.DataValidateController;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class AdminUserFormController implements Initializable {

    UserBO userBO = BOFactory.getBoFactory().getBO(BOFactory.BOTypes.UserBO);
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
    private TableView<UserTM> tblUser;
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

    @FXML
    private Label lblAddressValidate;

    @FXML
    private Label lblEmailValidate;

    @FXML
    private Label lblIdValidate;

    @FXML
    private Label lblMobileValidate;

    @FXML
    private Label lblNameValidate;

    @FXML
    private Label lblPasswordValidate;


    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
        new Alert(Alert.AlertType.CONFIRMATION, "Clear Successfully").show();
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
        String id = userID.getText();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        boolean deleted = userBO.deleteUsers(userDTO);
        if (deleted) {
            System.out.println("Delete Successfully");
            new Alert(Alert.AlertType.CONFIRMATION, "Delete Successfully").show();
            loadAllUsers();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {
        if (validateInputFields()) {
            String id = userID.getText();
            String name = userName.getText();
            String password = userPassword.getText();
            String email = userEmail.getText();
            String mobile = userMobile.getText();
            String address = userAddress.getText();

            UserDTO userDTO = new UserDTO(id, name, password, email, mobile, address);
            boolean saved = userBO.saveUsers(userDTO);
            if (saved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved Successfully").show();
                loadAllUsers();
                clearFields();
                generateUserId();
            }
        }
    }

    private boolean validateInputFields() {
        boolean isValid = true;

        if (!DataValidateController.userIdValidate(userID.getText())) {
            lblIdValidate.setText("Invalid User ID!");
            isValid = false;
        } else {
            lblIdValidate.setText("");
        }

        if (!DataValidateController.userNameValidate(userName.getText())) {
            lblNameValidate.setText("Invalid User Name!");
            isValid = false;
        } else {
            lblNameValidate.setText("");
        }

        if (!DataValidateController.userPasswordValidate(userPassword.getText())) {
            lblPasswordValidate.setText("Invalid Password!");
            isValid = false;
        } else {
            lblPasswordValidate.setText("");
        }

        if (!DataValidateController.userEmailValidate(userEmail.getText())) {
            lblEmailValidate.setText("Invalid Email!");
            isValid = false;
        } else {
            lblEmailValidate.setText("");
        }

        if (!DataValidateController.userMobileValidate(userMobile.getText())) {
            lblMobileValidate.setText("Invalid Mobile!");
            isValid = false;
        } else {
            lblMobileValidate.setText("");
        }

        if (!DataValidateController.userAddressValidate(userAddress.getText())) {
            lblAddressValidate.setText("Invalid Address!");
            isValid = false;
        } else {
            lblAddressValidate.setText("");
        }


        return isValid;
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = userID.getText();
        String name = userName.getText();
        String password = userPassword.getText();
        String email = userEmail.getText();
        String mobile = userMobile.getText();
        String address = userAddress.getText();

        UserDTO userDTO = new UserDTO(id, name, password, email, mobile, address);
        boolean updated = userBO.updateUsers(userDTO);
        if (updated) {
            System.out.println("Update Successfully");
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successfully").show();
            loadAllUsers();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllUsers();
        setCellValueFactory();
        generateUserId();
    }

    private void generateUserId() {
        try {
            userID.setText(userBO.generateNextUserId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colUserId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    }

    private void loadAllUsers() {

        ObservableList<UserTM> obList = FXCollections.observableArrayList();
        tblUser.getItems().clear();
        try {
            List<UserDTO> list = userBO.getAllUsers();
            for (UserDTO dto : list) {
                UserTM userTM = new UserTM(
                        dto.getId(),
                        dto.getName(),
                        dto.getPassword(),
                        dto.getMobile(),
                        dto.getEmail(),
                        dto.getAddress()
                );
                obList.add(userTM);
            }
            tblUser.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void tableClick(MouseEvent event) {
        TablePosition pos = tblUser.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        ObservableList<TableColumn<UserTM, ?>> columns = tblUser.getColumns();

        userID.setText(columns.get(0).getCellData(row).toString());
        userName.setText(columns.get(1).getCellData(row).toString());
        userPassword.setText(columns.get(2).getCellData(row).toString());
        userMobile.setText(columns.get(3).getCellData(row).toString());
        userEmail.setText(columns.get(4).getCellData(row).toString());
        userAddress.setText(columns.get(5).getCellData(row).toString());

    }

}
