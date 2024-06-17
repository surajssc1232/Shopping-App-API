package org.assigenment.shoppingappbackend.Model;

import java.util.List;
import java.util.stream.Collectors;

public class OrderResponseMapper {

    public static OrderResponse mapToOrderResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(order.getOrderId());
        orderResponse.setAmount(order.getAmount());
        orderResponse.setDate(order.getDate());
        orderResponse.setCoupon(order.getCoupon());
        return orderResponse;
    }

    public static List<OrderResponse> mapToOrderResponseList(List<Order> orders) {
        return orders.stream()
                .map(OrderResponseMapper::mapToOrderResponse)
                .collect(Collectors.toList());
    }
    public static OrderResponse mapToOrderResponses(Order order) {
        PaymentResponse paymentResponse = new PaymentResponse();
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(order.getOrderId());
        orderResponse.setAmount(order.getAmount());
        orderResponse.setDate(order.getDate());
        orderResponse.setCoupon(order.getCoupon());
        orderResponse.setTransactionId(paymentResponse.getTransactionId());
        orderResponse.setStatus(order.getStatus());
        return orderResponse;
}
}
