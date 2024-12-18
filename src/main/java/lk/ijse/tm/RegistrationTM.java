package lk.ijse.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationTM {

    private String registrationId;
    private String studentId;
    private String studentName;
    private String programId;
    private String programName;
    private double upfrontFee;
    private double remainingFee;


}
