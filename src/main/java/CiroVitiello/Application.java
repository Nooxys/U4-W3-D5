package CiroVitiello;

import CiroVitiello.dao.LibraryArchiveDAO;
import CiroVitiello.dao.LoanDAO;
import CiroVitiello.dao.UserDAO;
import CiroVitiello.entities.*;
import CiroVitiello.enums.Periodicity;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D5");

    public static void main(String[] args) {
        Faker faker = new Faker();
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



       // LOANS CREATION
//
//        for (int i = 0; i <15; i++) {
//            loanDAO.save(new Loan(userDAO.findById(random.nextInt(1,26)),  LocalDate.now(), LocalDate.now().plusDays(random.nextInt(15,50))));
//        }

        // LIBRARY ARCHIVE CREATION


//        for (int i = 0; i < 20; i++) {
//            if (random.nextInt(0, 2) < 1) {
//                libraryArchiveDAO.save(new Book(random.nextInt(100,10000), faker.book().title(), random.nextInt(1950,2024), random.nextInt(100,600),loanDAO.findById(i+1),faker.book().author(),faker.book().genre() ));
//            } else {
//                libraryArchiveDAO.save(new Magazine(random.nextInt(100,10000),faker.book().title(),random.nextInt(1950,2024), random.nextInt(100,600), loanDAO.findById(i+1), Periodicity.randomPeriodicity()));
//            }
//        }


            // FIND BY ISBN

        System.out.println(libraryArchiveDAO.findByIsbn(165));

            // DELETE BY ISBN

        libraryArchiveDAO.deleteByIsbn(4335); //  <--- WILL DELETE THE CURRENT READABLE IN THE DB

            // FIND BY YEAR

        libraryArchiveDAO.findByYear(2014).forEach(libraryArchive -> System.out.println(libraryArchive));

            // FIND BY AUTHOR

        libraryArchiveDAO.findByAuthor("Ruthanne Thiel").forEach(libraryArchive -> System.out.println(libraryArchive));

            // FIND BY TITLE

       libraryArchiveDAO.findByTitle("The Daffodil Sky").forEach(libraryArchive -> System.out.println(libraryArchive));

            // FIND ELEMENT BY CARD NUMBER

        libraryArchiveDAO.findElementByCardNumber(193).forEach(element -> System.out.println(element));

            // FIND EXPIRED LOANS

        loanDAO.findExpiredLoans().forEach(loan -> System.out.println(loan));

        emf.close();
        emf.close();
    }
}
