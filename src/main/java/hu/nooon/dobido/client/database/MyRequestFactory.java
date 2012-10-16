package hu.nooon.dobido.client.database;

import com.google.web.bindery.requestfactory.shared.RequestFactory;
import hu.nooon.dobido.client.database.stub.DummyRequest;

public interface MyRequestFactory extends RequestFactory {

    DummyRequest dummyRequest();

}
