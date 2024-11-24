package lk.ijse.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Cacheable
@Table(name = "Student")
public class Student {


    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_address")
    private String address;

    @Column(name = "student_contact")
    private String contact;

    @Column(name = "student_email")
    private String email;

}
