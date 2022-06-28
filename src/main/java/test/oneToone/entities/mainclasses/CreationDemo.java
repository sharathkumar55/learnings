package test.oneToone.entities.mainclasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import test.oneToone.entities.Instructor;
import test.oneToone.entities.InstructorDetail;

public class CreationDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        try{
            System.out.println("creating");

            Session session = factory.getCurrentSession();
            Instructor tempInstructor = new Instructor("sharath","kumar","demo@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("www.hjjj.com","cricket");
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            session.beginTransaction();
            session.save(tempInstructor);
            System.out.println("the saved id is "+tempInstructor.getId());
            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
                factory.close();
        }
    }
}
