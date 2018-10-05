package javasample.biz;

import javasample.entity.BankAccount;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.annotation.WebServlet;


public class BankAccountFacade {
    
    private static EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myJPA");
    private EntityManager em;

    public BankAccountFacade() {
        this.em = emf.createEntityManager();
    }

    public BankAccount findByNumber(int accountNumber) {
    
        BankAccount ba = null;
        Query q = em.createQuery("select ba from BankAccount ba where ba.number = :num");
        q.setParameter("num", accountNumber);
        try {
            ba = (BankAccount) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("Account Not Found!");
        }
        return ba;

    }
    
    public List getAccountLessThan(long amount)  {
    
        List list = null;
        Query q = em.createQuery("select ba from BankAccount ba where ba.balance < :amount");
        q.setParameter("amount", amount);
        try {
            list = q.getResultList();
        } catch (Exception e) {
            System.out.println("Account Not Found!");
        }
        return list;
        
    } 
     
    public void createAccount(BankAccount ba) {
        em.getTransaction().begin();
        em.persist(ba);
        em.getTransaction().commit();
    }
    
    public List<BankAccount> findAll() {
        List<BankAccount> list = null;
        Query q = em.createQuery("select ba from BankAccount ba");
        list = q.getResultList();
        return list;
    }  
    
}
