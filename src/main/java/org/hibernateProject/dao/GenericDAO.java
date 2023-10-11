package org.hibernateProject.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public abstract class GenericDAO<T> {
    private final Class<T> clazz;
    private final SessionFactory sessionFactory;

    public GenericDAO(Class<T> clazz, SessionFactory sessionFactory) {
        this.clazz = clazz;
        this.sessionFactory = sessionFactory;
    }

    public T getById(final int id) {
        return (T) sessionFactory.getCurrentSession().get(clazz, id);
    }

    public List<T> getItems(int offset, int count) {
        Query<T> query = sessionFactory.getCurrentSession().createQuery("from " + clazz.getName(), clazz);
        query.setFirstResult(offset);
        query.setMaxResults(count);
        return query.list();
    }

    public List<T> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from " + clazz.getName(), clazz).list();
    }

    public T save(final T entity) {
        sessionFactory.getCurrentSession().persist(entity);
        return entity;
    }

    public T update(final T entity) {
        sessionFactory.getCurrentSession().merge(entity);
        return entity;
    }

    public void delete(final T entity) {
        sessionFactory.getCurrentSession().remove(entity);
    }

    public void deleteById(final int id) {
        final T entity = getById(id);
        sessionFactory.getCurrentSession().remove(entity);
    }
}
