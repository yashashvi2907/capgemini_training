package org.example.daoimpl;

import org.example.dao.CustomerDAO;
import org.example.entity.Customer;
import org.example.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public String saveCustomer(Customer customer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(customer);

        tx.commit();
        session.close();

        return "Customer Saved Successfully";
    }

    @Override
    public String updateCustomer(Customer customer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(customer);

        tx.commit();
        session.close();

        return "Customer Updated Successfully";
    }

    @Override
    public String deleteCustomerById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = session.get(Customer.class, id);

        if(customer != null) {
            session.delete(customer);
        }

        tx.commit();
        session.close();

        return "Customer Deleted Successfully";
    }

    @Override
    public Customer getCustomerById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();

        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Customer> list =
                session.createQuery("from Customer", Customer.class).list();

        session.close();

        return list;
    }

    @Override
    public Customer getCustomerByEmail(String email) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        String jpql = "from Customer c where c.email = :email";

        Customer customer = session.createQuery(jpql, Customer.class)
                .setParameter("email", email)
                .uniqueResult();

        session.close();

        return customer;
    }
}