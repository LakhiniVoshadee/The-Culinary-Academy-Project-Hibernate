package lk.ijse.config;

import lk.ijse.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private static  SessionFactoryConfig factoryConfig;

    private final SessionFactory sessionFactory;


    private SessionFactoryConfig() {


        sessionFactory = new Configuration()
                .mergeProperties(Utility.getProperties())
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return (null == factoryConfig)
                ? factoryConfig = new SessionFactoryConfig()
                : factoryConfig;
    }


    public Session getSesstion(){
        return sessionFactory.openSession();
    }
}
