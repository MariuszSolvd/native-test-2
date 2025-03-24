package com.solvd.pages.ios;

import com.solvd.pages.common.ProductDetailPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductDetailPage.class)
public class ProductDetailPageIOS extends ProductDetailPage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Image Container\"`]/**/XCUIElementTypeImage")
    ExtendedWebElement image;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Description\"`]/*[1]")
    ExtendedWebElement name;
    @ExtendedFindBy(iosPredicate = "name == \"test-Price\"")
    ExtendedWebElement price;
    @ExtendedFindBy(iosPredicate = "name == \"test-ADD TO CART\"")
    ExtendedWebElement addToCartButton;
    @ExtendedFindBy(iosPredicate = "name == \"test-BACK TO PRODUCTS\"")
    ExtendedWebElement backToProductButton;


    public ProductDetailPageIOS(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getImage() {
        return image.getAttribute("name");
    }

    @Override
    public String getName() {
        return name.getText();
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(price.getText().replace("$", ""));
    }

    @Override
    public void clickAddToCartButton() {
        addToCartButton.click();

    }

    @Override
    public void clickOnBackToProduct() {
        backToProductButton.click();
    }
}
