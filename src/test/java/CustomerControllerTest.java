
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import ControllerClass.CustomerController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import ModelClass.Customer;
import ModelClass.Order;
import ServiceClass.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @Autowired
    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        Mockito.when(customerService.createCustomer(Mockito.any(Customer.class))).thenReturn(customer);
        assertNotNull(customerController.createCustomer(customer));
    }

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        Mockito.when(customerService.createOrder(Mockito.any(Order.class))).thenReturn(order);
        assertNotNull(customerController.createOrder(order));
    }

    @Test
    public void testGetOrderById() {
        Order order = new Order();
        Long orderId = 1L;
        Mockito.when(customerService.getOrderById(Mockito.anyLong())).thenReturn(order);
        assertEquals(customerController.getOrderById(orderId), order);
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer();
        Long customerId = 1L;
        Mockito.when(customerService.getCustomerById(Mockito.anyLong())).thenReturn(customer);
        assertEquals(customerController.getCustomerById(customerId), customer);
    }

    @Test
    public void testGetCustomersByType() {
        String customerType = "regular";
        Mockito.when(customerService.getCustomersByType(Mockito.anyString())).thenReturn(Mockito.anyList());
        assertNotNull(customerController.getCustomersByType(customerType));
    }

    @Test
    public void testPromoteCustomer() {
        Customer customer = new Customer();
        Long customerId = 1L;
        String customerType = "platinum";
        Mockito.when(customerService.promoteCustomer(Mockito.anyLong(), Mockito.anyString())).thenReturn(customer);
        assertEquals(customerController.promoteCustomer(customerId, customerType), customer);
    }

    @Test
    public void testApplyDiscount() {
        Order order = new Order();
        Long orderId = 1L;
        double discount = 10.0;
        Mockito.when(customerService.applyDiscount(Mockito.anyLong(), Mockito.anyDouble())).thenReturn(order);
        assertEquals(customerController.applyDiscount(orderId, discount), order);
    }


}