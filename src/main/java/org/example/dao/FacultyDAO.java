package org.example.dao;

import org.example.entity.Faculty;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class FacultyDAO extends BaseDAO<Faculty>{
    public FacultyDAO() {
        super(Faculty.class);
    }

    public Faculty findByNameAndUniversity(String facultyName, String universityID) {
        try (Session session = sessionFactory.openSession()) {
            Query<Faculty> query = session.createQuery(
                    "FROM Faculty WHERE name = :name AND university = :univId", Faculty.class
            );
            query.setParameter("name", facultyName);
            query.setParameter("univId", universityID);
            return query.uniqueResult();

        }
    }
    public List<Faculty> findByUniversity(Long universityId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Faculty> query = session.createQuery(
                    "FROM Faculty WHERE university.id = :univId", Faculty.class);
            query.setParameter("univId", universityId);
            return query.list();
        }
    }

    public List<Faculty> findByDean(String deanName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Faculty> query = session.createQuery(
                    "FROM Faculty WHERE dean LIKE :dean", Faculty.class);
            query.setParameter("dean", "%" + deanName + "%");
            return query.list();
        }
    }
}
