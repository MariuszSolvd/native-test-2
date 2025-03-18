package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public abstract void login(String username, String password);

    public abstract boolean isErrorVisible();
}
