package com.fullstack.project_fullstack.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserTest {


//    @InjectMocks
//    private User user;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Mock
     PasswordUtils passwordUtils=new PasswordUtils();

    User user;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        user = new User();

    }

    @Test
    public void testGettersAndSetters() {
        // Arrange
        String username = "john_doe";
        String email = "john@example.com";
        String password = "password";
        String accountNumber = "NXT123456789";
        String address = "123 Main St";
        String id = "12345";


        user.setUsername(username);
        user.setEmail(email);
       // user.setPassword(password);
       // user.setAccountNumber();
        user.setAddress(address);

        // Assert
        Assertions.assertEquals(username, user.getUsername());
        Assertions.assertEquals(email, user.getEmail());
       // Assertions.assertEquals(password, user.getPassword());
        // Assertions.assertEquals(accountNumber, user.getAccountNumber());
        Assertions.assertEquals(address, user.getAddress());
    }

//    @Test
//    public void testSetAccountNumber() {
//        // Arrange
//
//        String accountNumber = "NXT123456789";
//
//        // Mocking the Random class and its nextInt method
//        Random random = new Random();
//        when(random.nextInt(100000000)).thenReturn(123456789);
//
//        // Mocking the User class to use the mocked Random object
//        User user = new User() {
//            // @Override
//            public Random getRandom() {
//                return random;
//            }
//        };
//        user.setAccountNumber();
//        assertEquals(accountNumber, user.getAccountNumber());
//    }

  //  @Test
//    public void testSetAccountNumber() {
//        // Arrange
//        String accountNumber = "NXT123456789";
//
//        // Mocking the Random class and its nextInt method
//        Random random = mock(Random.class);
//        when(random.nextInt(100000000)).thenReturn(123456789);
//
//        // Mocking the User class
//        User user = mock(User.class);
//        when(user.getRandom()).thenReturn(random);
//
//        // Act
//        user.setAccountNumber();
//
//        // Assert
//        assertEquals(accountNumber, user.getAccountNumber());
//    }


//    @Test
//    public void testSetPassword() {
//        // Arrange
//        String password = "password";
//        String encodedPassword = "password";
//
//        // Mocking the BCryptPasswordEncoder and its encode method
//        when(passwordEncoder.encode(password)).thenReturn(encodedPassword);
//
//
//        // Act
//        user.setPassword(password);
//
//        // Assert
//        Assertions.assertEquals(encodedPassword, user.getPassword());
//    }
//@Test
//public void testSetPassword() {
//    // Arrange
//    String password = "password";
//    String encodedPassword = "password";
//
//    BCryptPasswordEncoder passwordEncoder = mock(BCryptPasswordEncoder.class);
//    when(passwordEncoder.encode(password)).thenReturn(encodedPassword);
//
//    User user = new User();
//    user.setPasswordEncoder(passwordEncoder);
//
//    // Act
//    user.setPassword(password);
//
//    // Assert
//    Assertions.assertEquals(encodedPassword, user.getPassword());
//}




}



//}