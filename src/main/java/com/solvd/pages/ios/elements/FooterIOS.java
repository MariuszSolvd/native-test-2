package com.solvd.pages.ios.elements;

import com.solvd.pages.common.elements.Footer;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


public class FooterIOS extends Footer {

    @ExtendedFindBy(iosPredicate = "name == \"\uF099\"")
    private ExtendedWebElement twitterButton;
    @ExtendedFindBy(iosPredicate = "name == \"\uF09A\"")
    private ExtendedWebElement fbButton;
    @ExtendedFindBy(iosPredicate = "name == \"\uF0D5\"")
    private ExtendedWebElement googleButton;
    @ExtendedFindBy(iosPredicate = "name == \"\uF0E1\"")
    private ExtendedWebElement linkedinButton;

    public FooterIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void clickTwitterButton() {
        twitterButton.click();
    }

    @Override
    public void clickFBButton() {
        fbButton.click();
    }

    @Override
    public void clickGoogleButton() {
        googleButton.click();
    }

    @Override
    public void clickLinkedinButton() {
        linkedinButton.click();
    }
}
