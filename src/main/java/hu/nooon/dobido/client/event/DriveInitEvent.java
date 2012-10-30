package hu.nooon.dobido.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class DriveInitEvent extends GwtEvent<DriveInitEventHandler> {

    public static Type<DriveInitEventHandler> TYPE = new Type<DriveInitEventHandler>();

    @Override
    public Type<DriveInitEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DriveInitEventHandler handler) {
        handler.onDriveInit(this);
    }
}
