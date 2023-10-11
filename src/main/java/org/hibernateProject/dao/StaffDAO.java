package org.hibernateProject.dao;

import org.hibernate.SessionFactory;
import org.hibernateProject.domain.Staff;

public class StaffDAO extends GenericDAO<Staff> {
    public StaffDAO(SessionFactory sessionFactory) {
        super(Staff.class, sessionFactory);
    }
}
