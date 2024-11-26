package lk.ijse.service;

import lk.ijse.service.custom.impl.ProgramBOImpl;
import lk.ijse.service.custom.impl.StudentBOImpl;
import lk.ijse.service.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
       StudentBO,ProgramBO
    }

    public <T extends SuperBO>T getBO(BOFactory.BOTypes boTypes){
        switch (boTypes){
           case StudentBO:
               return (T) new StudentBOImpl();
            case ProgramBO:
                   return (T) new ProgramBOImpl();
            default:
                return null;
        }

    }

}
