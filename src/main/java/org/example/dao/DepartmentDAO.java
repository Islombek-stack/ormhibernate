package org.example.dao;

import org.example.entity.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentDAO extends BaseDAO<Department> {
    public DepartmentDAO() {
        super(Department.class);
    }
    public List<Department> findByFaculty(Long facultyId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Department> query = session.createQuery(
                    "FROM Department WHERE faculty.id = :facultyId", Department.class);
            query.setParameter("facultyId", facultyId);
            return query.list();
        }}
    public Department findByNameAndFaculty(String name, Long facultyId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Department> query = session.createQuery(
                    "FROM Department WHERE faculty.name = :facultyName", Department.class);
            query.setParameter("name", name);
            query.setParameter("facultyId", facultyId);
            return query.uniqueResult();
        }
    }
}
