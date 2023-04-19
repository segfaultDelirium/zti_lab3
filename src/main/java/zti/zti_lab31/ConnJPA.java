package zti.zti_lab31;
import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


import zti.model.Person;

public class ConnJPA {
    private EntityManagerFactory managerFactory; // = Persistence.createEntityManagerFactory(persistenceUnitName);
    private EntityManager entityManager; // = managerFactory.createEntityManager();
    private EntityTransaction entityTransaction;

    public ConnJPA(String persistenceUnitName ) {
        managerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        entityManager = managerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @SuppressWarnings("unchecked")
    public List<Person> getPersonList() {
        List<Person> people = null;
        try {
            people = (List<Person>) entityManager.createNamedQuery("findAll").getResultList();
            // manager.close();
        } catch (Exception e) {
            System.out.println("Failed !!! " + e.getMessage());
        }
        return people;
    }

    public void savePerson( Person entity) {
        //entityTransaction.begin();
        System.out.println("[ConnJPA] Save entity - " + entity.getLname() );
        entityTransaction.begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityTransaction.commit();
    }

    public void updatePerson(Person entity) {
        entityTransaction.begin();
        entityManager.merge(entity);
        entityTransaction.commit();
    }

    public void deletePerson(Person entity) {
        System.out.println("Delete entity - " + entity.getLname() + " ID: " + entity.getId().toString());
        entityTransaction.begin();
        entityManager.remove(entity);
        entityManager.flush();
        entityTransaction.commit();
    }

    public Person findPerson(int id) {
        Person entity = (Person) entityManager.find(Person.class, id);
        return entity;
    }

    public List<Person> searchPerson(String searchText){
        List<Person> results = null;
        try {
            TypedQuery<Person> query = entityManager.createNamedQuery("searchByLnameOrEmail", Person.class);
            query.setParameter("lname", searchText);
            query.setParameter("email", searchText);
            results = (List<Person>) query.getResultList();
            // manager.close();
        } catch (Exception e) {
            System.out.println("Failed !!! " + e.getMessage());
        }
        return results;
    }

}