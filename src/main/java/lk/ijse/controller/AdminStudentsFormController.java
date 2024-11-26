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
import lk.ijse.dto.StudentDto;
import lk.ijse.service.BOFactory;
import lk.ijse.service.custom.StudentBO;
import lk.ijse.tm.StudentTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminStudentsFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colStAddress;

    @FXML
    private TableColumn<?, ?> colStContact;

    @FXML
    private TableColumn<?, ?> colStEmail;

    @FXML
    private TableColumn<?, ?> colStID;

    @FXML
    private TableColumn<?, ?> colStName;

    @FXML
    private AnchorPane pagingPane;

    @FXML
    private TextField stAddress;

    @FXML
    private TextField stContact;

    @FXML
    private TextField stEmail;

    @FXML
    private TextField stID;

    @FXML
    private TextField stName;

    @FXML
    private TableView<StudentTM> tblStudent;

   StudentBO studentBO = BOFactory.getBoFactory().getBO(BOFactory.BOTypes.StudentBO);

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
        new Alert(Alert.AlertType.CONFIRMATION, "Clear Successfully").show();

    }

    private void clearFields() {
        stID.clear();
        stName.clear();
        stEmail.clear();
        stContact.clear();
        stAddress.clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (stID.getText().isEmpty() || stName.getText().isEmpty() || stEmail.getText().isEmpty() || stContact.getText().isEmpty() || stAddress.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please Fill All The Fields").show();
        }else {
            String id = stID.getText();
            String name = stName.getText();
            String email = stEmail.getText();
            String contact = stContact.getText();
            String address = stAddress.getText();

            StudentDto studentDTO = new StudentDto(id, name, email, contact, address);

            boolean saved = studentBO.saveStudent(studentDTO);
            if (saved) {
                clearFields();
                new Alert(Alert.AlertType.CONFIRMATION, "Save Successfully").show();
               // loadAllStudents();
            }



            //////////////// VALIDATION ///////////////




        }

    }

   /* private void loadAllStudents() {
        ObservableList<StudentTM> obList = FXCollections.observableArrayList();
        tblStudent.getItems().clear();

        try {
            ArrayList<StudentDto> list = studentBO.getAllStudents();
            for (StudentDto dto : list) {
                StudentTM bookTM = new StudentTM(
                        dto.getStudentId(),
                        dto.getName(),
                        dto.getEmail(),
                        dto.getContact(),
                        dto.getAddress()
                );
                obList.add(bookTM);
            }
            tblStudent.setItems(obList);
        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }
*/
    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValuesFactory();
       // loadAllStudents();
    }

    private void setCellValuesFactory() {
        colStID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colStName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colStContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colStAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

    }
}
