package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
        stContact.clear();
        stEmail.clear();
        stAddress.clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = stID.getText();
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(id);
        boolean deleted = studentBO.deleteStudent(studentDto);
        if (deleted) {
            System.out.println("Delete Successfully");
            new Alert(Alert.AlertType.CONFIRMATION, "Delete Successfully").show();
            loadAllStudents();
        }


    }

    private void loadAllStudents() {
        ObservableList<StudentTM> obList = FXCollections.observableArrayList();
        tblStudent.getItems().clear();

        try {
            ArrayList<StudentDto> list = studentBO.getAllStudents();

            for (StudentDto dto : list) {
                StudentTM studentTM = new StudentTM(
                        dto.getStudentId(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getContact(),
                        dto.getEmail()
                );
                obList.add(studentTM);
            }


            tblStudent.setItems(obList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void btnSaveOnAction(ActionEvent event) {
    if (stID.getText().isEmpty() || stName.getText().isEmpty() || stAddress.getText().isEmpty() || stContact.getText().isEmpty() || stEmail.getText().isEmpty()) {
        new Alert(Alert.AlertType.WARNING, "Please Fill All The Fields").show();
    }else {
        String id = stID.getText();
        String name = stName.getText();
        String address = stAddress.getText();
        String contact = stContact.getText();
        String email = stEmail.getText();

        StudentDto studentDto = new StudentDto(id, name, address, contact, email);

        boolean saved = studentBO.saveStudent(studentDto);
        if (saved) {
            System.out.println("Save Successfully");
            new Alert(Alert.AlertType.CONFIRMATION, "Save Successfully").show();
            loadAllStudents();
            clearFields();
        }
    }

    ///////////////////////////// VALIDATION


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = stID.getText();
        String name = stName.getText();
        String address = stAddress.getText();
        String contact = stContact.getText();
        String email = stEmail.getText();

        StudentDto studentDto = new StudentDto(id, name, address, contact, email);
        boolean updated = studentBO.updateStudent(studentDto);
        if (updated) {
            System.out.println("Update Successfully");
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successfully").show();
            loadAllStudents();
        }

    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValuesFactory();
        loadAllStudents();
    }

    private void setCellValuesFactory() {
        colStID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colStContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colStEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }


}
