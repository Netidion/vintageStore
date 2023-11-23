package org.net.quarkus.microservices.book.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.net.quarkus.microservices.book.model.IsbnThirteen;


@Path("/api/numbers")
@RegisterRestClient(configKey = "number.proxy")
public interface NumberProxy {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
     IsbnThirteen getIsbnNumbers();
}
