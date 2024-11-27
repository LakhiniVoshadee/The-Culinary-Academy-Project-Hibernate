package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
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
    private JFXButton btnAddCart;

    @FXML
    private JFXButton btnAddPrpgram;

    @FXML
    private JFXButton btnAddStudent;

    @FXML
    private JFXButton btnBuy;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnPurchaseDetail;

    @FXML
    private JFXComboBox<?> cmbProgramName;

    @FXML
    private JFXComboBox<?> cmbStID;

    @FXML
    private TableColumn<?, ?> colAdvance;

    @FXML
    private TableColumn<?, ?> colBalance;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colFee;

    @FXML
    private TableColumn<?, ?> colProgramID;

    @FXML
    private TableColumn<?, ?> colPurchaseID;

    @FXML
    private TableColumn<?, ?> colRemove;

    @FXML
    private TableColumn<?, ?> colStudentID;

    @FXML
    private DatePicker dpDate;

    @FXML
    private AnchorPane pagingPane;

    @FXML
    private TableView<?> tblPurchase;

    @FXML
    private TextField txtAdvance;

    @FXML
    private TextField txtBalance;

    @FXML
    private TextField txtBalanceAmount;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtPayementAmount;

    @FXML
    private TextField txtProgramID;

    @FXML
    private TextField txtPurchaseID;

    @FXML
    private TextField txtSeats;

    @FXML
    private TextField txtStName;

    @FXML
    private TextField txtTotalAmount;

    @FXML
    void btnAddCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddProgramOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddStudentOnAction(ActionEvent event) {

    }

    @FXML
    void btnBuyOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnPurchaseDetailsOnAction(ActionEvent event) {

    }

}
