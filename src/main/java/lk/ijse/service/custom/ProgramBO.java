package lk.ijse.service.custom;

import lk.ijse.dto.ProgramDTO;
import lk.ijse.service.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProgramBO extends SuperBO {
    boolean saveProgram(ProgramDTO programDTO) throws Exception;

    ArrayList<ProgramDTO> getAllPrograms() throws SQLException;

    boolean updateProgram(ProgramDTO programDTO) throws Exception;

    boolean deleteProgram(ProgramDTO programDTO) throws Exception;

    String generateNextProgramId() throws Exception;

    ProgramDTO searchProgram(String id) throws Exception;
}
