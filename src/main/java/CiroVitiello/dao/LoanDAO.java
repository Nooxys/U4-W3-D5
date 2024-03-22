package CiroVitiello.dao;


import CiroVitiello.entities.Loan;
import CiroVitiello.exceptions.NoFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LoanDAO {
    private EntityManager em;

    public LoanDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Loan loan) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(loan);
            t.commit();
            System.out.println("The loan " + loan.getId() + " - created!");
        } catch (NoFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Loan findById(long id) {
        return em.find(Loan.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Loan found = em.find(Loan.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Loan eliminated");
            } else System.out.println("Loan not found");


        } catch (NoFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
