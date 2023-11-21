package org.net.quarkus.microservices.number.model;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;

import java.time.Instant;

public class IsbnNumbers {

    @JsonbProperty("isbn_10")
    private String isbn10;

    @JsonbProperty("isbn_13")
    private String isbn13;

    @JsonbTransient
    private Instant generationDate;

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public Instant getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Instant generationDate) {
        this.generationDate = generationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IsbnNumbers{");
        sb.append("isbn10='").append(isbn10).append('\'');
        sb.append(", isbn13='").append(isbn13).append('\'');
        sb.append(", generationDate=").append(generationDate);
        sb.append('}');
        return sb.toString();
    }
}
