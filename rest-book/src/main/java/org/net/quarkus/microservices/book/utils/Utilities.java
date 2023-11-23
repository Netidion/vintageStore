package org.net.quarkus.microservices.book.utils;

import jakarta.json.bind.JsonbBuilder;
import org.net.quarkus.microservices.book.model.Book;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Instant;

public class Utilities {
    public static void saveBookOnDisk(Book book) throws FileNotFoundException {
        String bookJson = JsonbBuilder.create().toJson(book);
        try (PrintWriter out = new PrintWriter("book-" + Instant.now().toEpochMilli() + ".json")) {
            out.println(bookJson);
        }
    }
}
