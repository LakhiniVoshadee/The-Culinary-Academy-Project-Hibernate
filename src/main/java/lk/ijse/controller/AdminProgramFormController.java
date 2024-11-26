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
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.ProgramDTO;
import lk.ijse.dto.StudentDto;
import lk.ijse.service.BOFactory;
import lk.ijse.service.custom.ProgramBO;
import lk.ijse.tm.ProgramTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminProgramFormController implements Initializable {

    ProgramBO programBO = BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ProgramBO);

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colFee;

    @FXML
    private TableColumn<?, ?> colProgramID;

    @FXML
    private TableColumn<?, ?> colProgramName;

    @FXML
    private AnchorPane pagingPane;

    @FXML
    private TableView<ProgramDTO> tblProgram;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtProgramName;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
        new Alert(Alert.AlertType.CONFIRMATION,"Clear Successfully").show();

    }

    private void clearFields() {
        txtID.clear();
        txtProgramName.clear();
        txtDuration.clear();
        txtFee.clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        String id = txtID.getText();
        ProgramDTO programDTO = new ProgramDTO();
        programDTO.setId(id);
        boolean deleted = programBO.deleteProgram(programDTO);
        if (deleted) {
            clearFields();
            new Alert(Alert.AlertType.CONFIRMATION, "Delete Successfully").show();
           // loadAllStudents();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {
        if (txtID.getText().isEmpty() || txtProgramName.getText().isEmpty() || txtDuration.getText().isEmpty() || txtFee.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING,"Please Fill All The Fields").show();
        }else {
            String id = txtID.getText();
            String name = txtProgramName.getText();
            String duration = txtDuration.getText();
            String fee = txtFee.getText();

            ProgramDTO programDTO = new ProgramDTO(id,name,duration,fee);
            boolean saved = programBO.saveProgram(programDTO);
            if (saved) {
                clearFields();
                new Alert(Alert.AlertType.CONFIRMATION,"Save Successfully").show();
            }
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws Exception {
        String id = txtID.getText();
        String name = txtProgramName.getText();
        String duration = txtDuration.getText();
        String fee = txtFee.getText();


        ProgramDTO programDTO = new ProgramDTO(id, name,duration,fee);
        boolean updated = programBO.updateProgram(programDTO);
        if (updated) {
            System.out.println("Update Successfully");
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successfully").show();
           // loadAllStudents();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // loadAllPrograms();
        setCellValuesFactory();

    }

    private void setCellValuesFactory() {

    }

   /* private void loadAllPrograms() {
        ObservableList<ProgramDTO> obList = FXCollections.observableArrayList();
        tblProgram.getItems().clear();

        try{
            ArrayList<ProgramDTO> list = programBO.getAllPrograms();
            for (ProgramDTO dto : list) {

                ProgramTM programTM = new ProgramTM(
                        dto.getId(),
                        dto.getName(),
                        dto.getDuration(),
                        dto.getFee()
                );
                obList.add(programTM);
        }
            tblProgram.setItems(obList);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }*/
}
