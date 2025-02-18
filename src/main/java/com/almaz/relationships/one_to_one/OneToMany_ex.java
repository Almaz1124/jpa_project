package com.almaz.relationships.one_to_one;

import com.almaz.relationships.one_to_one.entity.Passport;
import com.almaz.relationships.one_to_one.entity.Student;
import com.almaz.relationships.one_to_one.entity.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OneToMany_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();

//            University university = new University("Harvard"
//                    , Date.valueOf("1636-10-28"));
            University university = entityManager.find(University.class, 1);
            System.out.println(university);
//
//            Student student1 = new Student("Roy", "Harper", 6.6);
//            Passport passport1 = new Passport("roy.harger@gmail.com", 168,
//                    EyeColor.BLACK);
//
//            Student student2 = new Student("Nick", "Davis", 7.2);
//            Passport passport2 = new Passport("nickbaick@gmail.com", 176,
//                    EyeColor.BLUE);
//
//            student1.setPassport(passport1);
//            student2.setPassport(passport2);
//
//            university.addStudentToUniversity(student1);
//            university.addStudentToUniversity(student2);

//            entityManager.persist(university);//при первом создании универа, потом через find

            transaction.commit();//
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
