package demo;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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

            Course OS = new Course("OS");
            Course C = new Course("C");
            Course Windows = new Course("Windows");

            instructor.add(OS);
            instructor.add(C);
            instructor.add(Windows);

            session.save(OS);
            session.save(C);
            session.save(Windows);

            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }
    }

}
