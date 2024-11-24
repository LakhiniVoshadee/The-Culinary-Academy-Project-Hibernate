package lk.ijse.service.custom;

import lk.ijse.dto.StudentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO {
    boolean deleteStudent(StudentDto studentDto);

    ArrayList<StudentDto> getAllStudents() throws SQLException;

    boolean updateStudent(StudentDto studentDto);

    boolean saveStudent(StudentDto studentDto);
}
