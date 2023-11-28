package com.fullstack.project_fullstack.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

class PasswordUtilsSapientGeneratedTest {

    //Sapient generated method id: ${0a297015-78d0-357e-92bb-d36138ee030e}
    @Test()
    void hashPasswordTest() {
        String result = PasswordUtils.hashPassword("A");
        assertAll("result", () -> assertThat(result, equalTo(".2a.10.qCVPX2/hPXudz0xdMz.UeOcZEfFnb4bOGd5IQXrli4GLDhb4/7wWy")));
    }

    //Sapient generated method id: ${08de9ce1-dede-3755-898e-b3c20c322fe8}
    @Test()
    void verifyPasswordWhenPasswordEncoderMatchesPasswordHashedPassword() {
        /* Branches:
         * (passwordEncoder.matches(password, hashedPassword)) : true
         *
         * TODO: Please, check test parameters
         */
        boolean result = PasswordUtils.verifyPassword("password1", "hashedPassword1");
        assertAll("result", () -> assertThat(result, equalTo(Boolean.TRUE)));
    }

    //Sapient generated method id: ${c0443c00-2d80-3bf5-a0c5-c862bdffadcb}
    @Test()
    void verifyPasswordWhenPasswordEncoderNotMatchesPasswordHashedPassword() {
        /* Branches:
         * (passwordEncoder.matches(password, hashedPassword)) : false
         */
        boolean result = PasswordUtils.verifyPassword("A", "B");
        assertAll("result", () -> assertThat(result, equalTo(Boolean.FALSE)));
    }
}
