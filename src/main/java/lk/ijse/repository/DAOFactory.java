package lk.ijse.repository;

import lk.ijse.repository.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case StudentDAO:
                return (T) new StudentDAOImpl();
            case ProgramDAO:
                return (T) new ProgramDAOImpl();
            case UserDAO:
                return (T) new UserDAOImpl();
            case AdminDAO:
                return (T) new AdminDAOImpl();
            case RegistrationDAO:
                return (T) new RegistrationDAOImpl();


            default:
                return null;
        }

    }

    public enum DAOTypes {
        StudentDAO,
        ProgramDAO,
        UserDAO,
        AdminDAO,
        RegistrationDAO

    }
}
