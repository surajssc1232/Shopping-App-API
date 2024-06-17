package org.assigenment.shoppingappbackend.Controller;

import org.assigenment.shoppingappbackend.Model.Inventory;

import org.assigenment.shoppingappbackend.Model.Order;
import org.assigenment.shoppingappbackend.Model.OrderResponse;
import org.assigenment.shoppingappbackend.Model.PaymentResponse;
import org.assigenment.shoppingappbackend.Service.OrderService;
import org.assigenment.shoppingappbackend.Service.PaymentService;
import org.assigenment.shoppingappbackend.Service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RestController()
public class controller {

    @Autowired
    ShoppingService shoppingService;
    @Autowired
    OrderService OrderService;
    @Autowired
    PaymentService paymentService;

    @GetMapping("/inventory")
    List<Inventory> getInventory()
    {
        return shoppingService.getInventory();
    }

    @GetMapping("/fetchCoupons")
    public Map<String, Integer> fetchCoupons() {
        Map<String, Integer> coupons = new HashMap<>();
        coupons.put("OFF5", 5);
        coupons.put("OFF10", 10);
        return coupons;
    }



    @PostMapping("/{userId}/order")
    public OrderResponse createOrder(@PathVariable Long userId,
                                     @RequestParam Long productId,
                                     @RequestParam int quantity,
                                     @RequestParam String coupon) {
        return  OrderService.createOrder(userId, productId, quantity, coupon);
    }

    @PostMapping("/{userId}/{orderId}/pay")
    public ResponseEntity<Object> processPayment(@PathVariable Long userId,
                                                 @PathVariable Long orderId,
                                                 @RequestParam double amount) {
        PaymentResponse paymentResponse = paymentService.processPayment(userId, orderId, amount);
        HttpStatus status = HttpStatus.OK;

        switch (paymentResponse.getStatus()) {
            case "successful":
                return ResponseEntity.ok(paymentResponse);
            case "failed":
                status = HttpStatus.BAD_REQUEST;
                break;
            default:
                break;
        }

        return ResponseEntity.status(status).body(paymentResponse);
    }
    @Autowired
    private OrderService orderService;

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<OrderResponse>> getUserOrders(@PathVariable Long userId) {
        List<OrderResponse> userOrders = orderService.getUserOrders(userId);
        return new ResponseEntity<>(userOrders, HttpStatus.OK);
    }
    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long userId,
                                                      @PathVariable Long orderId) {
        OrderResponse order = orderService.getOrderById(userId, orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }





}
