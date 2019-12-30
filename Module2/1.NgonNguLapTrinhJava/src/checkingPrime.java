public class checkingPrime {
    public static void main(String[] args) {
        int i = 2;
        boolean check = true;
        int number;

        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println(" enter number : ");
        number = input.nextInt();

        while (i <= Math.sqrt(number)) {
            if (number % i == 0) {
                check = false;
                break;
            }
            i++;
        }
        if (check) {
            System.out.println(number + "la so nguyen to");
        } else {
            System.out.println(number + "khong phai la so nguyen to");
        }
    }
}
