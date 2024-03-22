package CiroVitiello.entities;

import CiroVitiello.enums.Periodicity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Entity
public class Magazine extends LibraryArchive {

    //  ATTRIBUTES
@Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    // CONSTRUCTORS
public Magazine(){

}

    public Magazine(int ISBNcode, String title, int yearOfPublication, int pages,Loan loan, Periodicity periodicity) {
        super(ISBNcode, title, yearOfPublication, pages,loan);
        this.periodicity = periodicity;
    }

    // METHODS


    @Override
    public String toString() {
        return "Magazines{" +
                "periodicity=" + periodicity +
                ", ISBNcode=" + ISBNcode +
                ", Title='" + Title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", pages=" + pages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazines = (Magazine) o;
        return periodicity == magazines.periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }
}
