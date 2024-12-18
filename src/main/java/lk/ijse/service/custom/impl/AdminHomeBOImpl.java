package lk.ijse.service.custom.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.repository.DAOFactory;
import lk.ijse.repository.custom.ProgramDAO;
import lk.ijse.repository.custom.StudentDAO;
import lk.ijse.repository.custom.UserDAO;
import lk.ijse.service.custom.AdminHomeBO;
import org.hibernate.Session;

public class AdminHomeBOImpl implements AdminHomeBO {

    StudentDAO studentDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.StudentDAO);
    ProgramDAO programDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ProgramDAO);
    UserDAO userDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.UserDAO);


    @Override
    public int programCount() {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();

        try {
            programDAO.setSession(session);
            int count = programDAO.programCount();

            session.close();
            return count;
        } catch (Exception e) {
            session.close();
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int studentCount() {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();

        try {
            studentDAO.setSession(session);
            int count = studentDAO.studentCount();

            session.close();
            return count;
        } catch (Exception e) {
            session.close();
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int userCount() {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();

        try {
            userDAO.setSession(session);
            int count = userDAO.userCount();

            session.close();
            return count;
        } catch (Exception e) {
            session.close();
            e.printStackTrace();
            return -1;
        }
    }

}
