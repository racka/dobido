package hu.nooon.dobido.client.widgets;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;

public class JuciMenuItem {

    private int width, height;
    private int textHeight;
    private String text;
    private Attrs textBkgAttr;
    private Attrs textAttrs;

    public JuciMenuItem(int width, int height, int textHeight, String text, Attrs textBkgAttr, Attrs textAttrs) {
        this.width = width;
        this.height = height;
        this.textHeight = textHeight;
        this.text = text;
        this.textBkgAttr = textBkgAttr;
        this.textAttrs = textAttrs;
    }

    public Shape create(Paper paper, int x, int y) {
        Shape frame = paper.rect(Raphael.createRectangle(x, y, width, height), 10).attr(Attrs.create().stroke("gray").strokeWidth(.5));
        Shape txtBkg = paper.rect(Raphael.createRectangle(x, y + (height - textHeight), width, textHeight), 10).attr(textBkgAttr);
        Shape txt = paper.text(x + 10, y + (height - (textHeight/2)), text).attr(textAttrs);

        return paper.set().push(frame).push(txtBkg).push(txt);
    }

}
