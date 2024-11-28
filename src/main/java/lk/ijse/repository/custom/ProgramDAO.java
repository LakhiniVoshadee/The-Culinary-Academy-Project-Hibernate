package lk.ijse.repository.custom;

import lk.ijse.entity.Program;
import lk.ijse.entity.Student;
import lk.ijse.repository.CrudDAO;

public interface ProgramDAO extends CrudDAO<Program,String> {
    int programCount();
    String generateNextId();

    Program search(String id) throws Exception;

    Program searchProgramById(String selectedProgramId);
}
