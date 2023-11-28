package com.fullstack.project_fullstack.Controller;

import com.fullstack.project_fullstack.Services.AccountService;
import com.fullstack.project_fullstack.Services.UserService;
import com.fullstack.project_fullstack.model.Account;
import com.fullstack.project_fullstack.model.LoginRequest;
import com.fullstack.project_fullstack.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {


    @Mock
    private UserService userService;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        accountService = mock(AccountService.class);
    }

//    @Test
//    void createUser_ShouldReturnCreatedUser() {
//        // Arrange
//        User mockUser = mock(User.class);
//        String generatedAccountNumber = "1234567890";
//        Account mockAccount = mock(Account.class);
//
//        when(mockUser.getAccountNumber()).thenReturn(generatedAccountNumber);
//        when(accountService.createAccount(mockAccount)).thenReturn(mockAccount);
//        when(userService.createUser(mockUser)).thenReturn(mockUser);
//
//        // Act
//        User createdUser = userController.createUser(mockUser);
//
//        // Assert
//        Assertions.assertEquals(mockUser, createdUser);
//        verify(mockUser, times(1)).setAccountNumber();
//        verify(accountService, times(1)).createAccount(mockAccount);
//    }

    @Test
    void getUser_WithValidId_ShouldReturnUser() {
        // Arrange
        String userId = "123";
        User mockUser = Mockito.mock(User.class);
        when(userService.getUser(userId)).thenReturn(mockUser);

        // Act
        User retrievedUser = userController.getUser(userId);

        // Assert
        Assertions.assertEquals(mockUser, retrievedUser);
        verify(userService, times(1)).getUser(userId);
    }

    @Test
    void getAllUsers_ShouldReturnListOfUsers() {
        // Arrange
        List<User> mockUsers = Arrays.asList(Mockito.mock(User.class), Mockito.mock(User.class));
        when(userService.getAllUsers()).thenReturn(mockUsers);

        // Act
        List<User> allUsers = userController.getAllUsers();

        // Assert
        Assertions.assertEquals(mockUsers, allUsers);
        verify(userService, times(1)).getAllUsers();
    }



    @Test
    void getUser_WithInvalidId_ShouldReturnNull() {
        // Arrange
        String invalidId = "invalid";
        when(userService.getUser(invalidId)).thenReturn(null);

        // Act
        User retrievedUser = userController.getUser(invalidId);

        // Assert
        Assertions.assertNull(retrievedUser);
        verify(userService, times(1)).getUser(invalidId);
    }



    @Test
    void login_WithValidCredentials_ShouldReturnUserId() {
        // Arrange
        LoginRequest mockLoginRequest = Mockito.mock(LoginRequest.class);
        User mockUser = Mockito.mock(User.class);
        when(mockLoginRequest.getEmail()).thenReturn("test@example.com");
        when(mockLoginRequest.getPassword()).thenReturn("password");
        when(userService.login("test@example.com", "password")).thenReturn(mockUser);
        when(mockUser.getId()).thenReturn("123");

        // Act
        String userId = userController.login(mockLoginRequest);

        // Assert
        Assertions.assertEquals("123", userId);
    }


    @Test
    void login_WithInvalidCredentials_ShouldReturnError() {
        // Arrange
        LoginRequest mockLoginRequest = Mockito.mock(LoginRequest.class);
        when(mockLoginRequest.getEmail()).thenReturn("invalid@example.com");
        when(mockLoginRequest.getPassword()).thenReturn("wrongpassword");
        when(userService.login("invalid@example.com", "wrongpassword")).thenReturn(null);

        // Act
        String result = userController.login(mockLoginRequest);

        // Assert
        Assertions.assertEquals(null, result);
    }

    @Test
    void login_WithNullCredentials_ShouldReturnError() {
        // Arrange
        LoginRequest mockLoginRequest = null;

        // Act and Assert
        Assertions.assertThrows(NullPointerException.class, () -> {
            userController.login(mockLoginRequest);
        });
    }










    @Test
    void createUser() {
    }

    @Test
    void getUser() {
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void login() {
    }
}