package CiroVitiello.dao;


import CiroVitiello.entities.LibraryArchive;
import CiroVitiello.exceptions.NoFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class LibraryArchiveDAO {
    private EntityManager em;

    public LibraryArchiveDAO(EntityManager em) {
        this.em = em;
    }


    public void save(LibraryArchive readable) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(readable);
            t.commit();
            System.out.println("The readable " + readable.getTitle() + " - created!");
        } catch (NoFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public LibraryArchive findById(long id) {
        return em.find(LibraryArchive.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            LibraryArchive found = em.find(LibraryArchive.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Readable eliminated");
            } else System.out.println("Readable not found");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
