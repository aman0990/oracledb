package com.example.oracledb.ControllerClass;


import com.example.oracledb.ModelClass.Customer;
import com.example.oracledb.ModelClass.Order;
import com.example.oracledb.RepoInterface.CustomerRepository;
import com.example.oracledb.RepoInterface.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/createCustomer")
    public ResponseEntity < Object > createCustomer (@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity <>("Customer created successfully", HttpStatus.OK);
    }
    @PostMapping("/createOrder")
    public ResponseEntity < Object > createOrder (@RequestBody Order order) {
        Customer customer = customerRepository.findById(order.getCustomerId()).get();
        double discount = 0;
        if (((Customer) customer).getOrderCount() >= 10 && customer.getOrderCount() < 20) {
            discount = 10;
        } else if (customer.getOrderCount() >= 20) {
            discount = 20;
        }
        order.setDiscount(discount);
        orderRepository.save(order);
        customer.setOrderCount(customer.getOrderCount() + 1);
        customerRepository.save(customer);
        return new ResponseEntity <>("Order created successfully", HttpStatus.OK);
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void sendMail ( ) {
        List < Customer > customers = customerRepository.findAll();
        for (Customer customer : customers) {
            if (customer.getOrderCount() == 9) {
                System.out.println("Sent mail to customer: " + customer.getId());
            }
        }
    }
}
