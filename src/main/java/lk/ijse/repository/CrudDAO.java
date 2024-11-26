package lk.ijse.repository;

import lk.ijse.entity.Student;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,ID> extends SuperDAO {

    void setSession(Session session);

    boolean save(T entity) throws SQLException,ClassNotFoundException;

    ArrayList<T> getAll() throws SQLException,ClassNotFoundException;
}
