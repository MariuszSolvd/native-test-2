package com.solvd;

import com.solvd.pages.common.LoginPage;
import com.solvd.pages.common.ProductPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestLogin extends AbstractTest {

    @Test
    public void shouldNotLoginIncorrectCredentials() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        loginPage.login("standard", "wrong");
        assertEquals(loginPage.getErrorName(), "Username and password do not match any user in this service.");
    }

    @Test
    public void shouldLogin() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        ProductPage productPage = loginPage.login(R.TESTDATA.get("user.standard"), R.TESTDATA.get("user.password"));
        assertTrue(productPage.isPageOpened());
    }

    @Test
    public void shouldNotLoginNoUsername() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        loginPage.inputPassword("password");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getErrorName(), "Username is required");
    }

    @Test
    public void shouldNotLoginNoPassword() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        loginPage.inputUsername("user");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getErrorName(), "Password is required");
    }
}
