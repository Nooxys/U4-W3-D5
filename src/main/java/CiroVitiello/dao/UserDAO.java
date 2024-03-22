package CiroVitiello.dao;


import CiroVitiello.entities.User;
import CiroVitiello.exceptions.NoFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserDAO {
    private EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }


    public void save(User user) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(user);
            t.commit();
            System.out.println("The user "  + user.getName() + " - created!");
        } catch (NoFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public User findById(long id) {
        return em.find(User.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            User found = em.find(User.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("User eliminated");
            } else System.out.println("User not found");


        } catch (NoFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
