package ControllerClass;

import ModelClass.Customer;
import ModelClass.Order;
import ServiceClass.CustomerService;
import ServiceClass.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order) {
        return customerService.createOrder(order);
    }

    @GetMapping("/order/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return customerService.getOrderById(orderId);
    }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("/customers/{customerType}")
    public List <Customer> getCustomersByType(@PathVariable String customerType) {
        return customerService.getCustomersByType(customerType);
    }

    @PutMapping("/customer/{customerId}/promote")
    public Customer promoteCustomer(@PathVariable Long customerId, @RequestParam String customerType) {
        return customerService.promoteCustomer(customerId, customerType);
    }

    @PutMapping("/order/{orderId}/discount")
    public Order applyDiscount(@PathVariable Long orderId, @RequestParam double discount) {
        return customerService.applyDiscount(orderId, discount);
    }

}