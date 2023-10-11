package org.hibernateProject.dao;

import org.hibernate.SessionFactory;
import org.hibernateProject.domain.Inventory;

public class InventoryDAO extends GenericDAO<Inventory> {
    public InventoryDAO(SessionFactory sessionFactory) {
        super(Inventory.class, sessionFactory);
    }
}
