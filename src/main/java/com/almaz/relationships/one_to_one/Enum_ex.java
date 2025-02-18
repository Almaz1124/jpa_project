package com.almaz.relationships.one_to_one;

import com.almaz.relationships.one_to_one.entity.Passport;
import com.almaz.relationships.one_to_one.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Enum_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();

            //Student student = new Student("Liza", "Shark", 8.1);
           // Passport passport = new Passport("Liza.Shark@gmail.com", 179,
                    //EyeColor.GREEN);

            //student.setPassport(passport);


            //entityManager.persist(passport1);
            //entityManager.persist(student);

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
