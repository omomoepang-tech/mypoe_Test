/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part123;

/**
 *
 * @author PC
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MessageClass {
    
    // Variables
    private String messageId;
    private String recipientCell;
    private String messageText;
    private int messageNumber;
    
    // Static variables
    private static int totalMessagesSent = 0;
    private static List<String> sentMessagesLog = new ArrayList<>();
    
    // Constructor
    public MessageClass(String recipientCell, String messageText) {
         this.messageId = generateRandomID ();
         this.recipientCell = recipientCell;
         this.messageText = messageText;
         this.messageNumber = totalMessagesSent;
    }
         
    // Generate 10 digit numbers
    private String generateRandomID() {
    Random random = new Random();
    long id = 1000000000L + (long)(random.nextDouble() * 9000000000L);
    return String.valueOf(id);
    }
    
    // Check Message ID
    private boolean checkMessageID() {
        return this.messageId != null && this.messageId.length() <= 10;       
    }
    
    // Check RecipientCell
    public String checkRecipientCell() {
        if (recipientCell.startsWith("+") || recipientCell.length() <= 12) {
            return "Valid Recipient";            
        }
        return "Invalid Recipient";
    }
    
    // Create Message Hash
    public String createMessageHash() {
        String firstTwoId = this.messageId.substring(0, 2);
        String[] words = this.messageText.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 0 ? words[words.length - 1] : "";
        
        // Remove special characters
        String combinedWords = (firstWord + lastWord).replaceAll("[^a-zA-Z0-String]", "").toUpperCase();
        return firstTwoId + ":" + this.messageNumber + ":" + combinedWords;      
    }
    
    
    // Sent message action processing
    public String SentMessage(int choice) {
       switch(choice) {
           case 1: //Send Message
           totalMessagesSent++;
           sentMessagesLog.add(printMessages());
               return "Message successfuly sent";
           case 2: //Disregarded Message
               return "Message deleted successfully";
            case 3: // Store Message
                storeMessage();
                return "Message successfully stored";
                default:
                    return "Invalid choice"; 
       }
    }
       
    // Print messages
    public String printMessages() {
        return "Message ID: " + this.messageId +
               ", Message Hash: " + createMessageHash() +
               ", Recipient: " + this.recipientCell +
               ", Message: " + this.messageText;
    }
    
    // Return total Messages sent
    public static int returnTotalMessages() {
        return totalMessagesSent;
    }
    
    // Store messages into JSON
    public void storeMessage() {
        String json = "{\n" +
               " \"messageId\": \"" + this.messageId + "\",\n" +
               " \"recipient\": \"" + this.recipientCell + "\",\n" +
               " \"messageHash\": \"" + createMessageHash() + "\",\n" +
               " \"message\": \"" + this.messageText + "\"\n" +
               "}";
        System.out.println("--- Saved to JSON storage ---\n" + json);
    }
    
    // Testing
    public String getMessageId() { return messageId; }
    public String getRecipientCell() { return recipientCell; }
    public String getMessageText() { return messageText; }
}

    

