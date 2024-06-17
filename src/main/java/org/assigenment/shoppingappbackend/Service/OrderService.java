package org.assigenment.shoppingappbackend.Service;

import org.assigenment.shoppingappbackend.Model.*;
import org.assigenment.shoppingappbackend.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrderService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CouponRepository couponRepo;
    @Autowired
    InventryRepo inventryRepo;
    @Autowired
    private OrderRepository OrderRepo;


    public  OrderResponse createOrder(Long userId, Long productId, int quantity, String couponCode) {
        Userss user = userRepo.findById(userId).orElse(null);

        if (user == null) {
            // Handle user not found error
            // Return appropriate error response
        }

        // Retrieve product
        product product = productRepo.findById(productId).orElse(null);
        if (product == null) {
            // Handle product not found error
            // Return appropriate error response
        }
        if (quantity < 1 || quantity > product.getAvailableQuantity()) {
            // Handle invalid quantity error
            // Return appropriate error response
        }

        // Calculate amount
        double price = product.getPrice();
        double discountPercentage = 0;
        if (couponCode != null && !couponCode.isEmpty()) {
            Coupon coupon = couponRepo.findByCode(couponCode);
            if (coupon != null) {
                discountPercentage = coupon.getDiscountPercentage();
            } else {
                // Handle invalid coupon error
                // Return appropriate error response
            }
        }
        double discountedPrice = price * (1 - discountPercentage / 100);
        double amount = quantity * discountedPrice;

        // Create order
        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setQuantity(quantity);
        order.setAmount(amount);
        order.setDate(new Date());
        order.setCoupon(couponCode);
        // Set other properties like date and status
        int updatedAvailable = product.getAvailableQuantity() - quantity;
        product.setAvailableQuantity(updatedAvailable);
        productRepo.save(product);


        order = OrderRepo.save(order);
        Inventory inventory = new Inventory();
        inventory.setOrdered(quantity);
        inventory.setPrice(amount);
        inventory.setAvailable(product.getAvailableQuantity());
        inventryRepo.save(inventory);

        // Prepare response
        OrderResponse response = new OrderResponse();
        response.setOrderId(order.getOrderId());
        response.setUserId(userId);
        response.setQuantity(quantity);
        response.setAmount(amount);
        response.setCoupon(couponCode);

        return response;
    }
    @Autowired
    private OrderRepository orderRepository;
    public List<OrderResponse> getUserOrders(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return OrderResponseMapper.mapToOrderResponseList(orders);
    }

    public OrderResponse getOrderById(Long userId, Long orderId) {
        Order order = orderRepository.findByUserIdAndOrderId(userId, orderId);
        if (order == null) {
            // Handle order not found error
            // Return appropriate error response
        }

        return OrderResponseMapper.mapToOrderResponses(order);
    }
}
