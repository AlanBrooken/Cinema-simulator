package org.hibernateProject.dao;

import org.hibernate.SessionFactory;
import org.hibernateProject.domain.City;

public class CityDAO extends GenericDAO<City>{
    public CityDAO(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }
}
