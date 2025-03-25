package com.solvd.pages.common;

import com.solvd.pages.common.elements.ExtendedProduct;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductPage extends CommonPage implements IMobileUtils {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public abstract List<? extends ExtendedProduct> getProducts();

    public abstract SelectionPage clickSelectionButton();

    public void backToFirstProduct() {
        swipe(getProducts().getFirst(), Direction.DOWN);
    }
}
