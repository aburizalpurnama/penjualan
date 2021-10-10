package com.rizalpurnama.Repository;

import com.rizalpurnama.entity.Customer;
import com.rizalpurnama.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerTests {

    @Autowired private CustomerRepository customerRepository;

    @Test
    void testSoftDelete() {
        long queryResult = customerRepository.count();
        System.out.println(queryResult);
        Assertions.assertEquals(2, queryResult);

        Customer customer = customerRepository.findById("C003").get();
        customerRepository.delete(customer);
        queryResult = customerRepository.count();
        Assertions.assertEquals(1, queryResult);
        System.out.println(queryResult);
    }

    @Test
    void testJpaAuditing() throws InterruptedException {
        Customer c = new Customer();
        c.setCode("C-004");
        c.setName("Customer 1");
        c.setPhoneNumber("0891929292");
        customerRepository.save(c);

        Thread.sleep(1000);
        c.setName("Test Update");
        customerRepository.save(c);

        Customer customer = customerRepository.findById(c.getId()).orElse(null);

        System.out.println("created :" + customer.getCreated());
        System.out.println("updated :" + customer.getUpdated());

        Assertions.assertNotEquals(customer.getCreated(), customer.getUpdated());

        Thread.sleep(3000);
    }
}
