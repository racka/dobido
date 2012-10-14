package hu.nooon.dobido.client.widgets;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;

public class MenuGrid extends CustomGrid {


    public MenuGrid(int x, int y, int gridCols, int cellWidth, int cellHeight, int xPadding, int yPadding) {
        super(x, y, gridCols, cellWidth, cellHeight, xPadding, yPadding);
    }

    public Shape putJuciMenuItemToGrid(Paper paper, int xCoord, int yCoord, PicText menuItem) {

        if (xCoord >= gridCols || xCoord < 0 || yCoord < 0) {
            return null;
        }

        int linearCoord = y * gridCols + x;
        Shape obsoleteShape = shapesOnGrid.get(linearCoord);
        Shape actualShape = menuItem.create(paper, x + xCoord * (cellWidth + xPadding), y + yCoord * (cellHeight + yPadding));
        shapesOnGrid.put(linearCoord, actualShape);
        showNewShape(obsoleteShape, actualShape);

        return actualShape;
    }

}
