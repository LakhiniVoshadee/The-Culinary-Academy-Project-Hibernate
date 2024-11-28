package lk.ijse.dto;


import lk.ijse.entity.Registration;
import lk.ijse.entity.Student;
import lk.ijse.tm.CartTM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {

    private String eid;
    private String Programname;
    private String pid;
    private LocalDate date;
    private String sid;
    private String Studentname;
    private Double remainingfee;
    private Double upfrontpayment;
  //  private List<CartTM> cartList = new ArrayList<>();




}
