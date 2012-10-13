package hu.nooon.dobido.client.event;

import com.google.gwt.event.shared.GwtEvent;
import org.sgx.raphael4gwt.raphael.event.Callback;

public class DeferredLogicEvent extends GwtEvent<DeferredLogicEventHandler> {

    public static Type<DeferredLogicEventHandler> TYPE = new Type<DeferredLogicEventHandler>();

    private Callback callback;

    public DeferredLogicEvent(Callback callback) {
        this.callback = callback;
    }

    @Override
    public Type<DeferredLogicEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DeferredLogicEventHandler deferredLogicEventHandler) {
        deferredLogicEventHandler.defer(this);
    }

    public Callback getCallback() {
        return callback;
    }
}
