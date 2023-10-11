package org.hibernateProject.dao;

import org.hibernate.SessionFactory;
import org.hibernateProject.domain.Category;

public class CategoryDAO extends GenericDAO<Category> {
    public CategoryDAO(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
