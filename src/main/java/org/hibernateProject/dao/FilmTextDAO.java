package org.hibernateProject.dao;

import org.hibernate.SessionFactory;
import org.hibernateProject.domain.FilmText;

public class FilmTextDAO extends GenericDAO<FilmText>{
    public FilmTextDAO(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}
