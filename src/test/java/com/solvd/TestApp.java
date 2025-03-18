package com.solvd;

import com.solvd.pages.common.LoginPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestApp extends AbstractTest {

    @Test
    public void shouldNotLogin() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        loginPage.login("standard", "wrong");
        assertTrue(loginPage.isErrorVisible());
    }
}
