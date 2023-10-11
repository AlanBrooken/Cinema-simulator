package org.hibernateProject.dao;

import org.hibernate.SessionFactory;
import org.hibernateProject.domain.Film;

public class FilmDAO extends GenericDAO<Film>{
    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }
}
