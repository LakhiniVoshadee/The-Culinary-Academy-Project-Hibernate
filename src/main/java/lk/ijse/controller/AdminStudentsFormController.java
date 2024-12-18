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
import lk.ijse.dto.StudentDto;
import lk.ijse.service.BOFactory;
import lk.ijse.service.custom.StudentBO;
import lk.ijse.tm.StudentTM;
import lk.ijse.util.DataValidateController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminStudentsFormController implements Initializable {

    StudentBO studentBO = BOFactory.getBoFactory().getBO(BOFactory.BOTypes.StudentBO);
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

    @FXML
    private Label studentAddressValidate;

    @FXML
    private Label studentContactValidate;

    @FXML
    private Label studentEmailValidate;

    @FXML
    private Label studentIdValidate;

    @FXML
    private Label studentNameValidate;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllStudents();
        setCellValuesFactory();
        generateStudentId();
    }

    private void generateStudentId() {
        try {
            stID.setText(studentBO.generateNextStudentId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
        new Alert(Alert.AlertType.CONFIRMATION, "Clear Successfully").show();

    }

    private void clearFields() {
        stID.clear();
        stName.clear();
        stAddress.clear();
        stContact.clear();
        stEmail.clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        String id = stID.getText();
        StudentDto studentDTO = new StudentDto();
        studentDTO.setId(id);
        boolean deleted = studentBO.deleteStudent(studentDTO);
        if (deleted) {
            clearFields();
            new Alert(Alert.AlertType.CONFIRMATION, "Delete Successfully").show();
            loadAllStudents();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {
        if (validateInputFields()) {
            String id = stID.getText();
            String name = stName.getText();
            String address = stAddress.getText();
            String mobile = stContact.getText();
            String email = stEmail.getText();

            StudentDto studentDTO = new StudentDto(id, name, address, mobile, email);
            boolean saved = studentBO.saveStudent(studentDTO);
            if (saved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved Successfully").show();
                loadAllStudents();
                clearFields();
                generateStudentId();
            }
        }
    }

    private boolean validateInputFields() {
        boolean isValid = true;

        if (!DataValidateController.studentIdValidate(stID.getText())) {
            studentIdValidate.setText("Invalid Student ID!");
            isValid = false;
        } else {
            studentIdValidate.setText("");
        }

        if (!DataValidateController.studentNameValidate(stName.getText())) {
            studentNameValidate.setText("Invalid Student Name!");
            isValid = false;
        } else {
            studentNameValidate.setText("");
        }

        if (!DataValidateController.studentAddressValidate(stAddress.getText())) {
            studentAddressValidate.setText("Invalid Address!");
            isValid = false;
        } else {
            studentAddressValidate.setText("");
        }

        if (!DataValidateController.studentContactValidate(stContact.getText())) {
            studentContactValidate.setText("Invalid Contact!");
            isValid = false;
        } else {
            studentContactValidate.setText("");
        }

        if (!DataValidateController.studentEmailValidate(stEmail.getText())) {
            studentEmailValidate.setText("Invalid Email!");
            isValid = false;
        } else {
            studentEmailValidate.setText("");
        }

        return isValid;
    }


    private void loadAllStudents() {
        ObservableList<StudentTM> obList = FXCollections.observableArrayList();
        tblStudent.getItems().clear();

        try {
            ArrayList<StudentDto> list = studentBO.getAllStudents();
            for (StudentDto dto : list) {

                StudentTM studentTM = new StudentTM(
                        dto.getId(),
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
    void btnUpdateOnAction(ActionEvent event) throws Exception {
        String id = stID.getText();
        String name = stName.getText();
        String address = stAddress.getText();
        String contact = stContact.getText();
        String email = stEmail.getText();

        StudentDto studentDTO = new StudentDto(id, name, address, contact, email);
        boolean updated = studentBO.updateStudent(studentDTO);
        if (updated) {
            System.out.println("Update Successfully");
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successfully").show();
            loadAllStudents();
        }

    }


    private void setCellValuesFactory() {
        colStID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colStName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colStContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colStEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

    }

    @FXML
    void tableClick(MouseEvent event) {
        TablePosition pos = tblStudent.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        ObservableList<TableColumn<StudentTM, ?>> columns = tblStudent.getColumns();

        stID.setText(columns.get(0).getCellData(row).toString());
        stName.setText(columns.get(1).getCellData(row).toString());
        stAddress.setText(columns.get(2).getCellData(row).toString());
        stContact.setText(columns.get(3).getCellData(row).toString());
        stEmail.setText(columns.get(4).getCellData(row).toString());

    }

}
