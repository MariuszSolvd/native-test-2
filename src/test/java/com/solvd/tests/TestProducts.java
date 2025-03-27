package com.solvd.tests;

import com.solvd.enitiy.ProductWithImage;
import com.solvd.mapper.ProductMapper;
import com.solvd.pages.common.MenuPage;
import com.solvd.pages.common.ProductDetailPage;
import com.solvd.pages.common.ProductPage;
import com.solvd.pages.common.SelectionPage;
import com.solvd.pages.common.elements.ExtendedProduct;
import com.solvd.service.LoginService;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestProducts extends AbstractTest {

    @Test
    public void sortProductsAtoZ() {
        ProductPage productPage = LoginService.login();
        List<ProductWithImage> sortedProducts = ProductMapper.mapAllToProductEnt(productPage.getProducts())
                .stream()
                .sorted(Comparator.comparing(ProductWithImage::name))
                .toList();
        SelectionPage selectionPage = productPage.clickSelectionButton();
        productPage = selectionPage.sortAtoZButton();
        productPage.backToFirstProduct();
        List<ProductWithImage> afterSortList = ProductMapper.mapAllToProductEnt(productPage.getProducts());
        assertEquals(sortedProducts, afterSortList);
    }

    @Test
    public void sortProductsZtoA() {
        ProductPage productPage = LoginService.login();
        List<ProductWithImage> sortedProducts = ProductMapper.mapAllToProductEnt(productPage.getProducts())
                .stream().sorted(Comparator.comparing(ProductWithImage::name).reversed())
                .toList();
        SelectionPage selectionPage = productPage.clickSelectionButton();
        productPage = selectionPage.sortZtoAButton();
        productPage.backToFirstProduct();
        List<ProductWithImage> afterSortList = ProductMapper.mapAllToProductEnt(productPage.getProducts());
        assertEquals(sortedProducts, afterSortList);
    }

    @Test
    public void sortPriceLowToHigh() {
        ProductPage productPage = LoginService.login();
        List<ProductWithImage> sortedProducts = ProductMapper.mapAllToProductEnt(productPage.getProducts())
                .stream().sorted(Comparator.comparing(ProductWithImage::price))
                .toList();
        SelectionPage selectionPage = productPage.clickSelectionButton();
        productPage = selectionPage.sortPriceLowToHigh();
        productPage.backToFirstProduct();
        List<ProductWithImage> afterSortList = ProductMapper.mapAllToProductEnt(productPage.getProducts());
        assertEquals(sortedProducts, afterSortList);
    }

    @Test
    public void sortPriceHighToLow() {
        ProductPage productPage = LoginService.login();
        List<ProductWithImage> sortedProducts = ProductMapper.mapAllToProductEnt(productPage.getProducts())
                .stream().sorted(Comparator.comparing(ProductWithImage::price).reversed()
                        .thenComparing(ProductWithImage::name, Comparator.reverseOrder()))
                .toList();
        SelectionPage selectionPage = productPage.clickSelectionButton();
        productPage = selectionPage.sortPriceHighToLow();
        productPage.backToFirstProduct();
        List<ProductWithImage> afterSortList = ProductMapper.mapAllToProductEnt(productPage.getProducts());
        assertEquals(sortedProducts, afterSortList);
    }

    @Test
    public void checkProductsDetailsCompliance() {
        ProductPage productPage = LoginService.login();
        List<? extends ExtendedProduct> products = productPage.getProducts();
        for (ExtendedProduct extendedProduct : products) {
            ProductWithImage productWithImage = ProductMapper.mapToProductEnt(extendedProduct);
            ProductDetailPage productDetailPage = extendedProduct.clickOnProduct();
            ProductWithImage productDetail = ProductMapper.mapToProductEnt(productDetailPage);
            assertEquals(productWithImage, productDetail);
            productDetailPage.clickOnBackToProduct();
        }
    }

    @Test
    public void checkAddToCartAgainstCarButton() {
        ProductPage productPage = LoginService.login();
        List<? extends ExtendedProduct> products = productPage.getProducts();
        for (ExtendedProduct extendedProduct : products) {
            extendedProduct.clickAddToCart();
            assertEquals(productPage.getHeader().getCartProductNumber(), 1);
            extendedProduct.clickRemoveFromCart();
        }
    }

    @Test
    public void checkAddToCartAgainstCarButtonIteration(){
        ProductPage productPage = LoginService.login();
        List<? extends ExtendedProduct> products = productPage.getProducts();
        for (int i = 0; i < products.size(); i++) {
            products.get(i).clickAddToCart();
            assertEquals(productPage.getHeader().getCartProductNumber(), i + 1);
        }
    }

    @Test
    public void checkAddCartForDetailProductPage() {
        ProductPage productPage = LoginService.login();
        List<? extends ExtendedProduct> products = productPage.getProducts();
        for (ExtendedProduct extendedProduct : products) {
            extendedProduct.clickAddToCart();
            ProductDetailPage productDetailPage = extendedProduct.clickOnProduct();
            assertTrue(productDetailPage.getRemoveFromCartButton().isDisplayed());
            productDetailPage.backToProductPage();
        }
    }

    @Test
    public void shouldRestartPickedProducts() {
        ProductPage productPage = LoginService.login();
        List<? extends ExtendedProduct> products = productPage.getProducts();
        for (ExtendedProduct extendedProduct : products) {
            extendedProduct.clickAddToCart();
        }
        MenuPage menuPage = productPage.getHeader().clickHamburgerMenu();
        productPage = menuPage.clickResetApp();
        assertEquals(productPage.getHeader().getCartProductNumber(), 0);
    }

}
