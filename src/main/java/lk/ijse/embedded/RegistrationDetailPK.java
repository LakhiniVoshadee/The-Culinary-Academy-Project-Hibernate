package lk.ijse.embedded;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class RegistrationDetailPK {

    @Column(name = "registration_id")
    private int id;

    @Column(name = "program_id")
    private String programId;

}
