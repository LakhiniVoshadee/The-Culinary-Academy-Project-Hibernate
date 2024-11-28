package lk.ijse.repository.custom.impl;

import lk.ijse.entity.Registration;
import lk.ijse.repository.custom.RegistrationDAO;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;

public class RegistrationDAImpl implements RegistrationDAO {
    @Override
    public void setSession(Session session) {

    }

    @Override
    public boolean save(Registration entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Registration> getAll() throws SQLException, ClassNotFoundException {
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
}
