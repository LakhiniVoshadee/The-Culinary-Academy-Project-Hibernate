package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.StudentDto;
import lk.ijse.service.BOFactory;
import lk.ijse.service.custom.ProgramBO;
import lk.ijse.service.custom.RegistrationBO;
import lk.ijse.service.custom.StudentBO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminRegistrationFormController implements Initializable {

    @FXML
    private JFXComboBox<?> cmbProgramID;

    @FXML
    private JFXComboBox<String> cmbStudentID;

    @FXML
    private TableColumn<?, ?> colProgramId;

    @FXML
    private TableColumn<?, ?> colProgramName;

    @FXML
    private TableColumn<?, ?> colRegId;

    @FXML
    private TableColumn<?, ?> colRemFee;

    @FXML
    private TableColumn<?, ?> colStudentId;

    @FXML
    private TableColumn<?, ?> colStudentName;

    @FXML
    private TableColumn<?, ?> colUpfrontFee;

    @FXML
    private AnchorPane pagingPane;

    @FXML
    private TableView<?> tblPurchase;

    @FXML
    private TextField txtProgramName;

    @FXML
    private TextField txtRegID;

    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtTotalFee;

    @FXML
    private TextField txtUpFrontPayment;

    StudentBO studentBO = BOFactory.getBoFactory().getBO(BOFactory.BOTypes.StudentBO);
    ProgramBO programBO = BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ProgramBO);
    RegistrationBO registrationBO = BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RegistrationBO);
  //private StudentBO studentBO;

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void handleProgramSelection(ActionEvent event) {

    }

    @FXML
    void handleStudentSelection(ActionEvent event) throws Exception {
       String selectedStudentId = (String) cmbStudentID.getSelectionModel().getSelectedItem();
       if(selectedStudentId != null){

           StudentDto studentDto = studentBO.searchStudentById(selectedStudentId);
           if (studentDto != null) {
               txtStudentName.setText(studentDto.getName());


           }


       }


    }

    @FXML
    void txtRegSearchOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllStudents();
        cmbStudentID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
            }


        });
    }

    private void loadAllStudents() {
        ObservableList<String> students = FXCollections.observableArrayList();
        try {
            ArrayList<StudentDto> allStudents = studentBO.getAllStudents();
            for (StudentDto student : allStudents) {
                students.add(student.getId());
            }
            cmbStudentID.setItems(students);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
