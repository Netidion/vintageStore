package org.net.quarkus.microservices.book.model;

import java.time.Instant;

public class Book {

    private String isbn13;
    private String title;
    private String Author;
    private int yearOfPublication;
    private String genre;
    private Instant creationDate;

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("isbn13='").append(isbn13).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", Author='").append(Author).append('\'');
        sb.append(", yearOfPublication=").append(yearOfPublication);
        sb.append(", genre='").append(genre).append('\'');
        sb.append(", creationDate=").append(creationDate);
        sb.append('}');
        return sb.toString();
    }
}
