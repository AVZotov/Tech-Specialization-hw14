package ru.gb.task01.controls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.gb.task01.models.Course;

import java.util.List;

public class SqlControls {
    private SessionFactory sessionFactory;

    public SqlControls() {
        createSessionFactory();
    }

    private void createSessionFactory(){
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
    }

    public void fillTable(int numberOfRecords){
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            for (int i = 0; i <= numberOfRecords; i++) {
                session.save(Course.generate());
            }

            session.getTransaction().commit();
        }
    }

    public List<Course> getAllData(){
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            List<Course> courses = session.createQuery("FROM Course", Course.class).getResultList();
            session.getTransaction().commit();
            return courses;
        }
    }

    public Course getCourseById(int id){
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Course course = session.get(Course.class, id);
            session.getTransaction().commit();
            return course;
        }
    }

    public void updateCourse(Course course) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
        }
    }

    public void deleteCourse(Course course) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.delete(course);
            session.getTransaction().commit();
        }
    }
}
