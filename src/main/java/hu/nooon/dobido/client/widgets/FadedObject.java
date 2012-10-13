package hu.nooon.dobido.client.widgets;

import com.google.gwt.dom.client.NativeEvent;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.Callback;
import org.sgx.raphael4gwt.raphael.event.HoverListener;

public class FadedObject  {

    private Shape _inner;

    public FadedObject(Shape shape, double opacity) {
        this._inner = shape;
        addFadeOnHover(_inner, opacity);
        this._inner.attr(Attrs.create().opacity(opacity));
    }


    private void addFadeOnHover(final Shape shape, final double opacity) {

        shape.hover(new HoverListener() {
            @Override
            public void hoverIn(NativeEvent nativeEvent) {
                shape.stop();
                shape.animate(Raphael.animation(
                        Attrs.create().opacity(1),
                        200, Raphael.EASING_LINEAR,
                        new Callback() {
                            @Override
                            public void call(Shape shape) {

                            }
                        }));
            }

            @Override
            public void hoverOut(NativeEvent nativeEvent) {
                shape.stop();
                shape.animate(Raphael.animation(
                        Attrs.create().opacity(opacity),
                        500, Raphael.EASING_LINEAR,
                        new Callback() {
                            @Override
                            public void call(Shape shape) {

                            }
                        }));
            }
        });

    }

    public Shape getShape() {
        return _inner;
    }
}
