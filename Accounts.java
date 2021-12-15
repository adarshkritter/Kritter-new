package com.company;

import java.util.*;

public class Accounts{
    Scanner sc = new Scanner(System.in);
    Random ra = new Random();
    int userAge;
    float balanceAmount = 0;
    float withdrawAmount = 0;
    String userName;
    int accountNo;
    int password;

    int checkFunction(float num){
        if (num>0){
            return 1;
        }
        else {
            System.out.println("Invaild entry ");
            return 0;
        }
    }

    void createAccount() {
        System.out.print("\nEnter your name : ");
        userName = sc.nextLine();
        System.out.print("\nEnter your age : ");
        userAge = sc.nextInt();
        System.out.print("\nEnter the amount you wish to deposite : ");
        balanceAmount = sc.nextFloat();
        accountNo= ra.nextInt(123456);
        System.out.println("Your ac has been created. \nThis is your ac no : " + accountNo);
        password = ra.nextInt(9999);
        System.out.println("This is your password : " + password + "\nPlease save this for future reference");
    }

    void withdraw() {
        System.out.print("Enter amount to be withdrawed : ");
        withdrawAmount = sc.nextFloat();
        if(checkFunction(withdrawAmount)==1){
            if(balanceAmount>withdrawAmount){
                balanceAmount = balanceAmount - withdrawAmount;
                System.out.println("Final balance = " + balanceAmount);
            }
        }
    }

    void deposit() {
        System.out.print("Enter amount to deposit : ");
        withdrawAmount = sc.nextFloat();
        if(checkFunction(withdrawAmount)==1){
            balanceAmount=balanceAmount+withdrawAmount;
            System.out.println("Final balance = " + balanceAmount);
        }
    }

    void printDetails() {
        System.out.println("\nName = " + userName);
        System.out.println("Your age = " + userAge);
        System.out.println("Balance = " + balanceAmount + "\n");
    }
}