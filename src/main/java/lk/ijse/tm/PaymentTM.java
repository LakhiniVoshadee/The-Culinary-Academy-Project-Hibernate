package lk.ijse.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTM {
    private String id;
    private String eid;
    private Double amount;
    private LocalDate date;

}
