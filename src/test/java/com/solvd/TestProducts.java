package com.solvd;

import com.solvd.enitiy.ProductEnt;
import com.solvd.mapper.ProductMapper;
import com.solvd.pages.common.ProductPage;
import com.solvd.pages.common.elements.Product;
import com.solvd.service.LoginService;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;


public class TestProducts extends AbstractTest {

    @Test
    public void sortLowestPrice() {
        ProductPage productPage = LoginService.login();
        //TODO: Lazy loading of products needed!!
        List<ProductEnt> presortProducts = ProductMapper.mapAllToProductEnt(productPage.getProducts());
        presortProducts.forEach(System.out::println);
    }

}
