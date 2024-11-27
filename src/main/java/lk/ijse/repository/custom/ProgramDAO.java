package lk.ijse.repository.custom;

import lk.ijse.entity.Program;
import lk.ijse.repository.CrudDAO;

public interface ProgramDAO extends CrudDAO<Program,String> {
    int programCount();
}
