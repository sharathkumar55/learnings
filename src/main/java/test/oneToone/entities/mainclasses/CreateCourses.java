package test.oneToone.entities.mainclasses;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import test.oneToone.entities.Course;
import test.oneToone.entities.Instructor;
import test.oneToone.entities.InstructorDetail;
public class CreateCourses {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).buildSessionFactory();




        //create session
        try{
            Session session1 = factory.getCurrentSession();
            Instructor tempInstructor = new Instructor("sharath","kumar","demo@gmail.com");
            session1.beginTransaction();
            session1.save(tempInstructor);
            session1.getTransaction().commit();



            Session session = factory.getCurrentSession();
            session.beginTransaction();
            int theId = 1;
            Instructor tempInstructor2 = session.get(Instructor.class,theId);

            Course course1 = new Course("the test");
            Course course2 = new Course("testing2");

            tempInstructor2.add(course1);
            tempInstructor2.add(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {

        }
    }
}
