package com.solvd.pages.common.elements;

import com.solvd.pages.common.MenuPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class Header extends AbstractUIObject implements IMobileUtils {


    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract MenuPage clickHamburgerMenu();

    public abstract void clickCart();
}
