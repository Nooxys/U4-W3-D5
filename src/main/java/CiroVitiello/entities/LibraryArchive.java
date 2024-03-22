package CiroVitiello.entities;




import jakarta.persistence.*;


import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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

@OneToOne(mappedBy = "readable")
protected Loan loan;


    // CONSTRUCTOR

    public LibraryArchive(){

    }

    public LibraryArchive(int ISBNcode, String title, int yearOfPublication, int pages) {
        this.ISBNcode = ISBNcode;
        Title = title;
        this.yearOfPublication = yearOfPublication;
        this.pages = pages;
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
}
