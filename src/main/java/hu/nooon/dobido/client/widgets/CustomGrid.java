package hu.nooon.dobido.client.widgets;

import org.sgx.raphael4gwt.raphael.*;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.event.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomGrid implements CustomLayer {


    private int gridCols, gridRows;
    private Map<Integer, Shape> shapesOnGrid = new HashMap<Integer, Shape>();
    private final List<Point> coords = new ArrayList<Point>();
    private int xPadding = 0, yPadding = 0;

    public CustomGrid(int x, int y, int rownum, int colnum, int cellWidth, int cellHeight) {
        this.gridCols = colnum;
        this.gridRows = rownum;

        for (int j = 0; j < rownum; j++) {
            for (int i = 0; i < colnum; i++) {
                coords.add(Raphael.createPoint(x + i * cellWidth, y + j * cellHeight));
            }
        }
    }

    public CustomGrid(int x, int y, int rownum, int colnum, int cellWidth, int cellHeight, int xPadding, int yPadding) {
        this(x, y, rownum, colnum, cellWidth, cellHeight);
        this.xPadding = xPadding;
        this.yPadding = yPadding;
    }

    public void putShapesToGrid(int x, int y, int cols, Set shapes) {

        if (shapes.size() == 0 || cols == 0 || shapes.size() % cols != 0) {
            return;
        }
        int actualX = x, actualY = y - 1;

        for (int i = 0; i < shapes.size(); i++) {
            if (i % cols == 0) {
                actualX = x;
                actualY++;
            }

            putShapeToGrid(actualX, actualY, shapes.item(i));

            actualX++;
        }
    }

    public Shape putShapeToGrid(int x, int y, Shape shape) {

        if (x >= gridCols || x < 0 || y >= gridRows || y < 0) {
            return null;
        }

        int linearCoord = y * gridCols + x;
        Point startCoord = coords.get(linearCoord);
        Shape obsoleteShape = shapesOnGrid.get(linearCoord);
        Shape actualShape = shape.attr(Attrs.create().x(startCoord.getX() + xPadding).y(startCoord.getY() + yPadding));
        shapesOnGrid.put(linearCoord, actualShape);
        showNewShape(obsoleteShape, actualShape);

        return actualShape;
    }


    private void showNewShape(final Shape obsoleteShape, final Shape actualShape) {
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

        for (int i = 0; i < gridCols * gridRows; i++) {
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
}
