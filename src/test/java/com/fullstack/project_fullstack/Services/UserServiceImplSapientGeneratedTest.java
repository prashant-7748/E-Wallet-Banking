package com.fullstack.project_fullstack.Services;

import com.fullstack.project_fullstack.exception.InvalidCredentialsException;
import com.fullstack.project_fullstack.model.SecurityConfig;
import com.fullstack.project_fullstack.model.User;
import com.fullstack.project_fullstack.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class UserServiceImplSapientGeneratedTest {

    @Mock(name = "userRepository")
    private UserRepository userRepositoryMock;

    private AutoCloseable autoCloseableMocks;

    @BeforeEach()
    public void beforeTest() {
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
    }

    //Sapient generated method id: ${c21d3ed3-7747-39fb-bfef-184c2bc23343}
    @Test()
    void createUserTest() {
        SecurityConfig securityConfigMock = mock(SecurityConfig.class);
        UserServiceImpl target = new UserServiceImpl(userRepositoryMock, securityConfigMock);
        User userMock = mock(User.class);
        User userMock2 = mock(User.class);
        doReturn(userMock).when(userRepositoryMock).save(userMock2);
        User result = target.createUser(userMock2);
        assertAll("result", () -> {
            assertThat(result, equalTo(userMock));
            verify(userRepositoryMock).save(userMock2);
        });
    }

    //Sapient generated method id: ${44f00673-e6a8-39d4-849c-3bc2696304ce}
    @Test()
    void getUserTest() {
        SecurityConfig securityConfigMock = mock(SecurityConfig.class);
        UserServiceImpl target = new UserServiceImpl(userRepositoryMock, securityConfigMock);
        doReturn(Optional.empty()).when(userRepositoryMock).findById("id1");
        User result = target.getUser("id1");
        assertAll("result", () -> {
            assertThat(result, is(nullValue()));
            verify(userRepositoryMock).findById("id1");
        });
    }

    //Sapient generated method id: ${480339a7-d9be-39c4-82a5-aa02ed83fa46}
    @Test()
    void getAllUsersTest() {
        SecurityConfig securityConfigMock = mock(SecurityConfig.class);
        UserServiceImpl target = new UserServiceImpl(userRepositoryMock, securityConfigMock);
        List list = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        doReturn(list, userList).when(userRepositoryMock).findAll();
        List<User> result = target.getAllUsers();
        assertAll("result", () -> {
            assertThat(result, equalTo(userList));
            verify(userRepositoryMock, times(2)).findAll();
        });
    }

    //Sapient generated method id: ${086b307f-2e9e-36f6-aa99-ae2022b0b148}
    @Test()
    void loginWhenUserIsNullThrowsInvalidCredentialsException() {
        /* Branches:
         * (user != null) : false
         */
        SecurityConfig securityConfigMock = mock(SecurityConfig.class);
        UserServiceImpl target = new UserServiceImpl(userRepositoryMock, securityConfigMock);
        doReturn(null).when(userRepositoryMock).findByEmail("email1");
        InvalidCredentialsException invalidCredentialsException = new InvalidCredentialsException("Invalid credentials");
        final InvalidCredentialsException result = assertThrows(InvalidCredentialsException.class, () -> {
            target.login("email1", "password1");
        });
        assertAll("result", () -> {
            assertThat(result, is(notNullValue()));
            assertThat(result.getMessage(), equalTo(invalidCredentialsException.getMessage()));
            verify(userRepositoryMock).findByEmail("email1");
        });
    }

    //Sapient generated method id: ${b21effec-781a-3a35-9e18-55f943a711c3}
//    @Test()
//    void loginWhenPasswordUtilsVerifyPasswordPasswordUserGetPassword() {
//        /* Branches:
//         * (user != null) : true
//         * (PasswordUtils.verifyPassword(password, user.getPassword())) : true
//         *
//         * TODO: Please, check test parameters
//         */
//        SecurityConfig securityConfigMock = mock(SecurityConfig.class);
//        UserServiceImpl target = new UserServiceImpl(userRepositoryMock, securityConfigMock);
//        User userMock = mock(User.class);
//        doReturn(userMock).when(userRepositoryMock).findByEmail("email1");
//        doReturn("return_of_getPassword1").when(userMock).getPassword();
//        User result = target.login("email1", "password1");
//        assertAll("result", () -> {
//            assertThat(result, equalTo(userMock));
//            verify(userRepositoryMock).findByEmail("email1");
//            verify(userMock).getPassword();
//        });
//    }

    //Sapient generated method id: ${6c4d48a3-1cbc-3829-bc91-9a8320ec2322}
    @Test()
    void loginWhenPasswordUtilsNotVerifyPasswordPasswordUserGetPasswordThrowsInvalidCredentialsException() {
        /* Branches:
         * (user != null) : true
         * (PasswordUtils.verifyPassword(password, user.getPassword())) : false
         */
        SecurityConfig securityConfigMock = mock(SecurityConfig.class);
        UserServiceImpl target = new UserServiceImpl(userRepositoryMock, securityConfigMock);
        User userMock = mock(User.class);
        doReturn(userMock).when(userRepositoryMock).findByEmail("email1");
        doReturn("B").when(userMock).getPassword();
        InvalidCredentialsException invalidCredentialsException = new InvalidCredentialsException("Invalid credentials");
        final InvalidCredentialsException result = assertThrows(InvalidCredentialsException.class, () -> {
            target.login("email1", "A");
        });
        assertAll("result", () -> {
            assertThat(result, is(notNullValue()));
            assertThat(result.getMessage(), equalTo(invalidCredentialsException.getMessage()));
            verify(userRepositoryMock).findByEmail("email1");
            verify(userMock).getPassword();
        });
    }

    @AfterEach()
    public void afterTest() throws Exception {
        autoCloseableMocks.close();
    }
}
