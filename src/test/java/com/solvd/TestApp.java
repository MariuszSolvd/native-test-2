package com.solvd;

import com.solvd.pages.common.LoginPage;
import com.solvd.pages.common.ProductPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestApp extends AbstractTest {

    @Test
    public void shouldNotLogin() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        loginPage.login("standard", "wrong");
        assertTrue(loginPage.isErrorVisible());
    }

    @Test
    public void shouldLogin() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        ProductPage productPage = loginPage.login(R.TESTDATA.get("user.standard"), R.TESTDATA.get("user.password"));
        assertTrue(productPage.isPageOpened());
    }
}
