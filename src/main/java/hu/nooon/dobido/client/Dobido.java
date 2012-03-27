package hu.nooon.dobido.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style;
import org.sgx.raphael4gwt.raphael.*;
import org.sgx.raphael4gwt.raphael.base.Animation;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.Callback;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

public class Dobido implements EntryPoint {

    public void onModuleLoad() {

        // INIT
        Document.get().getBody().getStyle().setMargin(0, Style.Unit.PX);
        DivElement divElement = Document.get().createDivElement();
        Document.get().getBody().appendChild(divElement);
        Paper paper = Raphael.paper(divElement, 1024, 700);

        // ATTRS
        Attrs textAttrs = (Attrs) JsUtil.obj(
                "font-size", "30em",
                "font-family", "Emblema One, cursive"
        );
        Attrs travelAttrs = (Attrs) JsUtil.obj(
                "fill", "#E900B2",
                "stroke", "#E900B2",
                "stroke-width", "20",
                "stroke-linejoin", "round"
        );


        Path travelPath = paper.path("M 10, 370 H 270 V 320 H 500 V 600 H 10 V 370 z");
        travelPath.attr(travelAttrs);
        Text travelText = paper.text(390, 350, "TRAVEL");
        travelText.attr(textAttrs);

        final Set travel = paper.set();
        travel.push(travelPath);
        travel.push(travelText);

        Attrs future1 = (Attrs) JsUtil.obj(
                "fill", "green",
                "transform", "t400,400,s4.0,4.0"
        );


        final Animation animation = Raphael.animation(future1, 2000, Raphael.EASING_BOUNCE, new Callback() {
            public void call() {

            }
        });

        travel.click(new MouseEventListener() {
            public void notifyMouseEvent(NativeEvent nativeEvent) {
                travel.animate(animation);
            }
        });

    }
}