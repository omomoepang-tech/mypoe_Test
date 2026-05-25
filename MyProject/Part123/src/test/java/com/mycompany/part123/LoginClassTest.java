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
public class LoginClassTest {
    
    public LoginClassTest() {
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
     * Test of checkUsername method, of class LoginClass.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String username = "j_doe";
        LoginClass instance = new LoginClass();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
        assertFalse(instance.checkUsername("john_doe"));
        assertFalse(instance.checkUsername("johnd"));
        
     
        
    }

    /**
     * Test of checkPasswordComplexity method, of class LoginClass.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch@llenge26";
        LoginClass instance = new LoginClass();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        assertFalse(instance.checkPasswordComplexity("A1!"));
        assertFalse(instance.checkPasswordComplexity("Password123"));
        assertEquals(expResult, result);
        
    
    }

    /**
     * Test of registerUser method, of class LoginClass.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String username = "j_doe";
        String password = "Ch@llenge@26";
        String firstName = "John";
        String lastName = "Doe";
        LoginClass instance = new LoginClass();
        String expResult = "Welcome John , Doe it is great to see you.";
        String result = instance.registerUser("j_doe", "Ch@llenge26","John", "Doe");
        assertEquals(expResult, result);
       
      
    }

    /**
     * Test of loginUser method, of class LoginClass.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String enteredUser = "j_doe";
        String enteredPass = "Ch@llenge26";
        LoginClass instance = new LoginClass();   
        boolean expResult = true;
        boolean result = instance.loginUser("j_doe", "Ch@llenge26");
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of returnLoginStatus method, of class LoginClass.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        boolean loggedIn = true;
        LoginClass instance = new LoginClass();
        String expResult = "A successful login!";
        String result = instance.returnLoginStatus(loggedIn);
        assertEquals(expResult, result);
        //When loggedIn is false
        assertNotEquals("A successful login!", instance.returnLoginStatus(false));
      
       
    }

    /**
     * Test of checkCellNumberFormat method, of class LoginClass.
     */
    @Test
    public void testCheckCellNumberFormat() {
        System.out.println("checkCellNumberFormat");
        String cellNumber = "+271234567";
        LoginClass instance = new LoginClass();
        boolean expResult = true;
        boolean result = instance.checkCellNumberFormat(cellNumber);
        assertEquals(expResult, result);
       //Invalid phone number
       assertFalse(instance.checkCellNumberFormat("0712345678"));
        
    }

    /**
     * Test of main method, of class LoginClass.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        
        //Check client details
        String simulatedInput = "John\n"
                              + "Doe\n"
                              + "j_doe\n"
                              + "Ch@llenge26\n"
                              + "j_doe\n"
                              + "Ch@llenge26";
        
        //Directed standard system input
        java.io.InputStream originalIn = System.in;
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));
        
        try{
  
        String[] args = null;
        LoginClass.main(args);
        
        //If the application is complete
        assertTrue(true);
        } finally {
            System.setIn(originalIn);
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
