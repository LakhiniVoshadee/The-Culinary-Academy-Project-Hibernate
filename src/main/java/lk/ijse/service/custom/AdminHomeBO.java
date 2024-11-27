package lk.ijse.service.custom;

import lk.ijse.service.SuperBO;

public interface AdminHomeBO extends SuperBO {

    int programCount();

    int studentCount();

    int userCount();
}
