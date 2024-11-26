package lk.ijse.service.custom;


import lk.ijse.dto.UserDTO;
import lk.ijse.service.SuperBO;

;

public interface UserBO extends SuperBO {


    boolean saveUsers(UserDTO userDTO);
}

