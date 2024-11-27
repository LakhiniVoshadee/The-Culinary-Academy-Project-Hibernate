package lk.ijse.service.custom;


import lk.ijse.dto.UserDTO;
import lk.ijse.service.SuperBO;

;import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {


    boolean saveUsers(UserDTO userDTO);

    List<UserDTO> getAllUsers() throws SQLException;

    boolean updateUsers(UserDTO userDTO);

    boolean deleteUsers(UserDTO userDTO);
}

