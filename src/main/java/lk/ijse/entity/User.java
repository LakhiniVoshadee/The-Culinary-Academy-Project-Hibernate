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
@Table(name = "User")
public class User {

    @Id
    @Column(name = "id")
    private String id;


    @Column(name = "name")
    private String name;


    @Column(name = "password")
    private String password;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;
}
