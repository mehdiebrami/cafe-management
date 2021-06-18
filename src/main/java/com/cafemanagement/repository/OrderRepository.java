package com.cafemanagement.repository;

import com.cafemanagement.model.Order;
import com.cafemanagement.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select o.* from orders o inner join tables t on o.table_id = t.id where t.user_id = :userId", nativeQuery = true)
    List<Order> findByUserId(@Param("userId") long userId);

    List<Order> findByTableIdAndOrderStatus(long id, OrderStatus orderStatus);

}
