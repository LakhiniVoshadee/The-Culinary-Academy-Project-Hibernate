package lk.ijse.repository.custom.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Admin;
import lk.ijse.repository.custom.AdminDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;

    }

    @Override
    public boolean save(Admin entity) throws SQLException, ClassNotFoundException {
        session.save(entity);
        return false;
    }

    @Override
    public ArrayList<Admin> getAll() throws SQLException, ClassNotFoundException {
        try {
            List<Admin> admins = session.createNativeQuery("SELECT * FROM Admin", Admin.class).getResultList();
            return (ArrayList<Admin>) admins;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Admin entity) throws SQLException, ClassNotFoundException {
        session.update(entity);
    }

    @Override
    public void delete(Admin entity) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String getLastId() throws Exception {
        return "";
    }


}
