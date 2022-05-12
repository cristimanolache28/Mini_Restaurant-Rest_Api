package com.restaurant.mocks;

import com.restaurant.entity.Employee;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeMock {

    public static Employee getMockEmployee(String badgeCode) {
        return Employee.builder()
                .badgeCode(badgeCode)
                .name("Mock Employee")
                .jobTitle("waiter")
                .id(1)
                .build();
    }

}
