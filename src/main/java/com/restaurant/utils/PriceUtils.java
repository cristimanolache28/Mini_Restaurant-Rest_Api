package com.restaurant.utils;

import com.restaurant.entity.Product;
import com.restaurant.exception.ProductException;

import java.util.List;

import static com.restaurant.constants.Constants.Error.INVALID_DISCOUNT;

public class PriceUtils {

    public static Double applyDiscount(Double price, Integer discount) {
       if (discount > 45 || discount < 1) {
           throw new ProductException(INVALID_DISCOUNT);
       }
       return price - (discount * price) / 100;
    }

    public static Double getTotalPrice(List<Product> products) {
        return products.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);
    }
}
