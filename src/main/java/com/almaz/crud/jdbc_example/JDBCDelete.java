package com.almaz.crud.jdbc_example;

import java.sql.*;

public class JDBCDelete {

    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "Jpa333";

    public static void main(String[] args) {

        Connection connection = null;
//        Student student = new Student("Chanel", "King", 9.1);


        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);

            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM students WHERE surname = ?");

            statement.setString(1, "Dean");
            statement.executeUpdate();

            int deleteRows = statement.executeUpdate();
            System.out.println("deleteRows: " + deleteRows);

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
