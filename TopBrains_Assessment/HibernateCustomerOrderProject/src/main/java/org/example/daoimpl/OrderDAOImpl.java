package org.example.daoimpl;

import org.example.dao.OrderDAO;
import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public String saveOrder(Order order) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(order);

        tx.commit();
        session.close();

        return "Order Saved Successfully";
    }

    @Override
    public String updateOrder(Order order) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(order);

        tx.commit();
        session.close();

        return "Order Updated Successfully";
    }

    @Override
    public String deleteOrderById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Order order = session.get(Order.class, id);

        if(order != null) {
            session.delete(order);
        }

        tx.commit();
        session.close();

        return "Order Deleted Successfully";
    }

    @Override
    public Order getOrderById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Order order = session.get(Order.class, id);

        session.close();

        return order;
    }

    @Override
    public String saveCustomer(Customer customer) {
        return "";
    }

    @Override
    public String updateCustomer(Customer customer) {
        return "";
    }

    @Override
    public String deleteCustomerById(int id) {
        return "";
    }

    @Override
    public Customer getCustomerById(int id) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return List.of();
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return null;
    }
}