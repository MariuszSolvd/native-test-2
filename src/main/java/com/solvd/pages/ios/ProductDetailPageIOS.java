package com.solvd.pages.ios;

import com.solvd.pages.common.ProductDetailPage;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class ProductDetailPageIOS extends ProductDetailPage {


    public ProductDetailPageIOS(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public BigDecimal getPrice() {
        return null;
    }

    @Override
    public void clickAddToCartButton() {

    }
}
