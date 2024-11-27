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
import lk.ijse.dto.ProgramDTO;
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
    private TableColumn<?, ?> colSeats;


    @FXML
    private AnchorPane pagingPane;

    @FXML
    private TableView<ProgramTM> tblProgram;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtProgramName;

    @FXML
    private TextField txtSeats;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllPrograms();
        setCellValuesFactory();

    }


    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
        new Alert(Alert.AlertType.CONFIRMATION, "Clear Successfully").show();

    }

    private void clearFields() {
        txtID.clear();
        txtProgramName.clear();
        txtSeats.clear();
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
            loadAllPrograms();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {
        if (txtID.getText().isEmpty() || txtProgramName.getText().isEmpty() || txtSeats.getText().isEmpty() || txtDuration.getText().isEmpty() || txtFee.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please Fill All The Fields").show();
        } else {
            String id = txtID.getText();
            String name = txtProgramName.getText();
            String seats = txtSeats.getText();
            String duration = txtDuration.getText();
            String fee = txtFee.getText();

            ProgramDTO programDTO = new ProgramDTO(id, name,seats, duration, fee);
            boolean saved = programBO.saveProgram(programDTO);
            if (saved) {
                clearFields();
                new Alert(Alert.AlertType.CONFIRMATION, "Save Successfully").show();
                loadAllPrograms();
            }
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws Exception {
        String id = txtID.getText();
        String name = txtProgramName.getText();
        String seats = txtSeats.getText();
        String duration = txtDuration.getText();
        String fee = txtFee.getText();


        ProgramDTO programDTO = new ProgramDTO(id, name, seats, duration, fee);
        boolean updated = programBO.updateProgram(programDTO);
        if (updated) {
            System.out.println("Update Successfully");
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successfully").show();
            loadAllPrograms();
        }

    }


    private void setCellValuesFactory() {

        colProgramID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colProgramName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSeats.setCellValueFactory(new PropertyValueFactory<>("seats"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));


    }

    private void loadAllPrograms() {
        ObservableList<ProgramTM> obList = FXCollections.observableArrayList();
        tblProgram.getItems().clear();

        try {
            ArrayList<ProgramDTO> list = programBO.getAllPrograms();
            for (ProgramDTO dto : list) {

                ProgramTM programTM = new ProgramTM(
                        dto.getId(),
                        dto.getName(),
                        dto.getSeats(),
                        dto.getDuration(),
                        dto.getFee()
                );
                obList.add(programTM);
            }
            tblProgram.setItems(obList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void tableClick(MouseEvent event) {
        TablePosition pos = tblProgram.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        ObservableList<TableColumn<ProgramTM, ?>> columns = tblProgram.getColumns();

        txtID.setText(columns.get(0).getCellData(row).toString());
        txtProgramName.setText(columns.get(1).getCellData(row).toString());
        txtSeats.setText(columns.get(2).getCellData(row).toString());
        txtDuration.setText(columns.get(3).getCellData(row).toString());
        txtFee.setText(columns.get(4).getCellData(row).toString());


    }
}
