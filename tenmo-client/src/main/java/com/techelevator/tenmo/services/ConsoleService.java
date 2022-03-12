package com.techelevator.tenmo.services;


import com.techelevator.tenmo.model.RequestInfo;
import com.techelevator.tenmo.model.SendInfo;
import com.techelevator.tenmo.model.UserCredentials;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printGreeting() {
        System.out.println("*********************");
        System.out.println("* Welcome to TEnmo! *");
        System.out.println("*********************");
    }

    public void printLoginMenu() {
        System.out.println();
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("1: View your current balance");
        System.out.println("2: View your past transfers");
        System.out.println("3: View your pending requests");
        System.out.println("4: Send TE bucks");
        System.out.println("5: Request TE bucks");
        System.out.println("0: Exit");
        System.out.println();
    }
//-----------------
    public void printAccountBalance() {
        System.out.println();
        System.out.println("Your current balance is: " );  // somevariable from server );
        System.out.println();
    }

    public void viewTransferHistory() {
        System.out.println();
        System.out.println("Your Transfer history is: "); // somevariable from server );
        System.out.println();
    }

    public void viewPendingRequests(){
        System.out.println();
        System.out.println("your pending request are as is"); //somevariable recieved
        System.out.println();
    }

    public SendInfo sendBucks(){
        System.out.println();
        String recipientOfPayment = promptForString("Who would you like to send money to? ");
        BigDecimal amount= promptForBigDecimal("How much? ");
        System.out.println();
        return new SendInfo(recipientOfPayment, amount);
    }

    public RequestInfo requestBucks(){
        System.out.println();
        String recipientOfRequest = promptForString("Who are you requesting payment from? ");
        BigDecimal amount= promptForBigDecimal("How much? ");
        System.out.println();
        return new RequestInfo(recipientOfRequest, amount);
    }
//-----------------
    public UserCredentials promptForCredentials() {
        String username = promptForString("Username: ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public BigDecimal promptForBigDecimal(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

}
