package lk.ijse.service.custom.impl;


import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;
import lk.ijse.repository.DAOFactory;
import lk.ijse.repository.custom.UserDAO;
import lk.ijse.service.custom.UserBO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.UserDAO);


    @Override
    public boolean saveUsers(UserDTO userDTO) {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            userDAO.setSession(session);
            userDAO.save(userDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<UserDTO> getAllUsers() throws SQLException {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        userDAO.setSession(session);
        ArrayList<User> users = null;
        try {
            users = userDAO.getAll();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<UserDTO> userDTOS = new ArrayList<>();
        for(User user : users){
            userDTOS.add(new UserDTO(
                    user.getId(),
                    user.getName(),
                    user.getPassword(),
                    user.getMobile(),
                    user.getEmail(),
                    user.getAddress()

            ));
        }
        session.close();
        return userDTOS;

}

    @Override
    public boolean updateUsers(UserDTO userDTO) {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            userDAO.setSession(session);
            userDAO.update(userDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUsers(UserDTO userDTO) {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            userDAO.setSession(session);
            userDAO.delete(userDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public String generateNextUserId() throws Exception {

        String lastId = userDAO.getLastId();
        return incrementId(lastId);
    }

    private String incrementId(String lastId) {

        if (lastId == null) {
            return "USR-0001";
        } else {
            int id = Integer.parseInt(lastId.split("-")[1]);
            id++;
            return String.format("USR-%04d", id);
        }

    }
    }

