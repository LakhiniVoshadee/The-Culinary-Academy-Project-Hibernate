package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "eid")
    private Registration registration;

    private Double amount;
    private LocalDate date;

}
