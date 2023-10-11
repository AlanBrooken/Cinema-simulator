package org.hibernateProject.dao;

import org.hibernate.SessionFactory;
import org.hibernateProject.domain.Language;

public class LanguageDAO extends GenericDAO<Language> {
    public LanguageDAO(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}
