package com.restaurant.service.impl;

import com.restaurant.entity.Employee;
import com.restaurant.entity.Order;
import com.restaurant.entity.Product;
import com.restaurant.exception.ProductException;
import com.restaurant.repository.EmployeeRepository;
import com.restaurant.repository.OrderRepository;
import com.restaurant.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.restaurant.constants.Constants.Error.INVALID_BADGE_CODE;
import static com.restaurant.constants.Constants.Error.INVALID_ORDER;
import static com.restaurant.utils.PriceUtils.getTotalPrice;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public Order registerOrder(List<Product> products, String waiterBadgeCode) {
        if (products.isEmpty()) {
            throw new ProductException(INVALID_ORDER);
        }
        return orderRepository.save(createOrder(products, waiterBadgeCode));
    }

    private Order createOrder(List<Product> products, String waiterBadgeCode) {
        return Order.builder()
                .products(products)
                .orderDate(LocalDateTime.now())
                .total(getTotalPrice(products))
                .discount(0)
                .employee(getEmployee(waiterBadgeCode))
                .build();
    }

    private Employee getEmployee(String badgeCode) {
        return employeeRepository.getByBadgeCode(badgeCode)
                .orElseThrow(() -> new ProductException(INVALID_BADGE_CODE, badgeCode));
    }


}
