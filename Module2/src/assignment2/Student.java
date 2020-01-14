package assignment2;

import java.util.Scanner;

public class Student {
    long studNumber;
    String firstName, lastName;
    double[] marks;
    double[] bonus;
    double totalMarks, totalBonus, gpa;
    static final int NUMBER_MARKS = 3;
    Scanner input;

    public Student () {									//No-arg constructor
        this.marks = new double [NUMBER_MARKS];			//initializes NUMBER_MARKS
        this.input = new Scanner (System.in);
    }

    public void readStudentDetails() {
        Scanner input = new Scanner (System.in);
        System.out.print("Enter Student Number: ");		// reads student number
        studNumber = input.nextLong();
        System.out.print("Enter first name: ");			// reads first names
        firstName = input.next();
        System.out.print("Enter last name: "); 			// reads last names
        lastName = input.next();

        readMarks();									// reads marks

        int numberOfBonuses;							// reads the number of bonuses
        do {
            System.out.print("Enter number of bonuses (should not be greater than 5): ");
            numberOfBonuses = input.nextInt();
            if (numberOfBonuses > 5 || numberOfBonuses < 0) {
                System.out.println("Number of bonuses should not be greater than 5!!!\n");}
        } while (numberOfBonuses > 5 || numberOfBonuses < 0);

        if (numberOfBonuses <= 5 && numberOfBonuses >= 0) {
            readBonuses (numberOfBonuses);					// call method readBonuses
            totalMarks+= convertBonus();
        }
    }

    private void readMarks() {							// reads individual marks of the student
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter mark " + (i+1) + " : ");
            marks[i] = input.nextDouble();

            do {
                if (marks[i] > 100 || marks[i] < 0) {
                    System.out.println("Marks should be within 0 and 100. Please re-enter.");
                    marks[i] = input.nextDouble();
                }
            } while (marks[i] > 100 || marks[i] < 0);
            totalMarks+= marks[i];
        }
    }

    private void readBonuses(int numberOfBonusPassed) {				// This method gets the number of bonuses as an argument
        this.bonus = new double [numberOfBonusPassed];
        for (int i = 0; i<numberOfBonusPassed; i++) {				// reads all bonuses and calculates totalBonus.
            System.out.print("Enter bonus " + (i + 1) + " : ");
            bonus[i] = input.nextDouble ();
            this.totalBonus += bonus[i];}
    }

    public void calculateGpa() {
        totalMarks+=convertBonus();									// calls convertBonus() method to get the total adjusted bonus
        if (checkEligibility()==true) {
            gpa = (totalMarks / (NUMBER_MARKS * 100)) * 4;}				// gpa formula
        else if (checkEligibility()==true && gpa > 4) {gpa =4;}		// If gpa is greater than 4, make it 4.
        else if (checkEligibility()==false) {gpa=0;}				// If the student failed in any subject, gpa should be 0, regardless of the marks of other subjects.
    }

    private double convertBonus() {
        if (totalBonus <= 15 && totalBonus >=0) {
            totalBonus = totalBonus/15 * 2;					// Bonus has a weight of 2, so total bonus has to be converted using the formula
        }
        else if (totalBonus > 15) {totalBonus = 15;}	// If it is greater than 15, make it as 15
        return totalBonus;
    }

    private double calculatePercentage() {				// calculates and returns the final percentage
        double calPercentage = (totalMarks / (NUMBER_MARKS * 100)) * 100;
        return calPercentage;
    }

    private String findGradeLetter() {

        if (checkEligibility()==false) return "F";
        if (calculatePercentage()>=90 && calculatePercentage() <=100) return "A+";
        if (calculatePercentage()>=85 && calculatePercentage() <=89) return "A";
        if (calculatePercentage()>=80 && calculatePercentage() <=84) return "A-";
        if (calculatePercentage()>=77 && calculatePercentage() <=79) return "B+";
        if (calculatePercentage()>=73 && calculatePercentage() <=76) return "B";
        if (calculatePercentage()>=70 && calculatePercentage() <=72) return "B-";
        if (calculatePercentage()>=67 && calculatePercentage() <=69) return "C+";
        if (calculatePercentage()>=63 && calculatePercentage() <=66) return "C";
        if (calculatePercentage()>=60 && calculatePercentage() <=62) return "C-";
        if (calculatePercentage()>=57 && calculatePercentage() <=59) return "D+";
        if (calculatePercentage()>=53 && calculatePercentage() <=56) return "D";
        if (calculatePercentage()>=50 && calculatePercentage() <=52) return "D-";
        return 	"F";

    }

    private boolean checkEligibility() {				// boolean method
        for (int i = 0; i<marks.length; i++) {			// checks whether any of the marks of the student is less than 50
            if (marks[i] < 50) {return false;};			// If yes, this method returns false
        }
        return true;									// otherwise returns true
    }

    public void displayStudentDetails() {
        calculateGpa();
        if (checkEligibility()==false) {
            System.out.printf("\n%-20s|%-20s|%-20s|%-20s|%-20s|", studNumber, (firstName +" "+ lastName), String.format ("%.2f", totalMarks), String.format ("%.2f", gpa),  findGradeLetter());
            System.out.print("Failed in one or more courses");}
        else {System.out.printf("\n%-20s|%-20s|%-20s|%-20s|%-20s|", studNumber, (firstName +" "+ lastName), String.format ("%.2f", totalMarks), String.format ("%.2f", gpa), findGradeLetter());}
    }
    //method displays all information of the student (See output below). If the student failed in any of the subjects
//(hint: call checkeEligibility()), print a message, “NOTE: Failed in one or more courses”.
    public static void displayTitle() {
        System.out.println("GPA CALCULATOR");
        System.out.println("=================");
    }

    public static void displayHeader() {
        System.out.println("\n\n"
                + "*************************************************************************");
        System.out.printf("\t\t\tMARK LIST");
        System.out.println("\n*************************************************************************");
        System.out.println();
        System.out.printf("%-20s|%-20s|%-20s|%-20s|%-20s|", "Student Number", "Name", "Total Marks", "GPA", "Grade Letter");
        System.out.print("\n---------------------------------------------------------------------------------------------------------");
    }
}
