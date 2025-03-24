package com.solvd.pages.common.elements;

import com.solvd.pages.common.ProductDetailPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public abstract class Product extends AbstractUIObject implements IMobileUtils {

    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getImage();

    public abstract String getNameText();

    public abstract BigDecimal getPrice();

    public abstract void clickAddToCart();

    public ProductDetailPage clickOnProduct() {
        this.click();
        return initPage(getDriver(), ProductDetailPage.class);
    }

    //Needed to load Product's Name/Price
    protected void swipeToElement(ExtendedWebElement element) {
        if (!element.isDisplayed()) {
            swipe(element);
        }
    }
}
