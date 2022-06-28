package test.oneToone.entities.mainclasses;

import com.hiberante.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import test.oneToone.entities.Instructor;
import test.oneToone.entities.InstructorDetail;

public class DeleteDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();
        try{
            int instructorId = 1;
            session.beginTransaction();
            Instructor tempInstructor = session.get(Instructor.class,instructorId);
            session.delete(tempInstructor);
            System.out.println("the deleted id is "+tempInstructor.getId());
            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            factory.close();
        }
    }
}
