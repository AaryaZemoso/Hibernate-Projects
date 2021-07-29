package demo;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentAndCourseDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();

            // Create Course
//            Course course = new Course("Spring");
//            session.save(course);

//            Student student1 = new Student("aar", "dev", "email");
//            Student student2 = new Student("aarya", "devarla", "anotheremail");
//
//            course.addStudent(student1);
//            course.addStudent(student2);
//
//            session.save(student1);
//            session.save(student2);
//
//            Course course = new Course("Hibernate");
//            session.save(course);

//            course.addStudent(student1);
//            course.addStudent(student2);
//
//            session.save(student1);
//            session.save(student2);

            // Verifying if student has the courses

//            int id = 4;
//
//            Student stu = session.get(Student.class, id);
//            stu.getCourses().stream().forEach(System.out::println);

            // Deleting a student

            int id = 4;

            Student stu = session.get(Student.class, id);
            session.delete(stu);


            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }
    }

}
