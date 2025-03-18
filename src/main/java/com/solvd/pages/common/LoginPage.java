package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPage login(String username, String password);

    public abstract void clickLoginButton();

    public abstract void inputUsername(String username);

    public abstract void inputPassword(String password);

    public abstract String getErrorName();
}
