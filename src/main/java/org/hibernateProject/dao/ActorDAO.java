package org.hibernateProject.dao;

import org.hibernate.SessionFactory;
import org.hibernateProject.domain.Actor;

public class ActorDAO extends GenericDAO<Actor> {
    public ActorDAO(SessionFactory sessionFactory) {
        super(Actor.class, sessionFactory);
    }
}
