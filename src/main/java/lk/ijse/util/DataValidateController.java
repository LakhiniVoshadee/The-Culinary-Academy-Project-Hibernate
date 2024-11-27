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

    public static boolean studentNameValidate(String studentName) {
        String studentRegex = "^[A-z\\s]{4,15}$";
        Pattern pattern = Pattern.compile(studentRegex);
        Matcher matcher = pattern.matcher(studentName);
        return matcher.matches();
    }

    public static boolean studentAddressValidate(String studentAddress) {
        String studentRegex = "[A-z @ 0-9]{4,20}";
        Pattern pattern = Pattern.compile(studentRegex);
        Matcher matcher = pattern.matcher(studentAddress);
        return matcher.matches();

    }

    public static boolean studentContactValidate(String studentMobile) {
        String studentRegex = "^(?:7|0|(?:\\\\\\\\+94))[0-9]{9,10}$";
        Pattern pattern = Pattern.compile(studentRegex);
        Matcher matcher = pattern.matcher(studentMobile);
        return matcher.matches();
    }

    public static boolean studentEmailValidate(String studentEmail) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(studentEmail);
        return matcher.matches();
    }
}
