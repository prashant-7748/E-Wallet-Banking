//package com.fullstack.project_fullstack.Services;
//
//import com.fullstack.project_fullstack.model.User;
//import static org.mockito.Mockito.when;
//import com.fullstack.project_fullstack.repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Cond.when;
//import static org.mockito.Mockito.*;
//
//class UserServiceImplTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @InjectMocks
//    private UserServiceImpl userService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//
//@Test
//void createUser_ShouldSaveUserAndReturnSavedUser() {
//    User user = new User();
//    when(userRepository.save(user)).thenReturn(user);
//
//    User savedUser = userService.createUser(user);
//
//    Assertions.assertEquals(user, savedUser);
//
//}
//
//
//    @Test
//    void getUser_WithValidId_ShouldReturnUser() {
//
//        User user = new User();
//        String id = "123";
//        when(userRepository.findById(id)).thenReturn(Optional.of(user));
//
//
//        User retrievedUser = userService.getUser(id);
//
//
//        Assertions.assertEquals(user, retrievedUser);
//        verify(userRepository, times(1)).findById(id);
//    }
//
//
//    @Test
//    void getUser_WithInvalidId_ShouldReturnNull() {
//        String id = "123";
//        when(userRepository.findById(id)).thenReturn(Optional.empty());
//
//        User retrievedUser = userService.getUser(id);
//
//        Assertions.assertNull(retrievedUser);
//        verify(userRepository, times(1)).findById(id);
//    }
//
//    @Test
//    void createUser() {
//    }
//
//    @Test
//    void getUser() {
//    }
//
//    @Test
//    void getAllUsers() {
//    }
//
//    @Test
//    void login() {
//    }
//}