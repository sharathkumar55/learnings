package test.oneToone.entities.mainclasses;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import test.oneToone.entities.Course;
import test.oneToone.entities.Instructor;
import test.oneToone.entities.InstructorDetail;

public class DeleteCourseDemo {
    public static void main(String[] args) {


        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).buildSessionFactory();




        //create session
        Session session = factory.getCurrentSession();

        try {


            //start the session
            session.beginTransaction();

            //get the course
            int theId = 11;
            Course tempCourse = session.get(Course.class,theId);

            //delete course
            System.out.println("deleting "+tempCourse);

            session.delete(tempCourse);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}