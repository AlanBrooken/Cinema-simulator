package org.hibernateProject.dao;

import org.hibernate.SessionFactory;
import org.hibernateProject.domain.Address;

public class AddressDAO extends GenericDAO<Address> {
    public AddressDAO(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }
}
