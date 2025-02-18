package com.almaz.relationships.one_to_one;

import com.almaz.relationships.one_to_one.entity.Passport;
import com.almaz.relationships.one_to_one.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOneFind_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();

            Student student = entityManager.find(Student.class, 11);
            System.out.println(student);
            System.out.println(student.getPassport());

            transaction.commit();//без этого строка НЕ сохранится в таблице
        }
        catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if(entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }

    }
}
