package org.net.quarkus.microservices.book;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.net.quarkus.microservices.book.client.NumberProxy;
import org.net.quarkus.microservices.book.model.Book;
import org.net.quarkus.microservices.book.utils.Utilities;

import java.io.FileNotFoundException;
import java.time.Instant;

@Path("/api/books")
@Tag(name = "Book Rest endpoint")
public class BookResource {

    @Inject
    Logger logger;

    @RestClient
    NumberProxy numberProxy;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Operation(summary = "Creates Books", description = "Creates books with an ISBN number")
    @Retry(maxRetries = 3, delay = 5000)
    @Fallback(fallbackMethod = "fallingBackOnCreateBook")
    public Response createBook(@FormParam("title") String title,
                               @FormParam("author") String author,
                               @FormParam("year") int yearOfPublication,
                               @FormParam("genre") String genre) {
        Book book = new Book();
        book.setIsbn13(numberProxy.getIsbnNumbers().getIsbn13());
        book.setTitle(title);
        book.setAuthor(author);
        book.setYearOfPublication(yearOfPublication);
        book.setGenre(genre);
        book.setCreationDate(Instant.now());

        logger.info("Book created: " + book);
        return Response.status(201).entity(book).build();
    }


    public Response fallingBackOnCreateBook(@FormParam("title") String title,
                               @FormParam("author") String author,
                               @FormParam("year") int yearOfPublication,
                               @FormParam("genre") String genre) throws FileNotFoundException {

        Book book = new Book();
        book.setIsbn13("Will fetch later!");
        book.setTitle(title);
        book.setAuthor(author);
        book.setYearOfPublication(yearOfPublication);
        book.setGenre(genre);
        book.setCreationDate(Instant.now());

        Utilities.saveBookOnDisk(book);

        logger.warn("Book saved on disk due to fallback: " + book);
        return Response.status(206).entity(book).build();
    }




}
