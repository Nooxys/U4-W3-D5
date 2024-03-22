package CiroVitiello;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D5");
    private static Logger logger = LoggerFactory.getLogger((Application.class));

    public static void main(String[] args) {

        Faker faker = new Faker();

        System.out.println("Hello World!");
    }
}
