package hu.nooon.dobido.client.widgets;

import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.Callback;

import java.util.HashMap;
import java.util.Map;

public class CustomGrid implements CustomLayer {


    protected int x, y;
    protected int gridCols;
    protected Map<Integer, Shape> shapesOnGrid = new HashMap<Integer, Shape>();
    protected int cellWidth, cellHeight;
    protected int xPadding = 0, yPadding = 0;


    public CustomGrid(int x, int y, int gridCols, int cellWidth, int cellHeight, int xPadding, int yPadding) {
        this.x = x;
        this.y = y;
        this.gridCols = gridCols;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.xPadding = xPadding;
        this.yPadding = yPadding;
    }

    public Shape putShapeToGrid(int x, int y, Shape shape) {

        if (x >= gridCols || x < 0 || y < 0) {
            return null;
        }

        int linearCoord = y * gridCols + x;
        Shape obsoleteShape = shapesOnGrid.get(linearCoord);
        Shape actualShape = shape.attr(getLinearCoord(x, y));
        shapesOnGrid.put(linearCoord, actualShape);
        showNewShape(obsoleteShape, actualShape);

        return actualShape;
    }

    protected void showNewShape(final Shape obsoleteShape, final Shape actualShape) {
        if (obsoleteShape != null) {
            obsoleteShape.stop();
            obsoleteShape.animate(
                    Raphael.animation(Attrs.create().opacity(0), 200, Raphael.EASING_LINEAR,
                            new Callback() {
                                @Override
                                public void call(Shape shape) {
                                    actualShape.toFront().show().animate(Raphael.animation(
                                            Attrs.create().opacity(1), 200, Raphael.EASING_LINEAR));
                                }
                            }).delay(getRandom(500)));
        } else {
            actualShape.toFront().show().animate(Raphael.animation(
                    Attrs.create().opacity(1),
                    200, Raphael.EASING_LINEAR).delay(getRandom(500)));
        }
    }

    private int getRandom(int max) {
        int nextRandom = (int) Math.floor(com.google.gwt.user.client.Random.nextDouble() * max);
        return nextRandom != 0 ? nextRandom : max;
    }

    @Override
    public CustomGrid clear() {

        for (int i : shapesOnGrid.keySet()) {
            removeShape(i, false);
        }
        return this;
    }

    @Override
    public CustomGrid removeShape(int index, boolean animated) {
        Shape old = shapesOnGrid.get(index);
        if (old != null) {
            shapesOnGrid.remove(index);
            hideShape(old, animated);
        }
        return this;
    }

    @Override
    public CustomLayer show(boolean animated) {
        for (Shape shape : shapesOnGrid.values()) {
            shape.show();
        }
        return this;
    }

    @Override
    public CustomLayer hide(boolean animated) {
        for (Shape shape : shapesOnGrid.values()) {
            hideShape(shape, animated);
        }
        return this;
    }

    private void hideShape(final Shape shape, boolean animated) {
        if (animated) {
            shape.stop().animate(Attrs.create().opacity(0), getRandom(2000), Raphael.EASING_LINEAR,
                    new Callback() {
                        @Override
                        public void call(Shape shape) {
                            shape.toBack().hide();
                        }
                    });
        } else {
            shape.stop().toBack().hide();
        }
    }


    private Attrs getLinearCoord(int xCoord, int yCoord) {
        return Attrs.create().x(x + xCoord * (cellWidth + xPadding)).y(y + yCoord * (cellHeight + yPadding));
    }

}
