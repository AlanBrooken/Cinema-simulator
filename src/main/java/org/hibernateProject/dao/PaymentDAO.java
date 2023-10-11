package org.hibernateProject.dao;

import org.hibernate.SessionFactory;
import org.hibernateProject.domain.Payment;

public class PaymentDAO extends GenericDAO<Payment> {
    public PaymentDAO(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }
}
