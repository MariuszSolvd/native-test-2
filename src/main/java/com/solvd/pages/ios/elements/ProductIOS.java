package com.solvd.pages.ios.elements;

import com.solvd.pages.common.elements.Product;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = Product.class)
public class ProductIOS extends Product {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Description\"`]/*[1]")
    ExtendedWebElement name;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Price\"`]/XCUIElementTypeStaticText")
    ExtendedWebElement price;
    @ExtendedFindBy(iosPredicate = "name == \"test-REMOVE\"")
    ExtendedWebElement removeButton;

    public ProductIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getNameText() {
        swipeToElement(name);
        return name.getText();
    }

    @Override
    public BigDecimal getPrice() {
        swipeToElement(price);
        return new BigDecimal(price.getText().replace("$", ""));
    }

    @Override
    public void clickRemoveFromCart() {
        swipeToElement(removeButton);
        removeButton.click();
    }


}
