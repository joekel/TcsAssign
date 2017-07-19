package tcs.exa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import tcs.exa.domain.Customer;


@Repository
public class CustomerServiceJPADaoImpl implements CustomerDAO{
	
	
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Customer> listAll() {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("from Customer", Customer.class).getResultList();
    }
    
    @Override
    public void saveOrUpdate(Customer thecustomer) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Customer savedCustomer = em.merge(thecustomer);
        em.getTransaction().commit();
    }
    
    @Override
    public Customer getById(int id) {
        EntityManager em = emf.createEntityManager();

        return em.find(Customer.class, id);
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Customer.class, id));
        em.getTransaction().commit();
    }
}
