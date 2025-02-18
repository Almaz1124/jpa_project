package com.almaz.crud.jdbc_example;

import com.almaz.crud.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCSelect {

    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "Jpa333";

    public static void main(String[] args) {

        Connection connection = null;
//        Student student = new Student("Chanel", "King", 9.1);


        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM students WHERE avg_grade >= ?");
            statement.setDouble(1, 7.5);

            ResultSet resultSet = statement.executeQuery();

            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setAvgGrade(resultSet.getDouble("avg_grade"));

                students.add(student);
            }
            System.out.println(students);
            statement.close();
            resultSet.close();

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
