package com.solvd.mapper;

import com.solvd.enitiy.ProductWithImage;
import com.solvd.pages.common.ProductDetailPage;
import com.solvd.pages.common.elements.ExtendedProduct;

import java.util.List;

public final class ProductMapper {

    public static List<ProductWithImage> mapAllToProductEnt(List<? extends ExtendedProduct> products) {
        return products.stream()
                .map(ProductMapper::mapToProductEnt)
                .toList();
    }

    public static ProductWithImage mapToProductEnt (ExtendedProduct extendedProduct) {
        return new ProductWithImage(extendedProduct.getImage(), extendedProduct.getNameText(), extendedProduct.getPrice());
    }

    public static ProductWithImage mapToProductEnt(ProductDetailPage productDetailPage) {
        return new ProductWithImage(productDetailPage.getImage(), productDetailPage.getName(), productDetailPage.getPrice());
    }
}
