package CiroVitiello.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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
    @OneToMany(mappedBy = "user")
    private List<Loan> loanList;
@Column(unique = true, nullable = false)
    private int cardNumber;


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
