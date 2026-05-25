/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part123;

/**
 *
 * @author PC
 */

import java.util.Scanner;

public class Part123 {

    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         LoginClass login = new LoginClass(); //Access to registration
         
         System.out.println("--- Account Registration ---");
         System.out.print("Enter first Name: ");
         String firstName =input.nextLine();
         
         System.out.print("Enter last Name: ");
         String lastName = input.nextLine();
         
         System.out.print("Create username: ");
         String registeredUser = input.nextLine();
         
         System.out.print("Create password: ");
         String registeredPass = input.nextLine();
         
         // Process registration using the LoginClass
         String regStatus = login.registerUser(registeredUser, registeredPass, firstName, lastName);
         System.out.println(regStatus);
         
         // Check if there was a successful registration
         if (regStatus.startsWith("Welcome")) {
             System.out.println("\n--- Account Login ---");
             System.out.print("Enter login username: ");
             String loginUser = input.nextLine();
             
             System.out.print("Enter login password: ");
             String loginPass = input.nextLine();
             
             boolean loginResult = login.loginUser(loginUser, loginPass);
             System.out.println(login.returnLoginStatus(loginResult));
             
    // Proceed to message system if login succeeds
    if (loginResult) {
        System.out.println("\nWelcome to QuickChat.");
            
        System.out.print("How many messages to you wish to enter:? ");
        int totalMessagesAllowed = input.nextInt();
        String cell = input.nextLine();
            
        int messagesSentCount = 0;
        int menuChoice =0;
            
        while(menuChoice != 3){
        System.out.println("\nSelect an option: ");
        System.out.println("1) Send Messages");
        System.out.println("2) Show recently sent messages");
        System.out.println("3) Quit");
        System.out.println("Enter choice");
        menuChoice = input.nextInt();
        input.nextLine();
                
           if(menuChoice == 1) {
               if (messagesSentCount >= totalMessagesAllowed) {
                   System.out.println("Limit reached. You can only enter " + totalMessagesAllowed + " messages.");
                   } else {
                   System.out.println("\n--- Create a Message ---: ");
                   System.out.print("Enter recipient cell phone (+ required): ");
                   cell = input.nextLine();
                        
                   System.out.print("Enter message text: ");
                 String text = input.nextLine();
                        
                    MessageClass userMessage = new MessageClass(cell, text);
                        
                    System.out.println("\nCell Verification: " + userMessage.checkRecipientCell());
                    System.out.println("Generated Hash: " + userMessage.createMessageHash());
                        
       //Proccessing System
        System.out.println("\n--- Action Menu ---");
        System.out.println("1.Send Message");
        System.out.println("2.Delete Message");
        System.out.print("Choose an option (1-2): ");
                        
            if (input.hasNextInt()) {
            int choice = input.nextInt();
            String actionResult = userMessage.SentMessage(choice);
            System.out.println("\nSystem Outcome: "+ actionResult); 
            if (choice ==1) {
                System.out.println("\n--- Sent Summary Layout ---\n" + userMessage.printMessages());
                messagesSentCount++;
            }
           }         
         }
        }
           else if (menuChoice == 2) {
            System.out.println("Coming soon.");
            }
           else if (menuChoice == 3) {
               System.out.println("Goodbye!");
           }
           else {
               System.out.println("Invalid option. Please try again.");
           }
        }
        
        //Print total message
        System.out.println("\nTotal Messages Counter: " + MessageClass.returnTotalMessages());
    } else {
        System.out.println("Program stopped because registration rules were broken." );
    }
         }
         System.out.println("======================") ;
    }
}
           
                        
                        
                        
                        
                        
                