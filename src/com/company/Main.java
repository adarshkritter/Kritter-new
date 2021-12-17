package com.company;

import java.lang.*;
import java.util.*;
import com.company.Accounts.*;
//changes
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Main {
    public static void main(String[] args)  {
        int switching;
        boolean loopingCheck = TRUE;
        Scanner sc = new Scanner(System.in);
        ArrayList<Accounts> accountDetails = new ArrayList<Accounts>();
        Accounts acc;
        while(loopingCheck==TRUE) {
            System.out.print("\n\nWelcome to A.S International Bank \n\nPress 1 for creating an account\n" +
                    "Press 2 for login\n" +
                    "Press 3 to exit\n"+
                    "Please enter your response : ");
            switching = sc.nextInt();
            switch (switching) {
                case 1:
                    acc = new Accounts();
                    acc.createAccount();
                    accountDetails.add(acc);
                    break;
                case 2:
                    System.out.print("Enter your account no : ");
                    int userId= sc.nextInt();
                    System.out.print("Enter your password : ");
                    int userPassword= sc.nextInt();
                    for (Accounts i : accountDetails) {
                        if((i.accountNo==userId) && (i.password==userPassword)){
                            while(loopingCheck==TRUE){
                                System.out.println("\nWelcome " +i.userName);
                                System.out.println("Press 1 for display your details\n" +
                                        "Press 2 to withdraw"+
                                        "\nPress 3 to deposite"+
                                        "\nPress 4 to exit" +
                                        "\nPlease enter your response : ");
                                int checkVar= sc.nextInt();
                                if(checkVar==1){
                                    i.printDetails();
                                }
                                else if(checkVar==2){
                                    i.withdraw();
                                }
                                else if(checkVar==3){
                                    i.deposit();
                                }
                                else if(checkVar==4){
                                    break;
                                }
                                else{
                                    System.out.println("Invaild entry");
                                }
                                System.out.println("Do you wish to go back? (1/0) : ");
                                int getting = sc.nextInt();
                                if(getting==1) {
                                    loopingCheck = TRUE;
                                }
                                else{
                                    loopingCheck=FALSE;
                                }
                            }
                        }
                        else {
                            System.out.println("Invaild entry. Please try again");
                        }
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid entry");
            }
            System.out.print("\nDo you wish to continue?(1|0) : ");
            sc.nextLine();
            int getting = sc.nextInt();
            if(getting==1) {
                loopingCheck = TRUE;
            }
            else{
                loopingCheck=FALSE;
            }
        }
        System.out.println("Thank you for using our service. Have a nice day!");
    }
}