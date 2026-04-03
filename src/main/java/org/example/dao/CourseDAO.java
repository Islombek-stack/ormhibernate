package org.example.dao;

import org.example.entity.Course;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDAO extends BaseDAO<Course>{
    public CourseDAO() {
        super(Course.class);
    }
    public Course findByCode(String code){
        try(Session session = sessionFactory.openSession()) {
            Query<Course> query = session.createQuery(
                    "FROM Course WHERE code = :code", Course.class);
            query.setParameter("code", code);
            return query.uniqueResult();
        }
    }
    public List<Course> findByDepartment(String department){
        try(Session session = sessionFactory.openSession()){
            Query<Course> query = session.createQuery(
                    "FROM Course WHERE departmentId=:departmentId",Course.class);
            query.setParameter("departmentId", department);
            return query.list();
        }
    }
    public List<Course> findByProfessor(String professor){
        try(Session session = sessionFactory.openSession()){
            Query<Course> query = session.createQuery(
                    "FROM Course WHERE professorId=:professorId",Course.class);
            query.setParameter("professorId", professor);
            return query.list();
        }
    }
}
