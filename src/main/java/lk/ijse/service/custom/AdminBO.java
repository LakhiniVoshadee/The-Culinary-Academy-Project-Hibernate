package lk.ijse.service.custom;

import lk.ijse.service.SuperBO;

public interface AdminBO extends SuperBO {
    boolean verifyAdmin(String userName, String password) throws Exception;
}
