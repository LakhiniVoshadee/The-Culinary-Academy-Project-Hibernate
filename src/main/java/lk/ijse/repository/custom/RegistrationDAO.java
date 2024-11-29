package lk.ijse.repository.custom;

import lk.ijse.entity.Registration;
import lk.ijse.repository.CrudDAO;

import java.sql.SQLException;

public interface RegistrationDAO extends CrudDAO<Registration,String> {
    String generateNextRegistrationId() throws SQLException,ClassNotFoundException;
}
