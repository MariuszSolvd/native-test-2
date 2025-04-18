package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public abstract class ProductDetailPage extends AbstractPage {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public abstract String getImage();

    public abstract String getName();

    public abstract BigDecimal getPrice();

    public abstract void clickAddToCartButton();

    public abstract void clickRemoveFromCartButton();

    public abstract ExtendedWebElement getRemoveFromCartButton();

    public abstract void clickOnBackToProduct();

    public ProductPage backToProductPage() {
        clickOnBackToProduct();
        return initPage(getDriver(), ProductPage.class);
    }
}
