package lk.ijse.repository.custom.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Student;
import lk.ijse.repository.custom.StudentDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private Session session;

    public StudentDAOImpl() {
        session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;

    }


    @Override
    public boolean save(Student entity) throws SQLException, ClassNotFoundException {
        session.save(entity);
        return false;
    }


    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        try {
            List<Student> students = session.createNativeQuery("SELECT * FROM Student", Student.class).getResultList();
            return (ArrayList<Student>) students;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Student entity) throws SQLException, ClassNotFoundException {
        session.update(entity);

        return false;
    }

    @Override
    public void delete(Student entity) throws SQLException, ClassNotFoundException {
        session.delete(entity);
    }

    @Override
    public String getLastId() throws Exception {
        try (Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession()) {
            String hql = "SELECT S.id FROM Student AS S ORDER BY S.id DESC";
            Query<String> query = session.createQuery(hql, String.class);
            query.setMaxResults(1);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public int studentCount() {
        String hql = "SELECT COUNT(S.id) FROM Student AS S";
        Query query = session.createQuery(hql);
        Long count = (Long) query.getSingleResult();
        return Math.toIntExact(count);
    }

    @Override
    public String generateNextId() {

        String hql = "SELECT S.id FROM Student AS S ORDER BY S.id DESC";
        Query idquery = session.createQuery(hql);
        String studentId = (String) idquery.setMaxResults(1).uniqueResult();
        return studentId;
    }

    @Override
    public Student find(String studentId) {
        Query<Student> query = session.createQuery("FROM Student WHERE id = :id", Student.class);
        query.setParameter("id", studentId);
        return query.getSingleResult();

    }

    @Override
    public Student searchStudentById(String selectedStudentId) {

        try(Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession()){
            Query<Student> query = session.createQuery("FROM Student WHERE id = :id", Student.class);
            query.setParameter("id", selectedStudentId);
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
