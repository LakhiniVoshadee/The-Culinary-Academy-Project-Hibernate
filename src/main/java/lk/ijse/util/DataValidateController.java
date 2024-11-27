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




    //////////////////////////// PROGRAM ////////////////////////////////


    public static boolean programIdValidate(String programId) {
        String programRegex = "^(CAl)[0-9]{3}$";
        Pattern pattern = Pattern.compile(programRegex);
        Matcher matcher = pattern.matcher(programId);
        return matcher.matches();
    }

    public static boolean programNameValidate(String programName) {
        String programRegex = "^[A-z\\s]{4,20}$";
        Pattern pattern = Pattern.compile(programRegex);
        Matcher matcher = pattern.matcher(programName);
        return matcher.matches();

    }

    public static boolean programSeatsValidate(String programSeats) {
        String programRegex = "^[1-9][0-9]*$";
        Pattern pattern = Pattern.compile(programRegex);
        Matcher matcher = pattern.matcher(programSeats);
        return matcher.matches();

    }

    public static boolean programDurationValidate(String programDuration) {
        String programRegex =  "^(\\d+)(?:\\.?\\d{0,2})?$";
        Pattern pattern = Pattern.compile(programRegex);
        Matcher matcher = pattern.matcher(programDuration);
        return matcher.matches();

    }

    public static boolean programFeeValidate(String programFee) {
        String programRegex = "^(\\d+\\.?\\d{0,2})$";
        Pattern pattern = Pattern.compile(programRegex);
        Matcher matcher = pattern.matcher(programFee);
        return matcher.matches();

    }




    ////////////////////////// USER ///////////////////////////////

    public static boolean userIdValidate(String userId) {
        String userRegex = "^(U)[0-9]{3}$";
        Pattern pattern = Pattern.compile(userRegex);
        Matcher matcher = pattern.matcher(userId);
        return matcher.matches();
    }


    public static boolean userNameValidate(String userName) {
        String userRegex = "^[A-z\\s]{4,20}$";
        Pattern pattern = Pattern.compile(userRegex);
        Matcher matcher = pattern.matcher(userName);
        return matcher.matches();

    }

    public static boolean userPasswordValidate(String password) {

        String userRegex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
        Pattern pattern = Pattern.compile(userRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean userEmailValidate(String userEmail) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(userEmail);
        return matcher.matches();

    }

    public static boolean userMobileValidate(String userMobile) {
        String userRegex = "^(?:7|0|(?:\\\\\\\\+94))[0-9]{9,10}$";
        Pattern pattern = Pattern.compile(userRegex);
        Matcher matcher = pattern.matcher(userMobile);
        return matcher.matches();

    }

    public static boolean userAddressValidate(String userAddress) {
        String userRegex = "[A-z @ 0-9]{4,20}";
        Pattern pattern = Pattern.compile(userRegex);
        Matcher matcher = pattern.matcher(userAddress);
        return matcher.matches();

    }
}
