package org.hibernateProject.dao;

import org.hibernate.SessionFactory;
import org.hibernateProject.domain.Country;

public class CountryDAO extends GenericDAO<Country> {
    public CountryDAO(SessionFactory sessionFactory) {
        super(Country.class, sessionFactory);
    }
}
