package com.solvd.pages.common.elements;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class Footer extends AbstractUIObject {


    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void clickTwitterButton();

    public abstract void clickFBButton();

    public abstract void clickGoogleButton();

    public abstract void clickLinkedinButton();
}
