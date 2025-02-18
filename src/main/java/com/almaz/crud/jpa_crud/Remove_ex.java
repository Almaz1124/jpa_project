package com.almaz.crud.jpa_crud;

import com.almaz.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
/*DROP TABLE test_db.students; - удаление всей таблицы через консоль MySQL*/
public class Remove_ex {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        Student student = null;

        try{
            transaction.begin();
            student = entityManager.find(Student.class, 13);
            entityManager.remove(student);

            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if(entityManager != null){
                entityManager.close();
                factory.close();
            }
        }
        System.out.println(student);
    }
}
