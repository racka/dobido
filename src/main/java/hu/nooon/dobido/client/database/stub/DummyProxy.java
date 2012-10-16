package hu.nooon.dobido.client.database.stub;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import hu.nooon.dobido.server.database.entity.Dummy;

@ProxyFor(Dummy.class)
public interface DummyProxy extends EntityProxy {

    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);
}
