package com.almaz.relationships.one_to_one;

import com.almaz.relationships.one_to_one.entity.Passport;
import com.almaz.relationships.one_to_one.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOnePersist_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();

            //Student student1 = new Student("Karl", "Bloom", 8.3);
            //Passport passport1 = new Passport("karl.bloom@gmail.com", 180,
                   // EyeColor.GREY);

//            student1.setPassport(passport1);
//
//
//            //entityManager.persist(passport1);
//            entityManager.persist(student1);

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
