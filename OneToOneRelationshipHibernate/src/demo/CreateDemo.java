package demo;

import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{

            Instructor musk = new Instructor("Elon", "Musk", "elonmusk@tesla.com");
            InstructorDetail muskDetail = new InstructorDetail("youtube.com/tesla", "Experimenting stuff");

            musk.setInstructorDetail(muskDetail);

            session.beginTransaction();

            // Cascading takes place
            session.save(musk);

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }

}
