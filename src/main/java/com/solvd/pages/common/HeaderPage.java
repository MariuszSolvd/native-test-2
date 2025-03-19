package com.solvd.pages.common;

import com.solvd.pages.common.elements.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HeaderPage extends AbstractPage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public abstract Header getHeader();
}
