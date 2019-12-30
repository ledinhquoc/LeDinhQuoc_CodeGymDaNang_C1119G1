import java.util.Scanner;

public class ConvertTemperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double fahrenheit;
        double celsius;
        int choice;

        do {
            System.out.println("Menu");
            System.out.println("1. fahrenheit to celsius");
            System.out.println("2. celsius to fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice");
            choice=input.nextInt();
            switch (choice){
                case 1:
                System.out.println("enter Fahrenheit: ");
                fahrenheit = input.nextDouble();
                System.out.println("fahrenheit to celsius: " + fahrenheitToCelsius(fahrenheit));
                break;
                case 2:
                    System.out.println("enter Celsius: ");
                    celsius = input.nextDouble();
                    System.out.println("fahrenheit to celsius: " + celsiusToFahrenheit(celsius));

            }
        }while (choice != 0 );

    }
    public static double celsiusToFahrenheit (double celsius){
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }
    public  static double fahrenheitToCelsius(double fahrenheit){
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
        }
    }

