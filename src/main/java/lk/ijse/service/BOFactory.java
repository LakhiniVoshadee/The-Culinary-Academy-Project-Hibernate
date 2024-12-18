package lk.ijse.service;

import lk.ijse.service.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOFactory.BOTypes boTypes) {
        switch (boTypes) {
            case StudentBO:
                return (T) new StudentBOImpl();
            case ProgramBO:
                return (T) new ProgramBOImpl();
            case UserBO:
                return (T) new UserBOImpl();

            case AdminHomeBO:
                return (T) new AdminHomeBOImpl();

                case RegistrationBO:
                return (T) new RegistrationBOImpl();


            default:
                return null;
        }

    }

    public enum BOTypes {
        StudentBO, ProgramBO, UserBO, AdminHomeBO, RegistrationBO
    }

}
