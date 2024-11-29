package lk.ijse.service.custom;

import lk.ijse.service.SuperBO;

public interface RegistrationBO extends SuperBO {
    String generateNextRegistrationId() throws Exception;
}
