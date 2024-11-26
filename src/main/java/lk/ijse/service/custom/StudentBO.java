package lk.ijse.service.custom;

import lk.ijse.dto.StudentDto;
import lk.ijse.service.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {

    boolean saveStudent(StudentDto studentDTO);

    ArrayList<StudentDto> getAllStudents() throws SQLException;
}
