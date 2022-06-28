package test.oneToone.entities.mainclasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import test.oneToone.entities.Instructor;
import test.oneToone.entities.InstructorDetail;

public class GetInstructor {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        try{
            Session session = factory.getCurrentSession();
            int theID = 17;
            session.beginTransaction();
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,theID);
            System.out.println("related instructor is "+tempInstructorDetail.getInstructor());
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
