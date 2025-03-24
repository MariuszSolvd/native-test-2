package com.solvd.pages.ios.elements;

import com.solvd.pages.common.elements.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class ProductIOS extends Product {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeImage")
    private ExtendedWebElement image;
    @ExtendedFindBy(iosPredicate = "name == \"test-Item title\"")
    private ExtendedWebElement nameElement;
    @ExtendedFindBy(iosPredicate = "name == \"test-Price\"")
    private ExtendedWebElement priceElement;
    @ExtendedFindBy(iosPredicate = "name == \"test-ADD TO CART\"")
    private ExtendedWebElement addToCart;
    @ExtendedFindBy(iosPredicate = "name == \"REMOVE\"")
    private ExtendedWebElement removeFromCart;


    public ProductIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getImage() {
        swipeToElement(image);
        return image.getAttribute("name");
    }

    @Override
    public String getNameText() {
        swipeToElement(nameElement);
        return nameElement.getText();
    }

    @Override
    public BigDecimal getPrice() {
        swipeToElement(priceElement);
        return new BigDecimal(priceElement.getText().replace("$", ""));
    }

    @Override
    public void clickAddToCart() {
        swipeToElement(addToCart);
        addToCart.click();
    }

    @Override
    public void clickRemoveFromCart() {
        swipeToElement(removeFromCart);
        removeFromCart.click();

    }
}
