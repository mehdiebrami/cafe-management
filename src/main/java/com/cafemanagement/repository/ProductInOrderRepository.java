package com.cafemanagement.repository;

import com.cafemanagement.model.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductInOrderRepository extends JpaRepository <ProductInOrder,Long>{

    Optional<ProductInOrder> findById(long id);
}
