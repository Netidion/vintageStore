package org.net.quarkus.microservices.book.model;

import jakarta.json.bind.annotation.JsonbProperty;

public class IsbnThirteen {

    @JsonbProperty("isbn_13")
    private String isbn13;

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IsbnThirteen{");
        sb.append("isbn13='").append(isbn13).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
