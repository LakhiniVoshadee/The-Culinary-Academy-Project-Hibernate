package lk.ijse.repository.custom;

import lk.ijse.entity.Student;
import lk.ijse.repository.CrudDAO;

public interface StudentDAO extends CrudDAO <Student,String> {

    int studentCount();
    String generateNextId();
    Student find(String studentId);

    Student searchStudentById(String selectedStudentId);

   // Student getAll();
}
