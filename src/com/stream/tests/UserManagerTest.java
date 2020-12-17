package com.stream.tests;

import com.stream.exceptions.LoginException;
import com.stream.exceptions.SignupException;
import com.stream.models.UserManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class UserManagerTest {

    private UserManager userManager;

    @Before
    public void before() {
        userManager = UserManager.getInstance();
    }

    @After
    public void after() {
        userManager = null;
    }

    @Test
    public void attemptLogin_correctPassword() throws LoginException {
        String name = "Cronval";
        String pass = "1234";

        boolean success = userManager.attemptLogin(name, pass);
        assertEquals(success, true);
    }

    @Test(expected = LoginException.class)
    public void attemptLogin_wrongPassword() throws LoginException {
        String name = "Cronval";
        String pass = "12345";

        userManager.attemptLogin(name, pass);
    }

    @Test
    public void createAccount_samePassword() throws SignupException {
        String name = "Lasse";
        String pass = "1234";
        String passAgain = "1234";

        boolean success = userManager.attemptCreateAccount(name, pass, passAgain, false);
        assertEquals(success, true);
    }

    @Test(expected = SignupException.class)
    public void createAccount_wrongPassword() throws SignupException {
        String name = "Lasse";
        String pass = "1234";
        String passAgain = "12345";

        userManager.attemptCreateAccount(name, pass, passAgain, false);
    }

    @Test(expected = SignupException.class)
    public void createAccount_doubleSignup() throws SignupException {
        String name = "Lasse";
        String pass = "1234";
        String passAgain = "1234";

        userManager.attemptCreateAccount(name, pass, passAgain, false);
        userManager.attemptCreateAccount(name, pass, passAgain, false);
    }
}
