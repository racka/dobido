package hu.nooon.dobido.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import hu.nooon.dobido.client.database.MyRequestFactory;
import hu.nooon.dobido.client.layout.MainLayout;


public class SiteEntryPoint implements EntryPoint {


    private final EventBus eventBus = new SimpleEventBus();
    private MyRequestFactory requestFactory;

    /*
            menu1.click(new MouseEventListener() {
            @Override
            public void notifyMouseEvent(NativeEvent nativeEvent) {
                DummyRequest request = requestFactory.dummyRequest();
                DummyProxy newDummy = request.create(DummyProxy.class);
                newDummy.setName("Ez");
                Request<Void> createReq = request.persist().using(newDummy);
                createReq.fire(new Receiver<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        paper.text(10, 10, "SIKER");
                    }
                });
            }
        });

                menu2Bkg.click(new MouseEventListener() {
            @Override
            public void notifyMouseEvent(NativeEvent nativeEvent) {
                DummyRequest request = requestFactory.dummyRequest();

                Request<DummyProxy> findRequest = request.findByName("Ez");
                findRequest.fire(new Receiver<DummyProxy>() {
                    @Override
                    public void onSuccess(DummyProxy response) {
                        paper.text(100, 100, response.getName()).attr(font1);
                    }
                });
            }
        });


     */




    public void onModuleLoad() {

        requestFactory = GWT.create(MyRequestFactory.class);
        requestFactory.initialize(eventBus);

        Composite layout = new MainLayout();

        RootLayoutPanel.get().add(layout);

    }



}

