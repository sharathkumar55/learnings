package com.hiberante.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CreateStudentDemo {
    public static void main(String[] args) {
        //creating sessonFactory
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass(Student.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            System.out.println("creating student object");
            Student student = new Student("test5","demo5","demo5@gmail.com");

            session.beginTransaction();
            session.save(student);
            System.out.println("the saved id is "+student.getId());
            session.getTransaction().commit();
            System.out.println("Done!");

           //new code
            Session session1 = factory.getCurrentSession();
            session1.beginTransaction();
            Student myStudent = session1.get(Student.class,student.getId());
            System.out.println("the retrived data is mystudent"+myStudent);

            session1.getTransaction().commit();

            //retrive all data
            Session session2 = factory.getCurrentSession();
            session2.beginTransaction();
            List<Student> myStudentsList = session2.createQuery("from Student").getResultList();
            System.out.println(myStudentsList);
            session2.getTransaction().commit();

            //specfic retrival of data

            Session session3 = factory.getCurrentSession();
            session3.beginTransaction();
            List<Student> theStudentsList = session3.createQuery("from Student S WHERE S.firstName='sharath'").getResultList();
            System.out.println("the specific data is "+theStudentsList);
            session3.getTransaction().commit();

            //update the object
            Session session4 = factory.getCurrentSession();
            session4.beginTransaction();
            int theStudentId = 7;
            Student myStudent2 = session4.get(Student.class,theStudentId);
            myStudent2.setFirstName("updatedName");
            session4.getTransaction().commit();

            //delete the object
            Session session5 = factory.getCurrentSession();
            session5.beginTransaction();
            int studentId = 6;
            Student myStudent4 = session5.get(Student.class,studentId);
            System.out.println("the deleted object is "+myStudent4);
            session5.delete(myStudent4);
            session5.getTransaction().commit();



        }
        finally {
            factory.close();
        }
    }
}
