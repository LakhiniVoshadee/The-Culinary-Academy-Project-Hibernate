package lk.ijse.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private String eid;

    @ManyToOne
    @JoinColumn(name = "sid")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "pid")
    private Program program;

  @OneToMany(mappedBy = "registration", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment>paymentList = new ArrayList<>();

    private LocalDate date;
    private Double upfrontpayment;
    private Double remainingfee;


}
