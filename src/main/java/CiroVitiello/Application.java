package CiroVitiello;

import CiroVitiello.dao.LibraryArchiveDAO;
import CiroVitiello.dao.LoanDAO;
import CiroVitiello.dao.UserDAO;
import CiroVitiello.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D5");
    private static Logger logger = LoggerFactory.getLogger((Application.class));
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        Random random = new Random();
        LibraryArchiveDAO libraryArchiveDAO = new LibraryArchiveDAO(em);
        LoanDAO loanDAO = new LoanDAO(em);
        UserDAO userDAO = new UserDAO(em);

        // USERS CREATION

        Supplier<User> userSupplier = User.userSupplier();
        List<User> userList = new ArrayList<>();
        for (int i = 0; i <25 ; i++) {
            userList.add(userSupplier.get());
        }
//        userList.forEach(user ->  userDAO.save(user));

        // LIBRARY ARCHIVE CREATION

        List<LibraryArchive> archive = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            if (random.nextInt(0, 2) < 1) {
                archive.add(Book.booksSupplier().get());
            } else archive.add(Magazine.magazineSupplier().get());
        }
//    archive.forEach(libraryArchive -> libraryArchiveDAO.save(libraryArchive));


       // LOANS CREATION

//        for (int i = 0; i <15; i++) {
//            loanDAO.save(new Loan(userDAO.findById(random.nextInt(1,26)), libraryArchiveDAO.findById(i+1), LocalDate.now(), LocalDate.now().plusDays(random.nextInt(3,90))));
//        }

//        System.out.println(libraryArchiveDAO.findByIsbn(830));
//        libraryArchiveDAO.deleteByIsbn(830);
//        System.out.println(libraryArchiveDAO.findByYear(2014));



        emf.close();
        emf.close();
    }
}
