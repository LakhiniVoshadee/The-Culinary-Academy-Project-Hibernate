package lk.ijse.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationTM {

    private String sid;
    private String studentName;
    private String pid;
    private String programName;
    private String seats;


}
