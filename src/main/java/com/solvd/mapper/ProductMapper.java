package com.solvd.mapper;

import com.solvd.enitiy.ProductEnt;
import com.solvd.pages.common.elements.Product;

import java.util.List;

public final class ProductMapper {

    public static List<ProductEnt> mapAllToProductEnt(List<? extends Product> products) {
        return products.stream()
                .map(ProductMapper::mapToProductEnt)
                .toList();
    }

    public static ProductEnt mapToProductEnt (Product product) {
        return new ProductEnt(product.getNameText(), product.getPrice());
    }
}
