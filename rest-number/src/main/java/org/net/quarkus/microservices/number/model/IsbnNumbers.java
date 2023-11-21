package org.net.quarkus.microservices.number.model;

import java.time.Instant;

public class IsbnNumbers {

    public String isbn10;
    public String isbn13;
    public Instant generationDate;

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
