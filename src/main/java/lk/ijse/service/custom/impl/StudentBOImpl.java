package lk.ijse.service.custom.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.StudentDto;
import lk.ijse.entity.Student;
import lk.ijse.repository.DAOFactory;
import lk.ijse.repository.custom.StudentDAO;
import lk.ijse.service.custom.StudentBO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {
    private StudentDAO studentDAO;
   public StudentBOImpl(){
       StudentDAO studentDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.StudentDAO);
       this.studentDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.StudentDAO);
   }


    @Override
    public boolean saveStudent(StudentDto studentDTO) {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            studentDAO.setSession(session);
            studentDAO.save(studentDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<StudentDto> getAllStudents() throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        studentDAO.setSession(session);
        ArrayList<Student> students = studentDAO.getAll();
        ArrayList<StudentDto> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            studentDTOS.add(new StudentDto(
                    student.getId(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getEmail()
            ));
        }
        session.close();
        return studentDTOS;
    }

    @Override
    public boolean updateStudent(StudentDto studentDTO) {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            studentDAO.setSession(session);
            studentDAO.update(studentDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteStudent(StudentDto studentDTO) {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            studentDAO.setSession(session);
            studentDAO.delete(studentDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public String generateNextStudentId() throws Exception {
        String lastId = studentDAO.getLastId();
        return incrementId(lastId);

    }

    @Override
    public StudentDto searchStudentById(String selectedStudentId) throws Exception {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        studentDAO.setSession(session);
        Student student = studentDAO.searchStudentById(selectedStudentId);
        session.close();
        if (student != null) {
            return new StudentDto(
                    student.getId(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getEmail()
            );
        } else {
            return null;


        }

    }


    private String incrementId(String lastId) {
        if (lastId == null) {
            return "STU-0001";
        } else {
            int id = Integer.parseInt(lastId.split("-")[1]);
            id++;
            return String.format("STU-%04d", id);
        }

    }
}
