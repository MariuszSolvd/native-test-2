package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

public abstract class CartPage extends  CommonPage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public abstract ExtendedWebElement getShoppingButton();

    public abstract ExtendedWebElement getCheckoutButton();

    public ProductPage backToProductPage() {
        getShoppingButton().click();
        return initPage(getDriver(), ProductPage.class);
    }

    public CheckoutPage goToCheckoutPage() {
        getCheckoutButton();
        return initPage(getDriver(), CheckoutPage.class);
    }
}
