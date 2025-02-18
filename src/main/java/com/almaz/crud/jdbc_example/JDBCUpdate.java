package com.almaz.crud.jdbc_example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCUpdate {

    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "Jpa333";

    public static void main(String[] args) {

        Connection connection = null;
//        Student student = new Student("Chanel", "King", 9.1);


        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name:");
            String enteredName = scanner.nextLine();
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE students SET avg_grade = 7.5 WHERE name = ?");
            statement.setString(1, enteredName);
            statement.executeUpdate();
//            Statement statement = connection.createStatement();
//            String sqlQuery = "UPDATE students SET avg_grade = 7.8" +
//                    "WHERE name = '" + enteredName + "'";
//            statement.executeUpdate(sqlQuery);
//            statement.close();


            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
