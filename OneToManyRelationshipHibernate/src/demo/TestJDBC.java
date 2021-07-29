package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestJDBC {
    public static void main(String[] args) {

        try{

            SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = factory.getCurrentSession();

            System.out.println("Connection established");
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
