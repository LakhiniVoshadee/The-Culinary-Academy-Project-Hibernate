package lk.ijse.repository.custom.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Program;
import lk.ijse.entity.Registration;
import lk.ijse.entity.Student;
import lk.ijse.repository.custom.RegistrationDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

public class RegistrationDAOImpl implements RegistrationDAO {
    private Session session;
    @Override
    public void setSession(Session session) {
        this.session = session;

    }

    @Override
    public boolean save(Registration entity) throws SQLException, ClassNotFoundException {
        /*Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        Transaction tx = session.beginTransaction();
        session.save(entity);

        Student student = entity.getStudent();
        Program programs = entity.getPrograms();
        if (student != null) {
            student.addRegistration(entity);
        }
        if (programs != null) {
            programs.addRegistration(entity);
        }

        tx.commit();
        session.close();
        return true;*/
        return false;
    }

    @Override
    public ArrayList<Registration> getAll() throws SQLException, ClassNotFoundException {
       /* List<Registration> all = new ArrayList<>();
        Session session =   SessionFactoryConfig.getSessionFactoryConfig().getSession();
        Transaction transaction = session.beginTransaction();
        all = session.createQuery("from Registration", Registration.class).list();
        transaction.commit();
        session.close();
        return all;*/
        return null;
    }

    @Override
    public boolean update(Registration entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void delete(Registration entity) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String getLastId() throws Exception {
        return "";
    }

    @Override
    public Registration find(String s) {
        return null;
    }


    @Override
    public String generateNextRegistrationId() throws SQLException, ClassNotFoundException {
        String hql = "SELECT R.id FROM Registration AS R ORDER BY R.id DESC";
        Query idquery = session.createQuery(hql);
        String regId = (String) idquery.setMaxResults(1).uniqueResult();
        return regId;

    }
}
