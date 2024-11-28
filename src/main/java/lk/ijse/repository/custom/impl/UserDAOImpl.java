package lk.ijse.repository.custom.impl;


import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.User;
import lk.ijse.repository.custom.UserDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(User entity) throws SQLException, ClassNotFoundException {
        session.save(entity);
        return false;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        try {
            List<User> users = session.createNativeQuery("SELECT * FROM User", User.class).getResultList();
            return (ArrayList<User>) users;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(User entity) throws SQLException, ClassNotFoundException {
        session.update(entity);
        return false;
    }

    @Override
    public void delete(User entity) throws SQLException, ClassNotFoundException {
        session.delete(entity);
    }

    @Override
    public String getLastId() throws Exception {
        try (Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession()) {
            String sql = "SELECT U.id FROM User AS U ORDER BY U.id DESC";
            Query<String> query = session.createQuery(sql, String.class);
            query.setMaxResults(1);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User find(String s) {
        return null;
    }

    @Override
    public int userCount() {
        String sql = "SELECT COUNT(U.id) FROM User AS U";
        Query query = session.createQuery(sql);
        Long count = (Long) query.getSingleResult();
        return Math.toIntExact(count);
    }

    @Override
    public String generateNextId() {

        String sql = "SELECT U.id FROM User AS U ORDER BY U.id DESC";
        Query idquery = session.createQuery(sql);
        String userId = (String) idquery.setMaxResults(1).uniqueResult();
        return userId;
    }
}
