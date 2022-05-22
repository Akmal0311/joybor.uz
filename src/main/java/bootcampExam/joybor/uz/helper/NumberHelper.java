package bootcampExam.joybor.uz.helper;

public class NumberHelper {

    public static boolean isNumberValid(Integer i){
        return i != null && i >= 9 && i <= 12 ;
    }

    public static Integer toInt(String s){
        try {
            return Integer.parseInt(s);
        }catch (NumberFormatException e){
            return null;
        }
    }

    public static boolean isCardNumber(Integer l){ return l != null && l == 16;}
}
