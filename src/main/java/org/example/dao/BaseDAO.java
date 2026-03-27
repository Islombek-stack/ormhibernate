package org.example.dao;

import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public abstract class BaseDAO<T> {

    private final Class<T> entityclass;
    protected SessionFactory sessionFactory;

    public BaseDAO(Class<T> entityclass) {
        this.entityclass = entityclass;
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public T saveOrUpdate(T entity) {
        Transaction tx = null;
        try (Session session = this.sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(entity);
            tx.commit();
            return entity;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Error saving entity" + entityclass.getSimpleName(), e);
        }
    }

    public T findById(Long id) {
        try (Session session = this.sessionFactory.openSession()) {
            return session.get(entityclass, id);
        }
    }

    public List<T> findAll() {
        try (Session session = this.sessionFactory.openSession()) {
            return session.createQuery("from " + entityclass.getSimpleName()).list();
        }
    }

    public T update(T entity) {
        Transaction tx = null;
        try (Session session = this.sessionFactory.openSession()) {
            tx = session.beginTransaction();
            T merged = session.merge(entity);
            tx.commit();
            return merged;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Error updating entity" + entityclass.getSimpleName(), e);
        }
    }

    public void delete(T entity) {
        Transaction tx = null;
        try (Session session = this.sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Error deleting entity" + entityclass.getSimpleName(), e);
        }
    }

    public void deleteById(Long id) {
        T entity = findById(id);
        if (entity != null) delete(entity);
    }
}