package lk.ijse.config;

import lk.ijse.entity.Program;
import lk.ijse.entity.Student;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SessionFactoryConfig {

    private static SessionFactoryConfig sessionFactoryConfig;

    private final SessionFactory sessionFactory;

    private SessionFactoryConfig(){
        Properties properties = new Properties();

        try{
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("hibernet.properties");
            if(inputStream == null){
                System.out.println("Resource not found!");
            } else {
                properties.load(inputStream);
                System.out.println("Resource loaded seccessfully!");
            }
        }catch (IOException e){
            e.printStackTrace();
        }


        sessionFactory = new Configuration()
                .setProperties(properties)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Program.class)
                .addAnnotatedClass(User.class)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                .buildSessionFactory();

    }

    public static SessionFactoryConfig getSessionFactoryConfig() {
        return (sessionFactoryConfig == null) ? sessionFactoryConfig = new SessionFactoryConfig() : sessionFactoryConfig;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    }

