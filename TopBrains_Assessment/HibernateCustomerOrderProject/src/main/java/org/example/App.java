package org.example;

import org.example.daoimpl.CustomerDAOImpl;
import org.example.entity.Customer;
import org.example.entity.Order;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        CustomerDAOImpl dao = new CustomerDAOImpl();

        Order order = new Order("ORD101","Laptop",1,75000,
                LocalDate.now());

        Customer customer = new Customer(
                "Rahul Sharma",
                "rahul@example.com",
                "Male",
                9876543210L,
                LocalDate.now(),
                order
        );

        System.out.println(dao.saveCustomer(customer));

        Customer fetched = dao.getCustomerById(1);

        if(fetched != null){
            System.out.println("Customer Name: " + fetched.getCustomerName());
            System.out.println("Product: " + fetched.getOrder().getProductName());
        }
    }
}