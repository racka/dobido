package hu.nooon.dobido.client.widgets;

import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.event.Callback;

public class FutureCallback extends FutureProxyShape {

    private Shape shape;
    private Callback inner;

    public FutureCallback(Callback inner, Shape shape) {
        this.shape = shape;
        this.inner = inner;
    }

    @Override
    public FutureProxyShape animate(Callback callback) {
        inner.call(shape);
        return this;
    }
}
