package zti.zti_lab31;
import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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
}