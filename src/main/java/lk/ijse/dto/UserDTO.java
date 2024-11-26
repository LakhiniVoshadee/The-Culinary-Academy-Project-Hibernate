package lk.ijse.dto;

import lk.ijse.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String password;
    private String mobile;
    private String email;
    private String address;



    public User toEntity(){
        User user=new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setPassword(this.password);
        user.setMobile(this.mobile);
        user.setEmail(this.email);
        user.setAddress(this.address);
        return user;
    }
}
