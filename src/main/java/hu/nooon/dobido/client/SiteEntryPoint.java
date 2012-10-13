package hu.nooon.dobido.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import hu.nooon.dobido.client.resource.SiteClientBundle;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Point;


public class SiteEntryPoint implements EntryPoint {

    private Paper paper;

    private final String bkgColor = "#552e2b";
    private static final int canvasWidth = 1050;
    private static final int canvasHeight = 1024;

    private final Attrs font1 =
            Attrs.create().fontFamily("Spicy Rice, cursive").fontSize(20).fill("black").textAnchor("start");

    private final Attrs font2 =
            Attrs.create().fontFamily("Love Ya Like A Sister, cursive").fontSize(20).fill("black").textAnchor("end");

    private final Attrs font3 =
            Attrs.create().fontFamily("Love Ya Like A Sister, cursive").fontSize(20).fill("black").textAnchor("start");

    public void onModuleLoad() {

        // NONE OF YOUR CONCERN :)
        initRaphael();

        // BACKGROUND
        Shape whiteBkg = paper.rect(Raphael.createRectangle(100, 100, 936, 674), 10).attr(Attrs.create().fill("white").strokeWidth(0));


        // WEBSHOP TEXT
        Shape webShopTxt = paper.text(110, 120, "WEBSHOP").attr(font1);


        // MENU 1
        Point menuPoint = Raphael.createPoint(80, 140);


        Shape menu1Bkg = paper.rect(Raphael.createRectangle((int)menuPoint.getX(), (int)menuPoint.getY(), 194, 40), 10)
                .attr(Attrs.create().fill("gray").strokeWidth(0));



        Shape menu1Txt = paper.text((int)menuPoint.getX() + 194, (int)menuPoint.getY() + 20, "termèkek").attr(font2);



        Shape item1Frame = paper.rect(Raphael.createRectangle(300, 140, 194, 40), 10).attr(Attrs.create().stroke("gray").strokeWidth(.5));


    }

    private void initRaphael() {
        Document.get().getBody().getStyle().setMargin(0, Style.Unit.PX);
        Document.get().getBody().getStyle().setBackgroundColor(bkgColor);
        DivElement divElement = Document.get().createDivElement();
        Document.get().getBody().appendChild(divElement);
        divElement.getStyle().setProperty("margin", "0px auto");
        paper = Raphael.paper(divElement, canvasWidth, canvasHeight);
    }


}

