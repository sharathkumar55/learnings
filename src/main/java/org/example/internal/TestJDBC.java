package org.example.internal;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker";
        String user = "hbstudents";
        String password = "hbstudents";
        try {
            System.out.println("COnnecting to Database"+jdbcURL);
            Connection myConn = DriverManager.getConnection(jdbcURL,user,password);
            System.out.println("connection Success");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
