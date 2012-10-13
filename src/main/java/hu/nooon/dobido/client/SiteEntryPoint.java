package hu.nooon.dobido.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.*;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import hu.nooon.dobido.client.event.AnimationEvent;
import hu.nooon.dobido.client.event.AnimationEventHandler;
import hu.nooon.dobido.client.event.DeferredLogicEvent;
import hu.nooon.dobido.client.event.DeferredLogicEventHandler;
import hu.nooon.dobido.client.resource.SiteClientBundle;
import hu.nooon.dobido.client.widgets.*;
import org.sgx.raphael4gwt.raphael.*;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.base.Rectangle;
import org.sgx.raphael4gwt.raphael.event.Callback;
import org.sgx.raphael4gwt.raphael.event.HoverListener;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class SiteEntryPoint implements EntryPoint {

    private SiteClientBundle clientBundle = SiteClientBundle.INSTANCE;
    private final EventBus eventBus = GWT.create(SimpleEventBus.class);



    private static final int tileWidth = 256;
    private static final int tileHeight = 225;
    private static final int thumbWidth = 128;
    private static final int thumbHeight = 113;

    private static final int titleHeight = 50;
    private static final int headerHeight = 50;
    private static final int footerHeight = 100;
    private static final int clientHeight = 4 * tileHeight;

    private static final int canvasWidth = 4 * tileWidth;
    private static final int canvasHeight = titleHeight + headerHeight + clientHeight + footerHeight;



    private final Attrs titleTextAttrs =
            Attrs.create().fontFamily("Permanent Marker, cursive").fontSize(40).fill("black").textAnchor("start");

    private DivElement divElement;
    private Paper paper;
    private CustomGrid clientGrid, menuGrid;
    private java.util.Set<Set> modifiedLayer, clonedLayer;
    private ImageRepository images;
    private SiteAudio audio;

    private Shape log;

    public void onModuleLoad() {

        Document.get().getBody().getStyle().setMargin(0, Style.Unit.PX);
        Document.get().getBody().getStyle().setBackgroundImage("url(" + clientBundle.background().getSafeUri().asString() + ")");
        divElement = Document.get().createDivElement();
        Document.get().getBody().appendChild(divElement);
        divElement.getStyle().setProperty("margin", "0px auto");

        eventBus.addHandler(AnimationEvent.TYPE, new AnimationEventHandler() {
            @Override
            public void animate(AnimationEvent event) {
                final List<FutureProxyShape> sequence = event.getSequence();
                if (!sequence.isEmpty()) {
                    Callback callback = sequence.size() > 1 ?
                            new Callback() {
                                @Override
                                public void call(Shape shape) {
                                    eventBus.fireEvent(new AnimationEvent(sequence.subList(1, sequence.size())));
                                }
                            } : null;

                    sequence.get(0).animate(callback);
                }
            }
        });

        eventBus.addHandler(DeferredLogicEvent.TYPE, new DeferredLogicEventHandler() {
            @Override
            public void defer(DeferredLogicEvent event) {
                event.getCallback().call(null);
            }
        });

        initRaphael(divElement);

        createTitle();

        createClient();

        createFooter();
    }

    private void initRaphael(DivElement divElement) {
        paper = Raphael.paper(divElement, 1024, 900);
        clonedLayer = new HashSet<Set>();
        modifiedLayer = new HashSet<Set>();
    }



    private Shape createTextLines(int x, int y, int lineHeight, String txt, Attrs textAttrs) {
        Set shape = paper.set();
        String[] lines = txt.split("\n");

        for (int i = 0; i < lines.length; i++) {
            shape.push(paper.text(x, y + i * lineHeight, lines[i]).attr(textAttrs));
        }

        return shape;
    }

    private Shape cloneSet(Set original) {
        Set result = paper.set();
        for (int i = 0; i < original.size(); i++) {
            result.push(original.item(i).clone());
        }

        return result;
    }

    private void createTitle() {

        Shape title = paper.text(100, 30, "FARKAS-JENSER BALÁZS ÉS ZENEKARA").attr(titleTextAttrs);
    }

    private MitsouGallery gallery;

    private MitsouGallery getGallery() {
        if (gallery == null) {
            gallery = new MitsouGallery(paper,
                    Arrays.<ImageResource>asList(null),
                    Arrays.<ImageResource>asList(null),
                    0, titleHeight + headerHeight, tileWidth * 4, clientHeight,
                    thumbWidth, thumbHeight);

        }
        return gallery;
    }

    private void hideGallery() {
        if (gallery != null) {
            gallery.hide(true);
        }
    }


    private void createClient() {
        Rectangle clientRectangle = Raphael.createRectangle(0, titleHeight + headerHeight, canvasWidth, clientHeight);
        Rect clientBkg = paper.rect(clientRectangle);
        clientBkg.attr(Attrs.create().strokeWidth(0));
        clientGrid = new CustomGrid(0, titleHeight + headerHeight, 4, 4, tileWidth, tileHeight);
    }


    private void createFooter() {
        Rectangle footerRectangle = Raphael.createRectangle(0, titleHeight + headerHeight + clientHeight, canvasWidth, footerHeight);
        Rect footerBkg = paper.rect(footerRectangle, 10);
        footerBkg.attr(Attrs.create().strokeWidth(0).fill("#CCC"));
    }


    public native void safari(Paper paper)/*-{
        paper.safari();
    }-*/;


    private void clearScreen() {
        clientGrid.clear();
        cleanLayers();
        hideGallery();
    }


    private void cleanLayers() {
        disposeClonedLayer();
        disposeModifiedLayer();
    }

    private void disposeClonedLayer() {
        for (final Set obsoleteShape : clonedLayer) {
            obsoleteShape.remove();
        }
        clonedLayer.clear();
    }

    private void disposeModifiedLayer() {
        for (final Set obsolete : modifiedLayer) {
            obsolete.stop().animate(Raphael.animation(Attrs.create().opacity(0), 1000, Raphael.EASING_LINEAR, new Callback() {
                @Override
                public void call(Shape shape) {
                    obsolete.hide();
                }
            })).toBack();
        }
        modifiedLayer.clear();
    }

}

