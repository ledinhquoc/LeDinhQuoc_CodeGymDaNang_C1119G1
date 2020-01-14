package Ultils.Validation;

import java.time.LocalDate;
import java.util.Locale;

public class CustomerValidate {
    private static String regex = "";

    public static boolean validateName(String serviceName){
        regex = "^((\\p{Lu})(\\p{Ll}*))( (\\p{Lu})(\\p{Ll}*))*$";

        if (serviceName.matches(regex)){
            return true;
        }
        System.out.println("Your information do not match the validation.Please try again");
        return false;
    }
    public static boolean validateEmail(String email){
        regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (email.matches(regex)){
            return true;
        }
        System.out.println("Your information do not match the validation.Please try again");
        return false;
    }
    public static String validateGender(String gender){
        if (gender.toLowerCase().equals("male")){
            return "Male";
        }
        else if (gender.toLowerCase().equals("female")){
            return "Female";
        }else if (gender.toLowerCase().equals("unKnow")){
            return "unKnow";
        }else {
            System.out.println("Gender have to be : Male, Female, unKnow");
            return "False";
        }
    }
    public static boolean validateBirthday(String day){
        regex =  "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$" ;
        while (true){
            LocalDate date = LocalDate.now();

            if (day.matches(regex)){
                String temp = "";
                for (int i = day.length() - 4; i < day.length(); i++){
                    temp += day.charAt(i);
                }
                if (date.getYear() - Integer.valueOf(temp) >= 18 &&(Integer.parseInt(temp) > 1900)){
                    return  true;
                }else {
                    System.out.println("Birthday have to be bigger than 1900 and smaller than the current 18 year,matching with dd/mm/yyyy validation ");
                    return false;
                }
            }else {
                System.out.println("Your information of birthday not match the validation");
                return false;
            }
        }
    }
    public static boolean validateIdCard(String idCard){
           regex = "^\\d{3}\\s\\d{3}\\s\\d{3}$";
           if (idCard.matches(regex)){
               return true;
           }else {
               System.out.println("ID card have to have 9 number and following the validation XXX XXX XXX");
               return false;
           }
    }
}
