package org.hibernateProject.dao;

import org.hibernate.SessionFactory;
import org.hibernateProject.domain.Rental;

public class RentalDAO extends GenericDAO<Rental> {
    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }
}
