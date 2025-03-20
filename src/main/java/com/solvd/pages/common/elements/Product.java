package com.solvd.pages.common.elements;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public abstract class Product extends AbstractUIObject implements IMobileUtils {

    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getNameText();

    public abstract BigDecimal getPrice();

    public abstract void clickAddToCart();

    public void swipeToProduct() {
        if (!this.isDisplayed()) {
            swipe(this);
        }
    }
}
