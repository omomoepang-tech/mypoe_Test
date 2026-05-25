/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.part123;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class MessageClassTest {
    
    public MessageClassTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkRecipientCell method, of class MessageClass.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        MessageClass instance = new MessageClass("+27123456789", "Hello World");
        String expResult = "";
        String result = instance.checkRecipientCell();
        assertEquals("Valid Recipient", instance.checkRecipientCell());
              
    }

    /**
     * Test of createMessageHash method, of class MessageClass.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        MessageClass instance = new MessageClass("+27123456789", "Hello World");
        String expResult = "";
        String result = instance.createMessageHash();
        assertTrue(result.endsWith("HELLOWORLD"));
          
    }

    /**
     * Test of SentMessage method, of class MessageClass.
     */
    @Test
    public void testSentMessage() {
        System.out.println("SentMessage");
        int choice = 0;
        MessageClass instance = new MessageClass("+27123456789", "Test Message");
        String expResult = "";
        String result = instance.SentMessage(choice);
        assertEquals("Message succesfully sent", instance.SentMessage(1));
        assertEquals("Message deleted successfully", instance.SentMessage(2));
        assertEquals("Message successfully stored", instance.SentMessage(3));
            
    }

    /**
     * Test of printMessages method, of class MessageClass.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        MessageClass instance = new MessageClass("+27123456789", "Hllo World");
        String expResult = "";
        String result = instance.printMessages();
        assertNotNull(result);
        assertTrue(result.contains("Recipient: +27123456789"));
        assertTrue(result.contains("Message: Hello World"));
        
    }

    /**
     * Test of returnTotalMessages method, of class MessageClass.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        MessageClass instance = new MessageClass("+27123456789", "Counter Check");
        int initialCount = MessageClass.returnTotalMessages();      
        instance.SentMessage(1);
        int expResult = initialCount + 1;
        int result =  MessageClass.returnTotalMessages();       
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of storeMessage method, of class MessageClass.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        MessageClass instance = new MessageClass("+27123456789", "JSON Test");    
        instance.storeMessage();
        try {
            instance.storeMessage();
            assertTrue(true);
        } catch (Exception e) {
            fail("storeMessage crashed: " + e.getMessage());
        }
    }


    /**
     * Test of getMessageId method, of class MessageClass.
     */
    @Test
    public void testGetMessageId() {
        System.out.println("getMessageId");
        MessageClass instance = new MessageClass("+27123456789", "JSON Test");
        String expResult = "";
        String result = instance.getMessageId();
        assertNotNull(result);
        assertFalse(result.isEmpty());
       
        
    }

    /**
     * Test of getRecipientCell method, of class MessageClass.
     */
    @Test
    public void testGetRecipientCell() {
        System.out.println("getRecipientCell");
        MessageClass instance = null;
        String expectedCell = "+27123456789";
        String result = instance.getRecipientCell();
        assertEquals(expectedCell, result);
       
        
    }

    /**
     * Test of getMessageText method, of class MessageClass.
     */
    @Test
    public void testGetMessageText() {
        System.out.println("getMessageText");
        String expectedText = "JSON Test";
        MessageClass instance = new MessageClass("+27123456789", expectedText);
        String expResult = "";
        String result = instance.getMessageText();
        assertEquals(expectedText, result);
     
        
    }
    
}
