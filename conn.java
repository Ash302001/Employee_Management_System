package Employee.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    public Connection connection;
    public Statement statement;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // UPDATED: User 'aswin' and password '12345' from your SQL script
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "aswin", "12345");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Database Connection Failed: " + e.getMessage());
        }
    }
}