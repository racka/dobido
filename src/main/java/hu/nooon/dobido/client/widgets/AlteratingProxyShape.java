package hu.nooon.dobido.client.widgets;

import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.base.Attrs;

import java.util.List;

public class AlteratingProxyShape {

    private Set inner;
    private FutureProxyShape firstState;
    private FutureProxyShape secondState;
    private boolean isFirst;

    public AlteratingProxyShape(Set inner, List<Attrs> firstState, List<Attrs> secondState, int mills) {
        this.inner = inner;
        this.firstState = new FutureProxyShape(inner, firstState, mills, Raphael.EASING_LINEAR);
        this.secondState = new FutureProxyShape(inner, secondState, mills, Raphael.EASING_LINEAR);
        isFirst = true;
    }


    public AlteratingProxyShape flip() {
        if (isFirst) {
            secondState.stop();
            firstState.stop().animate(null);
        } else {
            firstState.stop();
            secondState.stop().animate(null);
        }
        isFirst = !isFirst;
        return this;
    }

    public AlteratingProxyShape flip(boolean isFirst) {
        if (isFirst) {
            secondState.stop();
            firstState.stop().animate(null);
        } else {
            firstState.stop();
            secondState.stop().animate(null);
        }
        this.isFirst = !isFirst;
        return this;
    }

    public Set getInner() {
        return inner;
    }

    public void dispose() {
        inner.remove();
    }
}
