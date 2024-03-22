package CiroVitiello.entities;


import com.github.javafaker.Faker;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Entity
public class User {

   // ATTRIBUTES
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "user_id")

private long id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;

@Column(unique = true, nullable = false)
    private int cardNumber;
    @OneToMany(mappedBy = "user")
    private List<Loan> loanList;

    // SUPPLIER

    public static Supplier<User> userSupplier() {

        return () -> {
            Faker faker = new Faker();
            Random random = new Random();
            String name = faker.name().firstName();
            String surname = faker.name().lastName();
            LocalDate date = LocalDate.of(random.nextInt(1971, 2005),
                    random.nextInt(1, 13),
                    random.nextInt(1, 29));
            int card = random.nextInt(1,1000);
            return new User(name, surname, date,card);
        };

    }

    // CONSTRUCTORS


    public User(){

    }

    public User(String name, String surname, LocalDate dateOfBirth, int cardNumber) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
    }

   // METHODS


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getId() {
        return id;
    }


    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", cardNumber=" + cardNumber +
                '}';
    }
}
