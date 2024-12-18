package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "Program")
public class Program {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "seats")
    private String seats;

    @Column(name = "duration")
    private String duration;

    @Column(name = "fee")
    private String fee;

    /*@OneToMany(mappedBy = "programs", cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Registration> enrollmentList = new ArrayList<>();

    public void addEnrollment(Registration enrollment) {
        enrollmentList.add(enrollment);
        enrollment.setProgram(this);
    }

    public void removeEnrollment(Registration registration) {
        enrollmentList.remove(registration);
        registration.setProgram(null);
    }*/


  /*  @ManyToOne
    @JoinColumn(name = "id")
    private Admin admin;*/

   /* @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "program"
    )
    private List<TransactionDetail> transactionDetails = new ArrayList<>();*/
}
