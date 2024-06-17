package org.assigenment.shoppingappbackend.Service;

import org.assigenment.shoppingappbackend.Model.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    public PaymentResponse processPayment(Long userId, Long orderId, double amount) {
        // Mocking payment API to randomly return success or failure
        boolean isSuccess = new Random().nextBoolean();
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setUserId(userId);
        paymentResponse.setOrderId(orderId);
        paymentResponse.setAmount(amount);

        if (isSuccess) {
            paymentResponse.setStatus("successful");
            paymentResponse.setTransactionId("tran010100001");
        } else {
            // Randomly select the type of failure
            int errorCode = new Random().nextInt(3); // Generate a random number between 0 and 2

            switch (errorCode) {
                case 0:
                    // Simulate a failed payment with a 400 status code and description "Payment Failed as amount is invalid"
                    paymentResponse.setStatus("failed");
                    paymentResponse.setDescription("Payment Failed as amount is invalid");
                    paymentResponse.setTransactionId("tran010100002");
                    break;
                case 1:
                    // Simulate a failed payment with a 400 status code and description "Payment Failed due to invalid order id"
                    paymentResponse.setStatus("failed");
                    paymentResponse.setDescription("Payment Failed due to invalid order id");
                    paymentResponse.setTransactionId("tran010100004");
                    break;
                case 2:
                    // Simulate a failed payment with a 504 status code and description "No response from payment server"
                    paymentResponse.setStatus("failed");
                    paymentResponse.setDescription("No response from payment server");
                    paymentResponse.setTransactionId("tran010100005");
                    break;
                case 3:
                    // Simulate a failed payment with a 405 status code and description "Order is already paid for"
                    paymentResponse.setStatus("failed");
                    paymentResponse.setDescription("Order is already paid for");
                    paymentResponse.setTransactionId("tran010100006");
                    break;
                default:
                    // Handle unexpected error code
                    break;
            }
        }
            return paymentResponse;
    }

    }