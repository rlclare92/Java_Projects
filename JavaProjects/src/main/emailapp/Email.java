package main.emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String  email;
    private String alternateEmail;
    private String companySuffix = ".company.com";

    private int defaultPasswordLength = 10;
    private int mailboxCapacity = 500;

    // Constructor to receive the first and last name.
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
       //System.out.println("Email created: " + this.firstName + " " + this.lastName);

        //Call a method asking for the department - return the department
        this.department = setDepartment();
        //System.out.println("Department " + this.department);

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your generated password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
        //System.out.println("Your email is: " + email);
    }

    // Ask for the department.
    private String setDepartment() {
        System.out.println("New worker: " + firstName + "\nDepartment Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1) { return "Sales";}
        else if (departmentChoice == 2) { return "Development";}
        else if (departmentChoice == 3) {return "Accounting";}
        else {return "";}
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@£$%^&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "Display Name: " + firstName + " " + lastName +
        "\nCompany Email: " + email +
        "\nMailbox Capacity: " + mailboxCapacity + " mb";
    }
}
