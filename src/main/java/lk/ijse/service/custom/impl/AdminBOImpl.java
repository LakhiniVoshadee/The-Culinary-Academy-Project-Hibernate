package lk.ijse.service.custom.impl;

import lk.ijse.repository.DAOFactory;
import lk.ijse.repository.custom.AdminDAO;
import lk.ijse.service.custom.AdminBO;

import java.sql.ResultSet;

public class AdminBOImpl implements AdminBO {
    @Override
    public boolean verifyAdmin(String userName, String password) throws Exception {
        AdminDAO adminDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.AdminDAO);

        ResultSet resultSet = adminDAO.verifyAdmin(userName, password);
        String pwd = "";
        if (resultSet.next()) {
            pwd = resultSet.getString(1);
            if (pwd.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
