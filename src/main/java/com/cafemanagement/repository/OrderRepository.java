package com.cafemanagement.repository;

import com.cafemanagement.model.Order;
import com.cafemanagement.model.OrderStatus;
import com.cafemanagement.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByOrderStatusAndTableId(OrderStatus orderStatus, long id);

//    @Query(value = "select o from order as o  where  o.table.waiter_id = :waiterId")
//    List <Order> findByTableUserId(@Param("waiterId") long waiterId);


    List<Order> findAllByTable_UserId(long userId);
}
