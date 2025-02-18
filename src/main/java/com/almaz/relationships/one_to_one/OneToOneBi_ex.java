package com.almaz.relationships.one_to_one;

import com.almaz.relationships.one_to_one.entity.Passport;
import com.almaz.relationships.one_to_one.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOneBi_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();

//            Student student = new Student("Frankie", "Perry", 6.7);
//            Passport passport = new Passport("frankie.per18@yahoo.com", 165,
//                    "brown");
//            passport.setStudent(student);
//            student.setPassport(passport);
//
//            entityManager.persist(passport);

            Passport passport = entityManager.find(Passport.class, 5);
            System.out.println(passport);
            System.out.println(passport.getStudent());
//            Passport passport = entityManager.find(Passport.class, 2);
//            passport.getStudent().setPassport(null);/*для удаления только паспорта,
//            нужно сначала разорвать связь между ними*/
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
