package org.net.quarkus.microservices.number;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import org.net.quarkus.microservices.number.model.IsbnNumbers;

import java.time.Instant;
import java.util.Random;

@Path("/api/numbers")
public class NumberResource {

    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public IsbnNumbers generateIsbnNumbers() {
        IsbnNumbers isbnNumbers = new IsbnNumbers();
        isbnNumbers.setIsbn13("13-" + new Random().nextInt(100_000_000));
        isbnNumbers.setIsbn10("10-" + new Random().nextInt(100_000));
        isbnNumbers.setGenerationDate(Instant.now());
        logger.info("Numbers generated: " + isbnNumbers);

        return isbnNumbers;
    }
}
