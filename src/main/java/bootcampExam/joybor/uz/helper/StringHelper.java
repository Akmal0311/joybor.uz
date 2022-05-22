package bootcampExam.joybor.uz.helper;

public class StringHelper {

    public static boolean isValid(String s){
        return s != null && s.length() > 0;
    }

    public static boolean isValidDigit(String s){
        try {
            return NumberHelper.isNumberValid(Integer.parseInt(s));
        }catch (NumberFormatException e){
            return false;
        }
    }


    public static boolean isValidField(String fieldName){
        return fieldName == null || fieldName.trim().length() < 1;
    }
}
