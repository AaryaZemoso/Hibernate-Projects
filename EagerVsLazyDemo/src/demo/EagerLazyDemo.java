package demo;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();

            int id = 1;

            Instructor instructor = session.get(Instructor.class, id);

            instructor.getCourses().stream().forEach(System.out::println);

            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }
    }

}
