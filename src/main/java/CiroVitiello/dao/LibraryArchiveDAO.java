package CiroVitiello.dao;


import CiroVitiello.entities.Book;
import CiroVitiello.entities.LibraryArchive;
import CiroVitiello.exceptions.NoFoundException;
import jakarta.persistence.*;

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

    public void findByISBNandDeleteByIsbn(int isbn){
        try {
        EntityTransaction transaction = em.getTransaction();

        TypedQuery<LibraryArchive> delQuery = this.em.createQuery("SELECT l from LibraryArchive l WHERE l.ISBNcode = :isbn", LibraryArchive.class);
        delQuery.setParameter("isbn", isbn);
        LibraryArchive readable = delQuery.getSingleResult();

       if (readable != null){
           transaction.begin();
           this.em.remove(readable);
           transaction.commit();
           System.out.println("Readable with ISBN code: " + isbn + "has been deleted!");
       } }
       catch(NoFoundException e){
             e.getMessage();
        }
    }

    // SEARCH BY YEAR

    public List<LibraryArchive> findByYear(int year) {
        TypedQuery<LibraryArchive> query = em.createQuery("SELECT l FROM LibraryArchive l WHERE l.yearOfPublication = :year", LibraryArchive.class);
        query.setParameter("year", year);
        return query.getResultList();
    }

    // SEARCH BY AUTHOR

    public List<Book> findByAuthor(String author) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.author = :author", Book.class);
        query.setParameter("author", author);
        return query.getResultList();
    }

    // SEARCH BY TITLE

    public List<LibraryArchive> findByTitle(String title){
        TypedQuery<LibraryArchive> query = em.createQuery("SELECT l from LibraryArchive l WHERE LOWER(l.Title) LIKE LOWER (:title)", LibraryArchive.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    };
}
