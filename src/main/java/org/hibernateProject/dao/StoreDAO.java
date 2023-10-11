package org.hibernateProject.dao;

import org.hibernate.SessionFactory;
import org.hibernateProject.domain.Store;

public class StoreDAO extends GenericDAO<Store> {
    public StoreDAO(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }
}
