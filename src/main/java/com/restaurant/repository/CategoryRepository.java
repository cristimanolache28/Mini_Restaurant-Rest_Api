package com.restaurant.repository;

import com.restaurant.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    boolean existsCategoryByName(String name);
}
