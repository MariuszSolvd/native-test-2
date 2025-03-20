package com.solvd.pages.common;

import com.solvd.pages.common.elements.Product;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductPage extends CommonPage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public abstract List<? extends Product> getProducts();

    //protected abstract void lazyLoad();
}
