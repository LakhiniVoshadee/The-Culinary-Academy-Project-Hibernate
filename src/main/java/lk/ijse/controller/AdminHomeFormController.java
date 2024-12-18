package lk.ijse.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lk.ijse.service.BOFactory;
import lk.ijse.service.custom.AdminHomeBO;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class AdminHomeFormController implements Initializable {

    AdminHomeBO adminHomeBO = BOFactory.getBoFactory().getBO(BOFactory.BOTypes.AdminHomeBO);
    @FXML
    private Label lblProgramCount;
    @FXML
    private Label lblStudentCount;
    @FXML
    private Label lblUsersCount;
    @FXML
    private Label lblTime;
    @FXML
    private Label lblDate;
    private volatile boolean running = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentCount();
        programCount();
        userCount();
        timeNow();
    }

    private void timeNow() {

        Thread thread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
            SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM, dd, yyyy");
            while (running) {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String timeNow = sdf.format(new Date());
                String timeNow1 = sdf1.format(new Date());

                Platform.runLater(() -> {
                    lblTime.setText(timeNow);
                    lblDate.setText(timeNow1);
                });
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private void userCount() {
        lblUsersCount.setText(String.valueOf(adminHomeBO.userCount()));
    }

    private void programCount() {
        lblProgramCount.setText(String.valueOf(adminHomeBO.programCount()));
    }

    private void studentCount() {
        lblStudentCount.setText(String.valueOf(adminHomeBO.studentCount()));
    }
}
