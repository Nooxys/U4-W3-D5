package CiroVitiello.entities;

import CiroVitiello.enums.Periodicity;
import com.github.javafaker.Faker;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Random;
import java.util.function.Supplier;
@Entity
public class Magazine extends LibraryArchive {

    //  ATTRIBUTES
@Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    // CONSTRUCTORS
public Magazine(){

}

    public Magazine(int ISBNcode, String title, int yearOfPublication, int pages, Periodicity periodicity) {
        super(ISBNcode, title, yearOfPublication, pages);
        this.periodicity = periodicity;
    }


    // SUPPLIER

    public static Supplier<Magazine> magazineSupplier() {

        return () -> {
            Faker faker = new Faker();
            Random random = new Random();
            int code = random.nextInt(1, 500);
            String title = faker.book().title();
            int releaseDate = random.nextInt(1960, 2024);
            int pages = random.nextInt(50, 300);
            Periodicity periodicity = Periodicity.randomPeriodicity();

            return new Magazine(code, title, releaseDate, pages, periodicity);
        };

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
}
