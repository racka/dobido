package hu.nooon.dobido.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface DeferredLogicEventHandler extends EventHandler {

    void defer(DeferredLogicEvent event);

}
