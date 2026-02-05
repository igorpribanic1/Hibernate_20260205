package org.example;

import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Kreiranje SessionFactory
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {

        Product product = new Product();
        product.setName("New Product");
        product.setPrice(BigDecimal.valueOf(100));

        addProduct(product);

        product.setName("New Product Modified Name");
        updateProduct(product);


        deleteProduct(product);


    }






    public static void addProduct(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
            System.out.println("Product added successfully!");
        }
        catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }



    public static void updateProduct(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
            System.out.println("Product updated successfully!");
        }
        catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }





    public static void deleteProduct(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
            System.out.println("Product deleted successfully!");
        }
        catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }



}