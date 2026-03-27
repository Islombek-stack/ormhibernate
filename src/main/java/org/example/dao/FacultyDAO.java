package org.example.dao;

import org.example.entity.Faculty;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class FacultyDAO extends BaseDAO<Faculty> {
    public FacultyDAO() {
        super(Faculty.class);
    }

    public Faculty findFacultyByNameAndUniversity(String facultyName,  String universityID) {
        try(Session session = sessionFactory.openSession()) {
            Query<Faculty> query = session.createQuery(
                    "FROM Faculty WHERE name = :name AND university = :univId", Faculty.class
            );
            query.setParameter("name", facultyName);
            query.setParameter("univId", universityID);
            return (Faculty) query.getSingleResult();
        }
    }
}

