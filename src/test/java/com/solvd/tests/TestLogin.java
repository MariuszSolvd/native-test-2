package com.solvd.tests;

import com.solvd.data.TestDataProviders;
import com.solvd.pages.common.LoginPage;
import com.solvd.pages.common.MenuPage;
import com.solvd.pages.common.ProductPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestLogin extends AbstractTest {

    @Test(dataProvider = "wrongLoginData", dataProviderClass = TestDataProviders.class)
    public void shouldNotLoginIncorrectCredentials(String username, String password) {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        loginPage.login(username, password);
        assertEquals(loginPage.getErrorName(), "Username and password do not match any user in this service.");
    }

    @Test(dataProvider = "correctLoginData", dataProviderClass = TestDataProviders.class)
    public void shouldLogin(String username, String password) {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        ProductPage productPage = loginPage.login(username, password);
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

    @Test
    public void shouldNotLoginLockedUser() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        loginPage.login(R.TESTDATA.get("user.locked"), R.TESTDATA.get("user.password"));
        assertEquals(loginPage.getErrorName(), "Sorry, this user has been locked out.");
    }

    @Test
    public void shouldLogout() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        ProductPage productPage = loginPage.login(R.TESTDATA.get("user.standard"), R.TESTDATA.get("user.password"));
        MenuPage menuPage = productPage.getHeader().clickHamburgerMenu();
        loginPage = menuPage.clickLogout();
        assertTrue(loginPage.isPageOpened());
    }
}
