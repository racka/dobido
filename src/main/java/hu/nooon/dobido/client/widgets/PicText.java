package hu.nooon.dobido.client.widgets;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;

public class PicText {

    private int width, height;
    private int textHeight;
    private String text;
    private Attrs textBkgAttr;
    private Attrs textAttrs;

    public PicText(int width, int height, int textHeight, String text, Attrs textBkgAttr, Attrs textAttrs) {
        this.width = width;
        this.height = height;
        this.textHeight = textHeight;
        this.text = text;
        this.textBkgAttr = textBkgAttr;
        this.textAttrs = textAttrs;
    }

    public Shape create(Paper paper, int x, int y) {
        Shape frame = paper.path(
                "M" + x + "," + (y + textHeight)
                + "Q" + x + "," + y + "," + (x + textHeight) + "," + y
                + "H" + (x + width - textHeight)
                + "Q" + (x + width) + "," + y + "," + (x+width) + "," + (y + textHeight)
                + "V" + (y + (height - textHeight))
                + "H" + x
                + "V" + (y + textHeight)
                + "Z"
        ).attr(Attrs.create().stroke("gray").strokeWidth(.5));

        Shape txtPath = paper.path("M" + x + "," + (y + (height - textHeight))
                + "Q" + x + "," + (y + height) + "," + (x + textHeight) + "," + (y + height)
                + "H" + (x + width - textHeight)
                + "Q" + (x + width) + "," + (y + height) + "," + (x + width) + "," + (y + (height - textHeight))
                + "H" + x
                + "Z").attr(textBkgAttr);

        Shape txt = paper.text(x + 10, y + (height - (textHeight / 2)), text).attr(textAttrs);

        return paper.set().push(frame).push(txtPath).push(txt);
    }


}
