class MyClass {
    public static void main(String[] args) {

        java.util.Scanner myObj = new java.util.Scanner(System.in);
        String userName;
        System.out.println("GPA CALCULATOR");
        System.out.println("===============");
            System.out.print("Enter username: ");
        userName = myObj.nextLine();
        java.util.Scanner myObj1 = new java.util.Scanner(System.in);
        String firstName;
            System.out.print("Enter firstname: ");
         firstName = myObj1.nextLine();
        java.util.Scanner myObj2 = new java.util.Scanner(System.in);
        String lastName;
        System.out.print("Enter lastname: ");
        lastName = myObj2.nextLine();
        java.util.Scanner myObj3 = new java.util.Scanner(System.in);
        Long studNumber ;
        System.out.print("Enter studNumber: ");
        studNumber = Long.parseLong(myObj3.nextLine());
        String[]

        System.out.println("*********************************************" );
        System.out.println("                 MARK LIST" );
        System.out.println("*********************************************" );
        System.out.println("|"+"Student Number" + "|"+"Name"+"|"+"studNumber"+"|" );
        System.out.println(studNumber + "|"+(firstName +lastName )+"|"+userName +"|" );

    }
}