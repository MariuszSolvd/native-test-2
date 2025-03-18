package com.solvd;

import com.solvd.pages.common.LoginPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

public class TestApp extends AbstractTest {

    @Test
    public void testing() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        loginPage.login("standard", "wrong");
    }
}
