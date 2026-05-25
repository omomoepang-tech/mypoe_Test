/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part123;

/**
 *
 * @author PC
 */

import java.util.Scanner;

public class LoginClass {
    private String firstname = "";
    private String lastname = "";
    private String registeredUser = "";
    private String registeredPass = ""; 
    private String password = "";
    private String phone = "";
    
    
   public LoginClass() {}
   
   public boolean checkUsername(String username) {
       return username.contains("_") && username.length() <= 5;
   }
   
    //Method to check password complexity
   public boolean checkPasswordComplexity(String password) {
       if (password.length() < 8) return false;
       boolean hasUpper = false;
       boolean hasDigit = false;
       boolean hasSpecial = false;
       
       for (char c : password.toCharArray()) {
           if (Character.isUpperCase(c)) hasUpper = true;
           else if (Character.isDigit(c)) hasDigit = true;
           else if (String.valueOf(c).matches("[^a-za-z0-9]")) hasSpecial = true;          
       }
       return hasUpper && hasDigit && hasSpecial;
   }
   
   //Method to register user
   public String registerUser(String username, String password, String firstName, String lastName) {
       if (!checkUsername(username)) {
           return "Username is not correctly formatted, please ensure  that your username contains an underscore and is no more than 5 characters in length.";
       }
       if (!checkPasswordComplexity(password)) {           
       }
       
       this.registeredUser = username;
       this.registeredPass = password;
       this.firstname = firstname;
       this.lastname = lastname;
       
       return "Welcome " + firstName + " ," + lastName + "it is great to see you.";
   }
   
   //Method to check logins
   public boolean loginUser(String enteredUser, String enteredPass) {
       return enteredUser.equals(this.registeredUser) && enteredPass.equals(this.registeredPass);
   }
   
    // Method to return string status
   public String returnLoginStatus(boolean loggedIn) {
       if (loggedIn) {
       return "A successful login!" ;
       } else {
           return "Failed login attempt.";
       }
   }
   
   //Method to validate phone numbers
   public boolean checkCellNumberFormat(String cellNumber) {
       return cellNumber.startsWith("+") && cellNumber.length() <= 12;
   }
       
       
       
    public static void main(String[] args) {
    
        Scanner input =  new Scanner(System.in);
        LoginClass login = new LoginClass(); //Create acess registration methods
           
        System.out.println("--- Account Registration ---");
        System.out.print("Enter first Name: ");
        String firstName = input.nextLine();
           
        System.out.print("Enter last Name: ");
        String lastName = input.nextLine();
           
        System.out.print("Create username");
        String registeredUser = input.nextLine();
        
        System.out.print("Create password");
        String registeredPass = input.nextLine();
        
        //Process registration
        String regStatus = login.registerUser(registeredUser, registeredPass, firstName, lastName);
        System.out.println(regStatus);
        
        //Login registration if successful
        if (regStatus.startsWith("Welcome")) {
            System.out.println("\n--- Account Login ----");
            System.out.print("Enter login username: ");
            String loginUser = input.nextLine();
            System.out.print("Enter login pasword: ");
            String loginPass = input.nextLine();
            
            boolean loginResult = login.loginUser(loginUser, loginPass);
            System.out.println(login.returnLoginStatus(loginResult));         
        }
    }       
}          
                   
           
           
       
       
       


    
    
   