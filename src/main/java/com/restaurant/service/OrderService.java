package com.restaurant.service;

import com.restaurant.entity.Order;
import com.restaurant.entity.Product;

import java.util.List;

public interface OrderService {

    Order registerOrder(List<Product> products, String waiterBadgeCode);
}
