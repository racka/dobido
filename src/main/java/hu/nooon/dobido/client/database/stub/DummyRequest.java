package hu.nooon.dobido.client.database.stub;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import hu.nooon.dobido.server.database.entity.Dummy;

@Service(Dummy.class)
public interface DummyRequest extends RequestContext {


    Request<Long> countDummies();

    Request<DummyProxy> findDummy(Long id);

    Request<DummyProxy> findByName(String name);

    InstanceRequest<DummyProxy,Void> persist();

    InstanceRequest<DummyProxy,Void> remove();


}
