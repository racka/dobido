package hu.nooon.dobido.client.widgets;

import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.Callback;

import java.util.List;

public class FutureProxyShape {

    private Set shape;
    private List<Attrs> attrs;
    private int mills;
    private String easing;

    public FutureProxyShape() {
    }

    public FutureProxyShape(Set shape, List<Attrs> attrs, int mills, String easing) {
        this.shape = shape;
        this.attrs = attrs;
        this.mills = mills;
        this.easing = easing;
    }

    public Shape getShape() {
        return shape;
    }

    public List<Attrs> getAttrs() {
        return attrs;
    }

    public int getMills() {
        return mills;
    }

    public String getEasing() {
        return easing;
    }

    public FutureProxyShape animate(final Callback callback) {
        if (callback != null) {
            for (int i = 0; i < shape.size(); i++) {
                if (i == 0) {
                    shape.item(i).animate(Raphael.animation(attrs.get(i), mills, easing, callback));
                } else {
                    shape.item(i).animate(Raphael.animation(attrs.get(i), mills, easing));
                }
            }
        } else {
            for (int i = 0; i < shape.size(); i++) {
                shape.item(i).animate(Raphael.animation(attrs.get(i), mills, easing));
            }
        }

        return this;
    }


    public FutureProxyShape stop() {
        for (int i = 0; i < shape.size(); i++) {
            shape.item(i).stop();
        }
        return this;
    }
}
