package com.solvd.pages.ios.elements;

import com.solvd.pages.common.elements.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class ProductIOS extends Product {

    @ExtendedFindBy(iosPredicate = "name == \"test-Item title\"")
    private ExtendedWebElement nameElement;
    @ExtendedFindBy(iosPredicate = "name == \"test-Price\"")
    private ExtendedWebElement priceElement;
    @ExtendedFindBy(iosPredicate = "name == \"test-ADD TO CART\"")
    private ExtendedWebElement addToCart;


    public ProductIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getNameText() {
        return nameElement.getText();
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(priceElement.getText().replace("$", ""));
    }

    @Override
    public void clickAddToCart() {
        addToCart.click();
    }
}
