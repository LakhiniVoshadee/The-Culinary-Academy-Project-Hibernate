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
    StudentDAO studentDAO =  DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.StudentDAO);

    @Override
    public boolean deleteStudent(StudentDto studentDto) {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentDAO.setSession(session);
            studentDAO.delete(studentDto.toEntity());
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
    public ArrayList<StudentDto> getAllStudents() throws SQLException {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        studentDAO.setSession(session);
        ArrayList<Student> students = null;

        students = studentDAO.getAll();

        ArrayList<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(new StudentDto(
                    student.getStudentId(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getEmail()
            ));
        }
        session.close();
        return studentDtos;
    }

    @Override
    public boolean updateStudent(StudentDto studentDto) {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentDAO.setSession(session);
            studentDAO.update(studentDto.toEntity());
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
    public boolean saveStudent(StudentDto studentDto) {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentDAO.setSession(session);
            studentDAO.save(studentDto.toEntity());
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
}
