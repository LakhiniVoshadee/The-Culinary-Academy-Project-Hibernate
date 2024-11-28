package lk.ijse.service.custom.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.ProgramDTO;
import lk.ijse.entity.Program;
import lk.ijse.repository.DAOFactory;
import lk.ijse.repository.custom.ProgramDAO;
import lk.ijse.service.custom.ProgramBO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProgramBOImpl implements ProgramBO {
    ProgramDAO programDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ProgramDAO);

    @Override
    public boolean saveProgram(ProgramDTO programDTO) {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            programDAO.setSession(session);
            programDAO.save(programDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<ProgramDTO> getAllPrograms() throws SQLException {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        programDAO.setSession(session);
        ArrayList<Program> programs = null;

        try {
            programs = programDAO.getAll();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (programs == null) {
            return new ArrayList<>();
        }

        ArrayList<ProgramDTO> programDTOS = new ArrayList<>();
        for (Program program : programs) {
            programDTOS.add(new ProgramDTO(
                    program.getId(),
                    program.getName(),
                    program.getSeats(),
                    program.getDuration(),
                    program.getFee()
            ));
        }
        session.close();
        return programDTOS;
    }

    @Override
    public boolean updateProgram(ProgramDTO programDTO) throws Exception {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            programDAO.setSession(session);
            programDAO.update(programDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProgram(ProgramDTO programDTO) throws Exception {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            programDAO.setSession(session);
            programDAO.delete(programDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String generateNextProgramId() throws Exception {

        String lastId = programDAO.getLastId();
        return incrementId(lastId);

    }

    @Override
    public ProgramDTO searchProgramById(String selectedProgramId) throws Exception {
        Session session = SessionFactoryConfig.getSessionFactoryConfig().getSession();
        programDAO.setSession(session);
        Program program = programDAO.search(selectedProgramId);
        session.close();
        if (program != null) {
            return new ProgramDTO(
                    program.getId(),
                    program.getName(),
                    program.getSeats(),
                    program.getDuration(),
                    program.getFee()
            );
        } else {
            return null;
        }


    }

    /*@Override
    public ProgramDTO searchProgram(String id) throws Exception {
        Program program = programDAO.search(id);
        return new ProgramDTO(
                program.getId(),
                program.getName(),
                program.getSeats(),
                program.getDuration(),
                program.getFee());
    }*/

    private String incrementId(String lastId) {
        if (lastId == null) {
            return "CAl-0001";
        } else {
            int id = Integer.parseInt(lastId.split("-")[1]);
            id++;
            return String.format("CAl-%04d", id);
        }

    }

}
