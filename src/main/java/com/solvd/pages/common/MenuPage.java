package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MenuPage extends AbstractPage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public abstract void clickButton(int buttonNumber);

    public abstract LoginPage clickLogout();

    public abstract ProductPage clickResetApp();
}
