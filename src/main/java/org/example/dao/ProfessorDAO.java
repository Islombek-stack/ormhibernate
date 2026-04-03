package org.example.dao;

import org.example.entity.Professor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProfessorDAO extends BaseDAO<Professor> {
    public ProfessorDAO() {
        super(Professor.class);
    }
    public Professor findByEmail(String email) {
        try(Session session = sessionFactory.openSession()) {
            Query<Professor> query = session.createQuery(
                    "from Professor where email = :email", Professor.class
            );
            query.setParameter("email", email);
            return query.uniqueResult();
        }
    }

    public List<Professor> findByUniversity(String university) {
        try(Session session = sessionFactory.openSession()) {
            Query<Professor> query = session.createQuery(
                    "FROM Professor WHERE university.id = :universityId", Professor.class
            );
            query.setParameter("university", university);
            return query.list();
        }
    }
    public List<Professor> findByDepartment(String department) {
        try(Session session = sessionFactory.openSession()) {
            Query<Professor> query = session.createQuery(
                    "FROM Professor WHERE department.id = :departmentId", Professor.class
            );
            query.setParameter("department", department);
            return query.list();
        }
    }
    public List<Professor> findByDegree(String degree) {
        try(Session session = sessionFactory.openSession()) {
            Query<Professor> query = session.createQuery(
                    "FROM Professor WHERE degree = :degree", Professor.class
            );
            query.setParameter("degree", degree);
            return query.list();
        }
    }
}
