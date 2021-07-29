package demo;

import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            int id = 3;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            Instructor instructor = instructorDetail.getInstructor();

            System.out.println(instructorDetail);
            System.out.println(instructor);

            instructor.setInstructorDetail(null);
            session.delete(instructorDetail);

            session.getTransaction().commit();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            session.close();
            factory.close();

        }
    }
}
