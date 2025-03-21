package com.solvd;

import com.solvd.enitiy.ProductEnt;
import com.solvd.mapper.ProductMapper;
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
        List<? extends Product> products = productPage.getProducts();
        List<ProductEnt> sortedProducts = ProductMapper.mapAllToProductEnt(products)
                .stream()
                .sorted(Comparator.comparing(ProductEnt::name))
                .toList();
        SelectionPage selectionPage = productPage.clickSelectionButton();
        productPage = selectionPage.sortAtoZButton();
        productPage.backToFirstProduct();
        products = productPage.getProducts();
        List<ProductEnt> afterSortList = ProductMapper.mapAllToProductEnt(products);
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

}
