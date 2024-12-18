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
@Table(name = "Student")
public class Student {


    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact")
    private String contact;

    @Column(name = "email")
    private String email;

   /* @OneToMany(mappedBy = "student", cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Registration> enrollmentList = new ArrayList<>();

    public void addEnrollment(Registration enrollment) {
        enrollmentList.add(enrollment);
        enrollment.setStudent(this);
    }

    public void removeEnrollment(Registration registration) {
        enrollmentList.remove(registration);
        registration.setStudent(null);
    }*/
}
