package com.solvd;

import com.solvd.pages.common.CartPage;
import com.solvd.pages.common.ProductPage;
import com.solvd.pages.common.elements.ExtendedProduct;
import com.solvd.pages.common.elements.Product;
import com.solvd.service.LoginService;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestCart extends AbstractTest {

    @Test
    public void test() {
        ProductPage productPage = LoginService.login();
        List<? extends ExtendedProduct> products = productPage.getProducts();
        products.forEach(ExtendedProduct::clickAddToCart);
        CartPage cartPage = productPage.getHeader().clickCart();
        List<? extends Product> productCart = cartPage.getProducts();
        System.out.println(productCart.getFirst().getNameText() + " " + productCart.getFirst().getPrice());
    }
}
