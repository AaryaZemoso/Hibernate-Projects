package demo;

import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            int id = 1;

            Instructor ins = session.get(Instructor.class, id);

            if(ins != null)
            {
                // Cascade delete
                session.delete(ins);
                System.out.println("Deleting Instructor");
            }

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }
}
