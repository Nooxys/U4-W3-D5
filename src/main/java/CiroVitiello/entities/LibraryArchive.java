package CiroVitiello.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "kind_of_readable")
public abstract class LibraryArchive {

    //  ATTRIBUTES
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@Column(unique = true, nullable = false)
    protected int ISBNcode;
    protected String Title;
    protected int yearOfPublication;
@Column(name = "number_of_pages")
    protected int pages;

@OneToOne
@JoinColumn(name = "loan_id")
protected Loan loan;


    // CONSTRUCTOR

    public LibraryArchive(){

    }

    public LibraryArchive(int ISBNcode, String title, int yearOfPublication, int pages, Loan loan) {
        this.ISBNcode = ISBNcode;
        Title = title;
        this.yearOfPublication = yearOfPublication;
        this.pages = pages;
        this.loan = loan;
    }


    // METHODS


    @Override
    public String toString() {
        return "LibraryArchive{" +
                "ISBNcode=" + ISBNcode +
                ", Title='" + Title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", pages=" + pages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryArchive that = (LibraryArchive) o;
        return ISBNcode == that.ISBNcode && yearOfPublication == that.yearOfPublication && pages == that.pages && Objects.equals(Title, that.Title);
    }



    public int getISBNcode() {
        return ISBNcode;
    }

    public String getTitle() {
        return Title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public int getPages() {
        return pages;
    }

    public long getId() {
        return id;
    }

    public void setISBNcode(int ISBNcode) {
        this.ISBNcode = ISBNcode;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
