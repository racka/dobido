package hu.nooon.dobido.client.event;

import com.google.gwt.event.shared.GwtEvent;
import hu.nooon.dobido.client.widgets.FutureProxyShape;

import java.util.List;

public class AnimationEvent extends GwtEvent<AnimationEventHandler> {

    public static Type<AnimationEventHandler> TYPE = new Type<AnimationEventHandler>();

    private List<FutureProxyShape> sequence;

    public AnimationEvent(List<FutureProxyShape> sequence) {
        this.sequence = sequence;
    }

    @Override
    public Type<AnimationEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AnimationEventHandler animationEventHandler) {
        animationEventHandler.animate(this);
    }

    public List<FutureProxyShape> getSequence() {
        return sequence;
    }
}
