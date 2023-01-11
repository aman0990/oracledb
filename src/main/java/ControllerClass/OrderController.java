package ControllerClass;

import ModelClass.Order;
import ServiceClass.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService OrderService;

    @PostMapping("/order")
    public Order createOrder (@RequestBody Order order) {
        return order;
    }

    public ServiceClass.OrderService getOrderService ( ) {
        return OrderService;

    }
}
