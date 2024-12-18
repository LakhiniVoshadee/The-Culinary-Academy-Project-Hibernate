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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.ProgramDTO;
import lk.ijse.dto.StudentDto;
import lk.ijse.service.BOFactory;
import lk.ijse.service.custom.ProgramBO;
import lk.ijse.service.custom.RegistrationBO;
import lk.ijse.service.custom.StudentBO;
import lk.ijse.tm.RegistrationTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminRegistrationFormController implements Initializable {

    @FXML
    private JFXComboBox<String> cmbProgramID;

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
    private TableView<RegistrationTM> tblPurchase;

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
        try {
            // Retrieve data from input fields
            String regId = txtRegID.getText();
            String studentId = cmbStudentID.getValue();
            String studentName = txtStudentName.getText();
            String programId = cmbProgramID.getValue();
            String programName = txtProgramName.getText();
            double totalFee = Double.parseDouble(txtTotalFee.getText());
            double upfrontFee = Double.parseDouble(txtUpFrontPayment.getText());
            double remainingFee = totalFee - upfrontFee;

            // Validate inputs
            if (regId.isEmpty() || studentId == null || studentName.isEmpty() ||
                    programId == null || programName.isEmpty() || totalFee <= 0 || upfrontFee < 0) {
                System.out.println("Invalid input! Please fill in all fields correctly.");
                return;
            }

            // Create a new instance of RegistrationTM
            RegistrationTM registrationTM = new RegistrationTM(
                    regId, studentId, studentName, programId, programName, upfrontFee, remainingFee
            );

            // Add the new RegistrationTM instance to the TableView
            tblPurchase.getItems().add(registrationTM);

            // Clear the input fields after adding the data
            clearFields();

        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input! Please enter valid numbers for fees.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        txtRegID.clear();
        cmbStudentID.getSelectionModel().clearSelection();
        txtStudentName.clear();
        cmbProgramID.getSelectionModel().clearSelection();
        txtProgramName.clear();
        txtTotalFee.clear();
        txtUpFrontPayment.clear();
    }



    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void handleProgramSelection(ActionEvent event) throws Exception {
        String selectedProgramId = (String) cmbProgramID.getSelectionModel().getSelectedItem();
        if(selectedProgramId != null){

            ProgramDTO programDto = programBO.searchProgramById(selectedProgramId);
            if (programDto != null) {
                txtProgramName.setText(programDto.getName());
                txtTotalFee.setText(programDto.getFee());


            }


        }


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
        loadAllPrograms();
        generateNextRegId();
        setCellValueFactory();
        cmbStudentID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
            }


        });

        cmbProgramID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

            }
        });
    }

    private void generateNextRegId() {
        try {
            txtRegID.setText(registrationBO.generateNextRegistrationId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colRegId.setCellValueFactory(new PropertyValueFactory<>("registrationId"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colProgramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colProgramName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colRemFee.setCellValueFactory(new PropertyValueFactory<>("remainingFee"));
        colUpfrontFee.setCellValueFactory(new PropertyValueFactory<>("upfrontFee"));
    }

    private void loadAllPrograms() {

        ObservableList<String> programs = FXCollections.observableArrayList();
        try {
            ArrayList<ProgramDTO> allPrograms = programBO.getAllPrograms();
            for (ProgramDTO program : allPrograms) {
                programs.add(program.getId());
            }
            cmbProgramID.setItems(programs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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
