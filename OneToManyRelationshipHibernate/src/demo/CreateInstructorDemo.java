package demo;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{

            Instructor musk = new Instructor("Bill", "Gates", "billgates@microsoft.com");
            InstructorDetail muskDetail = new InstructorDetail("youtube.com/billgates", "OS Dev");



            musk.setInstructorDetail(muskDetail);

            session.beginTransaction();



            session.save(musk);

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }

}
