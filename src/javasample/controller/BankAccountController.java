package javasample.controller;

import javasample.entity.BankAccount;

import java.util.List;
import javax.persistence.*;

public class BankAccountController {
    
    private static EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myJPA");

    public BankAccountController() {
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public BankAccount findByNumber(int accountNumber) {
    
        EntityManager em = null;
        BankAccount ba = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("select ba from BankAccount ba where ba.number = :num");
            q.setParameter("num", accountNumber);
            ba = (BankAccount) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("Account Not Found!");
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return ba;

    }
    
    public String deleteByNumber(int accountNumber) {
    
        EntityManager em = null;
        BankAccount ba = null;
        String msg ;
        try {
            em = getEntityManager();
            Query q = em.createQuery("select ba from BankAccount ba where ba.number = :num");
            q.setParameter("num", accountNumber);
            ba = (BankAccount) q.getSingleResult();
            em.getTransaction().begin();
            em.remove(ba);
            em.getTransaction().commit();
            msg = "Account is deleted successfully";
        } catch (Exception e) {
            msg = "Account Not Found!";
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return msg;
    }

    
    public String createAccount(BankAccount ba) {
        
        EntityManager em = null;
        String msg ;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ba);
            em.getTransaction().commit();
            msg = "Account is Created"; 
        }catch(Exception e){
            msg = "The number is duplicated";       
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return msg;
    }
    
    public String updateAccount(BankAccount bank) {
        String msg;
        BankAccount ba = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("select ba from BankAccount ba where ba.number = :num");
            q.setParameter("num", bank.getNumber());
            ba = (BankAccount) q.getSingleResult();
            em.getTransaction().begin();
            ba.setBalance(bank.getBalance());
            ba.setOwner(bank.getOwner());
            em.getTransaction().commit();
            msg = "Account is Updated";
        }catch(Exception e){
            msg = "Account Not Found!";
        }finally {
            if (em != null) {
                em.close();
            }
        }
        return msg;
    }
    
    public List findAll() {
        
        EntityManager em = null;
        List list = null;
        em = getEntityManager();
        Query q = em.createQuery("select ba.number, ba.owner, ba.balance from BankAccount ba");
        list = q.getResultList();
  
        return list;
        
    }  
    
}
