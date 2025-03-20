package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SelectionPage extends AbstractPage {


    public SelectionPage(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPage sortAtoZButton();

    public abstract ProductPage sortZtoAButton();

    public abstract ProductPage sortPriceLowToHigh();

    public abstract ProductPage sortPriceHighToLow();

    public abstract ProductPage clickCancelButton();



}
