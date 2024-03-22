package CiroVitiello.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Loan {

    // ATTRIBUTES
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
@ManyToOne
@JoinColumn(name = "user_id")
    private User user;
@OneToOne
@JoinColumn(name = "readable_id")
    private LibraryArchive readable;

    private LocalDate loanStartDate;

    private LocalDate expectedReturnDate;

    private LocalDate effectiveReturnDate;

    // CONSTRUCTORS

    public Loan(){

    }

    public Loan(User user, LibraryArchive readable, LocalDate loanStartDate, LocalDate expectedReturnDate, LocalDate effectiveReturnDate) {
        this.user = user;
        this.readable = readable;
        this.loanStartDate = loanStartDate;
        this.expectedReturnDate = expectedReturnDate;
        this.effectiveReturnDate = effectiveReturnDate;

    }

    // METHODS


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LibraryArchive getReadable() {
        return readable;
    }

    public void setReadable(LibraryArchive readable) {
        this.readable = readable;
    }

    public LocalDate getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(LocalDate loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public LocalDate getEffectiveReturnDate() {
        return effectiveReturnDate;
    }

    public void setEffectiveReturnDate(LocalDate effectiveReturnDate) {
        this.effectiveReturnDate = effectiveReturnDate;
    }

    public long getId() {
        return id;
    }



    @Override
    public String toString() {
        return "Loan{" +
                "user=" + user +
                ", readable=" + readable +
                ", loanStartDate=" + loanStartDate +
                ", expectedReturnDate=" + expectedReturnDate +
                ", effectiveReturnDate=" + effectiveReturnDate +
                '}';
    }
}
