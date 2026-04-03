package org.example.dao;

import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAO extends BaseDAO<Student> {

    public StudentDAO() {
        super(Student.class);
    }
    public Student findByStudentId(String studentId) {
        try(Session session = sessionFactory.openSession()) {
            Query<Student> query = session.createQuery(
                    "from Student where studentId = :studentId");
            query.setParameter("studentId", studentId);
            return query.uniqueResult();
        }
    }
    public Student findByEmail(String email){
        try(Session session = sessionFactory.openSession()) {
            Query query = session.createQuery(
                    "from Student where email = :email",Student.class);
            query.setParameter("email", email);
            return (Student) query.uniqueResult();
        }
    }
    public List<Student> findByUniversity(String university){
        try(Session session = sessionFactory.openSession()) {
            Query<Student> query = session.createQuery(
                    "from Student where university = :university", Student.class
            );
            query.setParameter("university", university);
            return query.list();
        }
    }
    public List<Student> findByFaculty(Long facultyId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Student> query = session.createQuery(
                    "FROM Student WHERE faculty.id = :facultyId", Student.class);
            query.setParameter("facultyId", facultyId);
            return query.list();
        }
    }

    public List<Student> findByStudyYear(StudyYear year) {
        try (Session session = sessionFactory.openSession()) {
            Query<Student> query = session.createQuery(
                    "FROM Student WHERE studyYear = :year", Student.class);
            query.setParameter("year", year);
            return query.list();
        }
    }

    public List<Student> findByGender(Gender gender) {
        try (Session session = sessionFactory.openSession()) {
            Query<Student> query = session.createQuery(
                    "FROM Student WHERE gender = :gender", Student.class);
            query.setParameter("gender", gender);
            return query.list();
        }
    }


    public List<Student> findTopByGPA(int limit) {
        try (Session session = sessionFactory.openSession()) {

            return session.createQuery(
                            "SELECT s FROM Student s ORDER BY s.id", Student.class)
                    .setMaxResults(limit)
                    .list();
        }
    }

}
