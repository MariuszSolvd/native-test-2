package com.solvd;

import com.solvd.enitiy.ProductEnt;
import com.solvd.mapper.ProductMapper;
import com.solvd.pages.common.ProductDetailPage;
import com.solvd.pages.common.ProductPage;
import com.solvd.pages.common.SelectionPage;
import com.solvd.pages.common.elements.Product;
import com.solvd.service.LoginService;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestProducts extends AbstractTest {

    @Test
    public void sortProductsAtoZ() {
        ProductPage productPage = LoginService.login();
        List<ProductEnt> sortedProducts = ProductMapper.mapAllToProductEnt(productPage.getProducts())
                .stream()
                .sorted(Comparator.comparing(ProductEnt::name))
                .toList();
        SelectionPage selectionPage = productPage.clickSelectionButton();
        productPage = selectionPage.sortAtoZButton();
        productPage.backToFirstProduct();
        List<ProductEnt> afterSortList = ProductMapper.mapAllToProductEnt(productPage.getProducts());
        assertEquals(sortedProducts, afterSortList);
    }

    @Test
    public void sortProductsZtoA() {
        ProductPage productPage = LoginService.login();
        List<ProductEnt> sortedProducts = ProductMapper.mapAllToProductEnt(productPage.getProducts())
                .stream().sorted(Comparator.comparing(ProductEnt::name).reversed())
                .toList();
        SelectionPage selectionPage = productPage.clickSelectionButton();
        productPage = selectionPage.sortZtoAButton();
        productPage.backToFirstProduct();
        List<ProductEnt> afterSortList = ProductMapper.mapAllToProductEnt(productPage.getProducts());
        assertEquals(sortedProducts, afterSortList);
    }

    @Test
    public void sortPriceLowToHigh() {
        ProductPage productPage = LoginService.login();
        List<ProductEnt> sortedProducts = ProductMapper.mapAllToProductEnt(productPage.getProducts())
                .stream().sorted(Comparator.comparing(ProductEnt::price))
                .toList();
        SelectionPage selectionPage = productPage.clickSelectionButton();
        productPage = selectionPage.sortPriceLowToHigh();
        productPage.backToFirstProduct();
        List<ProductEnt> afterSortList = ProductMapper.mapAllToProductEnt(productPage.getProducts());
        assertEquals(sortedProducts, afterSortList);
    }

    @Test
    public void sortPriceHighToLow() {
        ProductPage productPage = LoginService.login();
        List<ProductEnt> sortedProducts = ProductMapper.mapAllToProductEnt(productPage.getProducts())
                .stream().sorted(Comparator.comparing(ProductEnt::price).reversed()
                        .thenComparing(ProductEnt::name, Comparator.reverseOrder()))
                .toList();
        SelectionPage selectionPage = productPage.clickSelectionButton();
        productPage = selectionPage.sortPriceHighToLow();
        productPage.backToFirstProduct();
        List<ProductEnt> afterSortList = ProductMapper.mapAllToProductEnt(productPage.getProducts());
        assertEquals(sortedProducts, afterSortList);
    }

    @Test
    public void checkProductsDetailsCompliance() {
        ProductPage productPage = LoginService.login();
        List<? extends Product> products = productPage.getProducts();
        for (Product product : products) {
            ProductEnt productEnt = ProductMapper.mapToProductEnt(product);
            ProductDetailPage productDetailPage = product.clickOnProduct();
            ProductEnt productDetail = ProductMapper.mapToProductEnt(productDetailPage);
            assertEquals(productEnt, productDetail);
            productDetailPage.clickOnBackToProduct();
        }
    }

    @Test
    public void checkAddToCartAgainstCarButton() {
        ProductPage productPage = LoginService.login();
        List<? extends Product> products = productPage.getProducts();
        for (Product product : products) {
            product.clickAddToCart();
            assertEquals(productPage.getCartProductNumber(), 1);
            product.clickRemoveFromCart();
        }
    }





}
