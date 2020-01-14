package assignment2;

import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student ();
        student.displayTitle ();									// display Title
        Scanner name = new Scanner (System.in);
        int students;
        System.out.print("Enter number of students: ");				// ask for input from users (number of students)
        students = name.nextInt();
        Student [] numberOfStudents = new Student [students];
        for (int i = 0; i <students; i++) {
            numberOfStudents [i] = new Student ();
            System.out.println("\nEnter details of Student " + (i+1));
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
            numberOfStudents [i].readStudentDetails ();				// read Student Details
        }
        student.displayHeader();									// display Header
        for (int i = 0; i< students; i++) {
            numberOfStudents[i].displayStudentDetails();			// display Student Details
        }

    }
}
