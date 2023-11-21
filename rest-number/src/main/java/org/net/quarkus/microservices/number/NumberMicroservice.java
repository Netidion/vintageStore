package org.net.quarkus.microservices.number;


import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationPath("/")
@OpenAPIDefinition(
        info = @Info(title = "Number Microservice",
                description = "This microservice generates book numbers",
                version = "1.0",
                contact = @Contact(name = "@Neti", url = "https://www.linkedin.com/in/neti-vallaj/")),
        externalDocs = @ExternalDocumentation(url = "https://github.com/Netidion/vintageStore",
                description = "All the Microservice code"),
        tags = {
                @Tag(name = "api", description = "Public API that can be used by anybody"),
                @Tag(name = "numbers", description = "Anybody interested in isbn book numbers")
        }
)
public class NumberMicroservice extends Application {
}
