package lk.ijse.repository.custom.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Program;
import lk.ijse.entity.Student;
import lk.ijse.repository.custom.ProgramDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;

    }

    @Override
    public boolean save(Program entity) throws SQLException, ClassNotFoundException {
        session.save(entity);
        return false;
    }

    @Override
    public ArrayList<Program> getAll() throws SQLException, ClassNotFoundException {
        try {
            List<Program> programs = session.createNativeQuery("SELECT * FROM Program", Program.class).getResultList();
            return (ArrayList<Program>) programs;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Program entity) throws SQLException, ClassNotFoundException {
        session.update(entity);

        return false;
    }

    @Override
    public void delete(Program entity) throws SQLException, ClassNotFoundException {
        session.delete(entity);

    }

    @Override
    public String getLastId() throws Exception {
        try (Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession()) {
            String hql = "SELECT P.id FROM Program AS P ORDER BY P.id DESC";
            Query<String> query = session.createQuery(hql, String.class);
            query.setMaxResults(1);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Program find(String s) {
        return null;
    }

    @Override
    public int programCount() {
        String hql = "SELECT COUNT(P.id) FROM Program AS P";
        Query query = session.createQuery(hql);
        Long count = (Long) query.getSingleResult();
        return Math.toIntExact(count);
    }

    @Override
    public String generateNextId() {
        String hql = "SELECT P.id FROM Program AS P ORDER BY P.id DESC";
        Query idquery = session.createQuery(hql);
        String programId = (String) idquery.setMaxResults(1).uniqueResult();
        return programId;
    }

    @Override
    public Program search(String id) throws Exception {
        try{
            Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
            return session.get(Program.class,id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Program searchProgramById(String selectedProgramId) {

        try(Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession()){
            Query<Program> query = session.createQuery("FROM Program WHERE id = :id", Program.class);
            query.setParameter("id", selectedProgramId);
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
