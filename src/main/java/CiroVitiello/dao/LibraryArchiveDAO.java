package CiroVitiello.dao;


import CiroVitiello.entities.LibraryArchive;
import CiroVitiello.exceptions.NoFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class LibraryArchiveDAO {
    private EntityManager em;

    public LibraryArchiveDAO(EntityManager em) {
        this.em = em;
    }

    // SAVE ON DB BY ID

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

    // FIND ON DB BY ID
    public LibraryArchive findById(long id) {
        return em.find(LibraryArchive.class, id);
    }

    // FIND AND DELETE BY ID
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


        } catch (NoFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    //   SEARCH BY ISBN
    public LibraryArchive findByIsbn(int isbn) {
        TypedQuery<LibraryArchive> query = em.createQuery("SELECT l FROM LibraryArchive l WHERE l.ISBNcode = :isbn", LibraryArchive.class);
        query.setParameter("isbn", isbn);
        return query.getSingleResult();
    }

    // DELETE BY ISBN

    public void deleteByIsbn(int isbn){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("DELETE FROM LibraryArchive l WHERE l.ISBNcode = :isbn");
        query.setParameter("isbn", isbn);
        query.executeUpdate();
        transaction.commit();
        System.out.println("The readable " + isbn + "has been deleted!" );
    }

    // SEARCH BY YEAR

    public List<LibraryArchive> findByYear(int year) {
        TypedQuery<LibraryArchive> query = em.createQuery("SELECT l FROM LibraryArchive l WHERE l.yearOfPublication = :year", LibraryArchive.class);
        query.setParameter("year", year);
        return query.getResultList();
    }

}
