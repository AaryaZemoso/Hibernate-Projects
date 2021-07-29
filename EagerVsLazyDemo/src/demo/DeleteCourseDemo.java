package demo;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

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
            int courseId = 10;

            Instructor instructor = session.get(Instructor.class, id);
            Course OS = session.get(Course.class, courseId);

            session.delete(OS);

            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }
    }

}
