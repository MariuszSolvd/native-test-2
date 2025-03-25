package com.solvd.pages.ios.elements;

import com.solvd.pages.common.elements.Product;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = Product.class)
public class ProductIOS extends Product {

    public ProductIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getNameText() {
        return "";
    }

    @Override
    public BigDecimal getPrice() {
        return null;
    }

    @Override
    public void clickRemoveFromCart() {

    }


}
