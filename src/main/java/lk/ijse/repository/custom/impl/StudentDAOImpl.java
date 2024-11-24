package lk.ijse.repository.custom.impl;

import lk.ijse.entity.Student;
import lk.ijse.repository.custom.StudentDAO;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private Session session;
    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public boolean save(Student entity) throws SQLException, ClassNotFoundException {
        session.save(entity);
        return false;
    }

    @Override
    public void update(Student entity) throws SQLException, ClassNotFoundException {
        session.update(entity);

    }

    @Override
    public void delete(Student entity) throws SQLException, ClassNotFoundException {
        session.delete(entity);

    }

    @Override
    public ArrayList<Student> getAll() throws SQLException {
       try {
           List<Student> students = session.createNativeQuery("SELECT * FROM Student", Student.class).getResultList();
           return new ArrayList<>(students);
       }catch (Exception e){
           return null;
       }finally {
           session.close();
       }
    }
}
