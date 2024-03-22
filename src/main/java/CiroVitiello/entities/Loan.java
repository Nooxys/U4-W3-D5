package CiroVitiello.entities;

import java.time.LocalDate;

public class Loan {

    // ATTRIBUTES

    private User user;

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
