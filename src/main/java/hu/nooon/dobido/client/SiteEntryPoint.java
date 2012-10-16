package hu.nooon.dobido.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import hu.nooon.dobido.client.database.MyRequestFactory;
import hu.nooon.dobido.client.database.stub.DummyProxy;
import hu.nooon.dobido.client.database.stub.DummyRequest;
import hu.nooon.dobido.client.widgets.MenuGrid;
import hu.nooon.dobido.client.widgets.PicText;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;


public class SiteEntryPoint implements EntryPoint {


    private final EventBus eventBus = new SimpleEventBus();
    private MyRequestFactory requestFactory;


    private Paper paper;

    private final String bkgColor = "#552e2b";
    private static final int canvasWidth = 860;
    private static final int canvasHeight = 1024;

    private final Attrs fontlogo =
            Attrs.create().fontFamily("BlockheadUnplugged, cursive").fontWeight("bold").fontSize(30).fill("black").textAnchor("start");

    int font1size = 16;
    private final Attrs font1 =
            Attrs.create().fontFamily("Advent Pro, cursive").fontSize(font1size).fill("black").textAnchor("end");

    int font2size = 20;
    private final Attrs font2 =
            Attrs.create().fontFamily("Advent Pro, cursive").fontSize(font2size).fill("black").textAnchor("end");

    int font3size = 16;
    private final Attrs font3 =
            Attrs.create().fontFamily("Love Ya Like A Sister, cursive").fontSize(font3size).fill("black").textAnchor("start");

    private final Attrs frameAttr = Attrs.create().stroke("gray").strokeWidth(.5);

    private MenuGrid clientGrid;

    public void onModuleLoad() {

        requestFactory = GWT.create(MyRequestFactory.class);
        requestFactory.initialize(eventBus);


        // NONE OF YOUR CONCERN :)
        initRaphael();

        // PROPERTIES

        Point startPoint = Raphael.createPoint(0, 100);

        int cornerround = 12;
        int menuSpacing = 8;
        int bigspaceX = 24;
        int linespacingX = 8;
        int linespacingY = 4;

        int menuboxX = 180;

        int menuItemWidth = 200;
        int menuItemHeight = 200;
        int picSpacingX = 16;
        int picSpacingY = 16;

        // LOGO

        Shape logoTxt = paper.text(420, 80, "... így babának lenni jó!").attr(fontlogo);


        // BACKGROUND
        int whitebkgX = menuboxX + menuItemWidth * 3 + picSpacingX * 2 + bigspaceX;
        int whitebkgY = font1size + menuSpacing * 2 + font2size + linespacingY + menuItemHeight * 2 + picSpacingY * 3;
        Shape whiteBkg = paper.rect(Raphael.createRectangle((int) startPoint.getX() + bigspaceX, (int) startPoint.getY(), whitebkgX, whitebkgY), cornerround).attr(Attrs.create().fill("white").strokeWidth(0));


        // HEADING

        Shape headingBkg = paper.rect(Raphael.createRectangle(300, (int) startPoint.getY() + font1size + menuSpacing, 444, font2size + menuSpacing + linespacingY), cornerround)
                .attr(Attrs.create().fill("gray").strokeWidth(0));


        // MENU

        Point menuPoint = Raphael.createPoint(0, (int) startPoint.getY() + menuSpacing * 3 + font1size + (int) headingBkg.getBBox().getHeight());

        int firstline1 = 15;
        int firstline2 = 40;

        // WEBSHOP TEXT

        Shape webShopTxt = paper.text((int) startPoint.getX() + menuboxX - linespacingX, (int) startPoint.getY() + font1size, "webshop").attr(font1);


        // MENU 1 Termekek
        int menu1Y = font2size + menuSpacing + linespacingY;

        Shape menu1Bkg = paper.rect(Raphael.createRectangle((int) menuPoint.getX(), (int) menuPoint.getY(), menuboxX, menu1Y), cornerround)
                .attr(Attrs.create().fill("gray").strokeWidth(0));

        Shape menu1Txt = paper.text((int) menuPoint.getX() + menuboxX - linespacingX, (int) menuPoint.getY() + firstline1, "termèkek").attr(font2);

        Set menu1 = paper.set().push(menu1Bkg).push(menu1Txt);

        menu1.click(new MouseEventListener() {
            @Override
            public void notifyMouseEvent(NativeEvent nativeEvent) {
                DummyRequest request = requestFactory.dummyRequest();
                DummyProxy newDummy = request.create(DummyProxy.class);
                newDummy.setName("Ez");
                Request<Void> createReq = request.persist().using(newDummy);
                createReq.fire(new Receiver<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        paper.text(10, 10, "SIKER");
                    }
                });
            }
        });


        // MENU 2 Horodzas

        int menu2Y = (int) menuPoint.getY() + (int) menu1Bkg.getBBox().getHeight() + menuSpacing + linespacingY;

        Shape menu2Bkg = paper.rect(Raphael.createRectangle((int) menuPoint.getX(), menu2Y, menuboxX, firstline2 + font3size * 3 + linespacingY * 2), cornerround)
                .attr(Attrs.create().fill("blue").strokeWidth(0));

        Shape menu2aTxt = paper.text((int) menuPoint.getX() + menuboxX - linespacingX, menu2Y + firstline1, "hordozás").attr(font2);

        Shape menu2bTxt = paper.text((int) menuPoint.getX() + linespacingX, menu2Y + firstline2, "babaerszény/sling").attr(font3);
        Shape menu2cTxt = paper.text((int) menuPoint.getX() + linespacingX, menu2Y + firstline2 + font3size + linespacingY, "mei-tai - kétoldalú").attr(font3);
        Shape menu2dTxt = paper.text((int) menuPoint.getX() + linespacingX, menu2Y + firstline2 + font3size * 2 + linespacingY * 2, "mei-tai - duplamintás").attr(font3);

        menu2Bkg.click(new MouseEventListener() {
            @Override
            public void notifyMouseEvent(NativeEvent nativeEvent) {
                DummyRequest request = requestFactory.dummyRequest();

                Request<DummyProxy> findRequest = request.findByName("Ez");
                findRequest.fire(new Receiver<DummyProxy>() {
                    @Override
                    public void onSuccess(DummyProxy response) {
                        paper.text(100, 100, response.getName()).attr(font1);
                    }
                });
            }
        });


        // MENU 3 Altatas

        int menu3Y = (int) menuPoint.getY() + (int) menu1Bkg.getBBox().getHeight() + (int) menu2Bkg.getBBox().getHeight() + menuSpacing * 2 + linespacingY * 2;

        Shape menu3Bkg = paper.rect(Raphael.createRectangle((int) menuPoint.getX(), menu3Y, menuboxX, firstline2 + font3size * 2 + linespacingY), cornerround)
                .attr(Attrs.create().fill("blue").strokeWidth(0));

        Shape menu3aTxt = paper.text((int) menuPoint.getX() + menuboxX - linespacingX, menu3Y + firstline1, "altatás").attr(font2);

        Shape menu3bTxt = paper.text((int) menuPoint.getX() + linespacingX, menu3Y + firstline2, "babazsák").attr(font3);
        Shape menu3cTxt = paper.text((int) menuPoint.getX() + linespacingX, menu3Y + firstline2 + font3size + linespacingY, "hálózsák").attr(font3);


        // MENU 4 Utazas

        int menu4Y = (int) menuPoint.getY() + (int) menu1Bkg.getBBox().getHeight() + (int) menu2Bkg.getBBox().getHeight() + (int) menu3Bkg.getBBox().getHeight() + menuSpacing * 3 + linespacingY * 3;

        Shape menu4Bkg = paper.rect(Raphael.createRectangle((int) menuPoint.getX(), menu4Y, menuboxX, firstline2 + font3size), cornerround)
                .attr(Attrs.create().fill("blue").strokeWidth(0));

        Shape menu4aTxt = paper.text((int) menuPoint.getX() + menuboxX - linespacingX, menu4Y + firstline1, "utazás").attr(font2);

        Shape menu4bTxt = paper.text((int) menuPoint.getX() + linespacingX, menu4Y + firstline2, "szoptatóskendő").attr(font3);


        // --------------------- CLIENT ----------------------------------
        // CLIENT GRID
        clientGrid = new MenuGrid(menuboxX + bigspaceX, (int) menuPoint.getY(), 3, menuItemWidth, menuItemHeight, picSpacingX, picSpacingY);

        Shape tokimndegy =
                clientGrid.putJuciMenuItemToGrid(paper, 0, 0,
                        new PicText(menuItemWidth, menuItemHeight, 30, "Valami szoveg", Attrs.create().strokeWidth(0).fill("blue"), font3));


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

