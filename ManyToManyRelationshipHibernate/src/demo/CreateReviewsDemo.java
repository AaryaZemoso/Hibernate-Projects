package demo;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateReviewsDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();

            // Create Course
            Course course = new Course("Spring");

            // Create 3 Reviews
            Review review1 = new Review("Good");
            Review review2 = new Review("Bad");
            Review review3 = new Review("Best");

            course.add(review1);
            course.add(review2);
            course.add(review3);

            session.save(course);

            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }
    }

}
