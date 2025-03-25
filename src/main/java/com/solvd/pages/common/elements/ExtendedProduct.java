package com.solvd.pages.common.elements;

import com.solvd.pages.common.ProductDetailPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ExtendedProduct extends Product implements IMobileUtils {

    public ExtendedProduct(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getImage();

    public abstract void clickAddToCart();

    public ProductDetailPage clickOnProduct() {
        this.click();
        return initPage(getDriver(), ProductDetailPage.class);
    }
}
