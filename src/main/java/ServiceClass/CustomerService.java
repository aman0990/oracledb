package ServiceClass;

import ModelClass.Customer;
import ModelClass.CustomerType;
import ModelClass.Order;
import RepoInterface.CustomerRepository;
import RepoInterface.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Order createOrder(Order order) {
        Customer customer = customerRepository.findById(order.getCustomerId()).get();
        int customerOrders = customer.getOrders().size();
        customer.setOrders((List < Order >) order);
        if (customer.getOrderCount() == 10 && customerOrders < customer.getOrderCount()) {
            customer.setCustomerType(CustomerType.valueOf("gold"));
            customer.setOrderCount(20);
        } else if (customer.getOrderCount() == 20 && customerOrders < customer.getOrderCount()) {
            customer.setCustomerType(CustomerType.valueOf("platinum"));
        }
        customerRepository.save(customer);
        return orderRepository.save(order);
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }

    public List<Customer> getCustomersByType(String customerType) {
        return customerRepository.findByCustomerType(customerType);
    }

    public Customer promoteCustomer(Long customerId, String customerType) {
        Customer customer = customerRepository.findById(customerId).get();
        customer.setCustomerType(CustomerType.valueOf(customerType));
        return customerRepository.save(customer);
    }

    public Order applyDiscount(Long orderId, double discount) {
        Order order = orderRepository.findById(orderId).get();
        order.setDiscount(discount);
        return orderRepository.save(order);
    }
}