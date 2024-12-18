package lk.ijse.service.custom;

import lk.ijse.dto.StudentDto;
import lk.ijse.service.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {

    boolean saveStudent(StudentDto studentDTO) throws Exception;

    ArrayList<StudentDto> getAllStudents() throws SQLException, ClassNotFoundException;

    boolean updateStudent(StudentDto studentDTO) throws Exception;

    boolean deleteStudent(StudentDto studentDTO) throws Exception;

    String generateNextStudentId() throws Exception;

  // void handleStudentSelection(Object studentId);

    StudentDto searchStudentById(String selectedStudentId) throws Exception;


}
