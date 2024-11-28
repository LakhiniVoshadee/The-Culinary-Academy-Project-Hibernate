package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AdminRegistrationFormController {

    @FXML
    private JFXComboBox<?> cmbProgramName;

    @FXML
    private JFXComboBox<?> cmbStudentId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colEnrollmentId;

    @FXML
    private TableColumn<?, ?> colProgramID;

    @FXML
    private TableColumn<?, ?> colProgramName;

    @FXML
    private TableColumn<?, ?> colStudentId;

    @FXML
    private TableColumn<?, ?> colStudentName;

    @FXML
    private TableColumn<?, ?> colTotalFee;

    @FXML
    private TableColumn<?, ?> colUpfrontFee;

    @FXML
    private AnchorPane pagingPane;

    @FXML
    private TableView<?> tblPurchase;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtEnrollmentId;

    @FXML
    private TextField txtProgramID;

    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtTotalFee;

    @FXML
    private TextField txtUpFrontPayment;

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
    void handleCourseSelection(ActionEvent event) {

    }

    @FXML
    void handleStudentSelection(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
