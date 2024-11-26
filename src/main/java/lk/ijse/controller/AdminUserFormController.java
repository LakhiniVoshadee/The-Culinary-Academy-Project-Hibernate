package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.UserDTO;
import lk.ijse.service.BOFactory;
import lk.ijse.service.custom.UserBO;
import lk.ijse.tm.UserTM;
import lombok.SneakyThrows;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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

//    UserBO userBO = BOFactory.getBoFactory().getBO(BOFactory.BOTypes.UserBO);

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

  /*  @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = userID.getText();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        boolean deleted = userBO.deleteUser(userDTO);
        if (deleted) {
            System.out.println("Delete Successfully");
            new Alert(Alert.AlertType.CONFIRMATION, "Delete Successfully").show();
            loadAllUsers();
        }

    }
*/
   /* private void loadAllUsers() {
        ObservableList<UserTM> obList = FXCollections.observableArrayList();
        tblUser.getItems().clear();

        try {
            List<UserDTO> list = userBO.getAllUsers();
            for(UserDTO dto : list){
                UserTM userTM = new UserTM(
                        dto.getId(),
                        dto.getName(),
                        dto.getPassword(),
                        dto.getEmail(),
                        dto.getMobile(),
                        dto.getAddress()
                );
                obList.add(userTM);
            }
            tblUser.setItems(obList);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }


    }*/

   /* @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (userID.getText().isEmpty() || userName.getText().isEmpty() || userPassword.getText().isEmpty() || userEmail.getText().isEmpty() || userMobile.getText().isEmpty() || userAddress.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please Fill All The Fields").show();
        }else {
            String id = userID.getText();
            String name = userName.getText();
            String password = userPassword.getText();
            String email = userEmail.getText();
            String mobile = userMobile.getText();
            String address = userAddress.getText();
            UserDTO userDTO = new UserDTO(id, name, password, email, mobile, address);

            boolean saved = userBO.saveUser(userDTO);
            if (saved) {
                clearFields();
                new Alert(Alert.AlertType.CONFIRMATION, "Save Successfully").show();
                loadAllUsers();
            }


        }

    }*/

  /*  @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = userID.getText();
        String name = userName.getText();
        String password = userPassword.getText();
        String email = userEmail.getText();
        String mobile = userMobile.getText();
        String address = userAddress.getText();
        UserDTO userDTO = new UserDTO(id, name, password, email, mobile, address);
        boolean updated = userBO.updateUser(userDTO);
        if (updated) {
            clearFields();
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successfully").show();
            loadAllUsers();
        }

    }*/

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      /*  setCellValuesFactory();
        loadAllUsers();*/

    }

   /* private void setCellValuesFactory() {
        colUserId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    }*/
}
