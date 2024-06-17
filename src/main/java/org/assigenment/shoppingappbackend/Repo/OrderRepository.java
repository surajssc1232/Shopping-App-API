package org.assigenment.shoppingappbackend.Repo;

import org.assigenment.shoppingappbackend.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);

    Order findByUserIdAndOrderId(Long userId, Long orderId);
    // You can add custom query methods if needed
}