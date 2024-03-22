package CiroVitiello.entities;


import jakarta.persistence.Entity;

import java.util.Objects;
@Entity
public class Book extends LibraryArchive {

    // ATTRIBUTES

    private String author;


    private String genre;

    // CONSTRUCTOR

    public Book(){

    }

    public Book(int ISBNcode, String title, int yearOfPublication, int pages,Loan loan, String author, String genre) {
        super(ISBNcode, title, yearOfPublication, pages,loan);
        this.author = author;
        this.genre = genre;
    }

    // METHODS


    @Override
    public String toString() {
        return "Books{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
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
        Book books = (Book) o;
        return Objects.equals(author, books.author) && Objects.equals(genre, books.genre);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }



}
