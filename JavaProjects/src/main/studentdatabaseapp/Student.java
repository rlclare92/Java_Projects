package main.studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String  courses = null;
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;
    private int payment;

    //Constructor: Prompt user to enter student's name and year
    public Student() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = sc.nextLine();

        System.out.println("Enter student last name: ");
        this.lastName = sc.nextLine();

        System.out.println("\nEnter student grade year:\n1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior");
        this.gradeYear = sc.nextInt();
        System.out.println("You have entered: " + gradeYear);

        setStudentId();

    }

    // Generate an ID
    private void setStudentId() {
        //Grade level + ID
        id++;
        this.studentID =  gradeYear + "" + id;
    }

    // Enroll into courses
    public void enroll() {
        //Get inside a loop and user hits 0 when they have finished enrolling.
        System.out.println("Enter course to enroll, press Q to quit: ");
        do {
            Scanner sc = new Scanner(System.in);
            String course = sc.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            }
            else {break;}
        } while (1 != 0);
    }

    // View balance
    public void viewBalance() {
        System.out.println("Your Balance is: £" + tuitionBalance);
    }
    // pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Please enter your payment amount: £");
        Scanner sc = new Scanner(System.in);
        int payment = sc.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of £" + payment);
        viewBalance();
    }

    //Display student info (name, ID, courses enrolled and balance)
    public String showInfo() {
        return "Name: " + firstName +  " " + lastName +
                "\n Grade Level: " +  gradeYear +
                "\n StudentId: " + studentID +
                "\nCourses enrolled: " + courses +
                "\nBalance: £" + tuitionBalance;
    }



}
