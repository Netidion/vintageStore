package org.net.quarkus.microservices.book.client;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.net.quarkus.microservices.book.model.IsbnThirteen;

@Mock
@RestClient
public class MockNumberProxy implements NumberProxy{
    @Override
    public IsbnThirteen getIsbnNumbers() {

        IsbnThirteen isbnThirteen = new IsbnThirteen();
        isbnThirteen.setIsbn13("13-mock");
        return isbnThirteen;
    }
}
