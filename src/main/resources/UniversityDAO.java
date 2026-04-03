package org.example.dao;

import org.example.entity.University;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UniversityDAO extends BaseDAO<University> {
    public UniversityDAO() {
        super(University.class);
    }

    public University findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<University> query = session.createQuery(
                    "from University where name = :name", University.class);
            query.setParameter("name", name);
            return query.uniqueResult();
        }
    }

    public University findByCode(String code) {
        try (Session session = sessionFactory.openSession()) {
            Query<University> query = session.createQuery(
                    "From University where code = :code", University.class);
            query.setParameter("code", code);
            return query.uniqueResult();
        }
    }
    public List<University> findAllOrderByFoundedYear() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                            "from University order by foundedYear DESC ", University.class)
                    .list();
        }
    }


}
