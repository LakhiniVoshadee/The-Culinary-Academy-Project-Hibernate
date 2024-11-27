package lk.ijse.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidateController {

///////////////////////////   STUDENT ////////////////////////////////////////
    public static boolean studentIdValidate(String studentId) {
        String studentRegex = "^(S)[0-9]{3}$";
        Pattern pattern = Pattern.compile(studentRegex);
        Matcher matcher = pattern.matcher(studentId);
        return matcher.matches();
    }
}
