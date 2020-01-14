package Ultils.Validation;

public class ServiceValidate {
    private static String regex = "";

    public static boolean validateName(String serviceName) {
        regex = "^((\\p{Lu})(\\p{Ll}*))( (\\p{Lu})(\\p{Ll}*))*$";
        if (serviceName.matches(regex)) {
            return true;
        } else {
            System.out.println("Your input information illegal.Please try again");
            return false;
        }
    }

    public static boolean validateAreaUsedOrPoolArea(double area) {
        if (area > 30) {
            return true;
        } else {
            System.out.println("AreaUsed have to be bigger than 30");
            System.out.println("Please input customer information again");
            return false;
        }
    }

    public static boolean validateFloor(int floor) {
        if (floor > 0) {
            return true;
        } else {
            System.out.println("Floor have to be bigger than 0");
            System.out.println("Please input customer information again");
            return false;
        }
    }

    public static boolean validateMaxPeople(int number) {
        if (number > 0 && number < 20) {
            return true;
        } else {
            System.out.println("Max people have to be bigger than 0 and smaller than 20");
            System.out.println("Please input customer information again");
            return false;
        }
    }

    public static boolean validatePrice(double price) {
        if (price > 0) {
            return true;
        } else {
            System.out.println("Price have to be bigger than 0");
            System.out.println("Please input customer information again");
            return false;
        }
    }

    public static boolean validateServiceDescription(String serviceDescription) {
        if (serviceDescription.equals("massage") ||
                serviceDescription.equals("karaoke") ||
                serviceDescription.equals("food") ||
                serviceDescription.equals("drink") ||
                serviceDescription.equals("car")){
            return true;
        }else {
            System.out.println("Accompanying service have to be : massage, karaoke, food , drink and car");
            System.out.println("Please input customer information again");
            return false;
        }
    }
}
