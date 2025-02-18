package com.almaz.crud.jpa_crud;

import com.almaz.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Find_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        Student student = null;

        try {
            student = entityManager.find(Student.class, 11);//поиск по id
        }
        catch (Exception e) {

            e.printStackTrace();
        }
        finally {
            if(entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }
        System.out.println(student);
    }
}
