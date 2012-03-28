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
import org.sgx.raphael4gwt.raphael.event.HoverListener;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

public class Dobido implements EntryPoint {


    public void onModuleLoad() {

        // INIT
        Document.get().getBody().getStyle().setMargin(0, Style.Unit.PX);
        DivElement divElement = Document.get().createDivElement();
        Document.get().getBody().appendChild(divElement);
        Paper paper = Raphael.paper(divElement, 1024, 768);

        createHeader(paper);
        createSleepy(paper);
        createTravel(paper);
        createCarry(paper);
    }


    // ------------------------------------
    // COMMON
    // ------------------------------------
    private final Attrs imageBkgAttrs = (Attrs) JsUtil.obj(
            "fill", "#FFFFFF",
            "stroke-width", "0"
    );
    private final Attrs normalTextAttrs = (Attrs) JsUtil.obj(
            "font-size", "30em",
            "font-family", "Advent Pro, cursive"
    );
    private final Attrs normalText2Attrs = (Attrs) JsUtil.obj(
            "font-size", "20em",
            "font-family", "Advent Pro, cursive"
    );

    private Attrs disappear = (Attrs) JsUtil.obj(
            "opacity", "0"
    );

    private Attrs transparent = (Attrs) JsUtil.obj(
            "opacity", "0.5"
    );

    private Attrs appear = (Attrs) JsUtil.obj(
            "opacity", "1"
    );

    private final Animation fadeAwayAnimation = Raphael.animation(disappear, 200, Raphael.EASING_LINEAR, new Callback() {
        public void call() {

        }
    });
    private final Animation fadeToTransparentAnimation = Raphael.animation(transparent, 500, Raphael.EASING_LINEAR, new Callback() {
        public void call() {

        }
    });
    private final Animation fadeToNormalAnimation = Raphael.animation(appear, 500, Raphael.EASING_LINEAR, new Callback() {
        public void call() {

        }
    });


    // ------------------------------------
    // HEADER
    // ------------------------------------

    private Path headerPatch;
    private Path headerPatch2;
    private final Attrs headerPatchAttrs = (Attrs) JsUtil.obj(
            "opacity", "1",
            "fill", "#9a9a9a",
            "stroke-width", "0"
    );

    private Text headerText;
    private final Attrs headerTextAttrs = (Attrs) JsUtil.obj(
            "font-size", "40em",
            "font-family", "Advent Pro, cursive"
    );

    private void createHeader(Paper paper) {
        headerPatch = paper.path("M 18, 8 H 366 q 10, 0, 10, 10 V 110 q 0, 10, -10, 10 H 18 q -10, 0, -10, -10 V 18 q 0, -10, 10, -10 z");
        headerPatch.attr(headerPatchAttrs);
        headerPatch2 = paper.path("M 402, 8 H 1006 q 10, 0, 10, 10 V 110 q 0, 10, -10, 10 H 402 q -10, 0, -10, -10 V 18 q 0, -10, 10, -10 z");
        headerPatch2.attr(headerPatchAttrs);


        headerText = paper.text(455, 50, "hírek");
        headerText.attr(headerTextAttrs);
    }


    // ------------------------------------
    // SLEEP
    // ------------------------------------

    private Path sleepyPatch;
    private final Attrs sleepyAttrs = (Attrs) JsUtil.obj(
            "opacity", "1",
            "fill", "#c5e773",
            "stroke-width", "0"
    );

    private Path sleepyImageBkg1;
    private Path sleepyImageBkg2;

    private Text sleepyText;
    private Text sleepyText2;
    private Text sleepyText3;

    private Set sleepy;

    private void createSleepy(Paper paper) {
        sleepyPatch = paper.path("M 18, 136 H 494 q 10, 0, 10, 10 V 377 q 0, 10, -10, 10 H 258 q -10, 0, -10, 10 V 462 q 0, 10, -10, 10 H 18 q -10, 0, -10, -10 V 146 q 0, -10, 10, -10 z");
        sleepyPatch.attr(sleepyAttrs);
        sleepyText = paper.text(75, 180, "altatás");
        sleepyText.attr(normalTextAttrs);

        sleepyImageBkg1 = paper.path("M 36, 241 H 222 q 10, 0, 10, 10 V 412 q 0, 10, -10, 10 H 36 q -10, 0, -10, -10 V 251 q 0, -10, 10, -10 z");
        sleepyImageBkg1.attr(imageBkgAttrs);
        sleepyText2 = paper.text(186, 432, "hálózsák");
        sleepyText2.attr(normalText2Attrs);

        sleepyImageBkg2 = paper.path("M 290, 158 H 476 q 10, 0, 10, 10 V 328 q 0, 10, -10, 10 H 290 q -10, 0, -10, -10 V 168 q 0, -10, 10, -10 z");
        sleepyImageBkg2.attr(imageBkgAttrs);
        sleepyText3 = paper.text(439, 348, "babazsák");
        sleepyText3.attr(normalText2Attrs);


        sleepy = paper.set();
        sleepy.push(sleepyPatch);
        sleepy.push(sleepyText);
        sleepy.push(sleepyImageBkg1);
        sleepy.push(sleepyText2);
        sleepy.push(sleepyImageBkg2);
        sleepy.push(sleepyText3);

        sleepy.hover(new HoverListener() {
            public void hoverIn(NativeEvent nativeEvent) {
                carry.animate(fadeToTransparentAnimation);
                travel.animate(fadeToTransparentAnimation);
            }

            public void hoverOut(NativeEvent nativeEvent) {
                carry.animate(fadeToNormalAnimation);
                travel.animate(fadeToNormalAnimation);
            }
        });

    }


    // ------------------------------------
    // TRAVEL
    // ------------------------------------

    private Path travelPatch;
    private final Attrs travelPatchAttrs = (Attrs) JsUtil.obj(
            "opacity", "1",
            "fill", "#eface6",
            "stroke-width", 0
    );
    private Text travelText;
    private Text travelText2;
    private Text travelText3;

    private Path travelImageBkg1;
    private Path travelImageBkg2;

    private Set travel;


    private void createTravel(Paper paper) {

        travelPatch = paper.path("M 18, 488 H 254 q 10, 0, 10, -10, V 413 q 0, -10, 10, -10 H 494 q 10, 0, 10, 10 V 717 q 0, 10, -10, 10 H 18 q -10, 0, -10, -10 V 498 q 0, -10, 10, -10 z");
        travelPatch.attr(travelPatchAttrs);
        travelText = paper.text(436, 450, "utazás");
        travelText.attr(normalTextAttrs);

        travelImageBkg1 = paper.path("M 36, 505 H 222 q 10, 0, 10, 10 V 675 q 0, 10, -10, 10 H 36 q -10, 0, -10, -10 V 515 q 0, -10, 10, -10 z");
        travelImageBkg1.attr(imageBkgAttrs);
        travelText2 = paper.text(174, 695, "szopikendő");
        travelText2.attr(normalText2Attrs);

        travelImageBkg2 = paper.path("M 290, 505 H 476 q 10, 0, 10, 10 V 675 q 0, 10, -10, 10 H 290 q -10, 0, -10, -10 V 515 q 0, -10, 10, -10 z");
        travelImageBkg2.attr(imageBkgAttrs);
        travelText3 = paper.text(414, 695, "hordozótakaró");
        travelText3.attr(normalText2Attrs);

        travel = paper.set();
        travel.push(travelPatch);
        travel.push(travelText);
        travel.push(travelImageBkg1);
        travel.push(travelText2);
        travel.push(travelImageBkg2);
        travel.push(travelText3);

        travel.hover(new HoverListener() {
            public void hoverIn(NativeEvent nativeEvent) {
                sleepy.animate(fadeToTransparentAnimation);
                carry.animate(fadeToTransparentAnimation);
            }

            public void hoverOut(NativeEvent nativeEvent) {
                sleepy.animate(fadeToNormalAnimation);
                carry.animate(fadeToNormalAnimation);
            }
        });

    }


    // ------------------------------------
    // CARRY
    // ------------------------------------

    private Text carryText;
    private Text carryText2;
    private Text carryText3;
    private Text carryText4;

    private Path carryImageBkg1;
    private Path carryImageBkg2;
    private Path carryImageBkg3;

    private Path carryPatch;
    private final Attrs carryPatchAttrs = (Attrs) JsUtil.obj(
            "opacity", "1",
            "fill", "#60c2cd",
            "stroke-width", "0"
    );

    private Set carry;


    private void createCarry(Paper paper) {

        carryPatch = paper.path("M 530, 136 H 1006 q 10, 0, 10, 10 V 606 q 0, 10, -10, 10 H 786 q -10, 0, -10, -10 V 482 q 0, -10, -10, -10, H 530 q -10, 0, -10, -10 V 146 q 0, -10, 10, -10 z");
        carryPatch.attr(carryPatchAttrs);
        carryText = paper.text(600, 180, "hordozás");
        carryText.attr(normalTextAttrs);

        carryImageBkg1 = paper.path("M 548, 241 H 733 q 10, 0, 10, 10 V 412 q 0, 10, -10, 10 H 548 q -10, 0, -10, -10 V 251 q 0, -10, 10, -10 z");
        carryImageBkg1.attr(imageBkgAttrs);
        carryText2 = paper.text(646, 432, "állítható bababugyor");
        carryText2.attr(normalText2Attrs);

        carryImageBkg2 = paper.path("M 802, 158 H 988 q 10, 0, 10, 10 V 328 q 0, 10, -10, 10 H 802 q -10, 0, -10, -10 V 168 q 0, -10, 10, -10 z");
        carryImageBkg2.attr(imageBkgAttrs);
        carryText3 = paper.text(966, 348, "mai tei");
        carryText3.attr(normalText2Attrs);

        carryImageBkg3 = paper.path("M 802, 387 H 988 q 10, 0, 10, 10 V 557 q 0, 10, -10, 10 H 802 q -10, 0, -10, -10 V 397 q 0, -10, 10, -10 z");
        carryImageBkg3.attr(imageBkgAttrs);
        carryText4 = paper.text(924, 577, "csatos hordozó");
        carryText4.attr(normalText2Attrs);

        carry = paper.set();
        carry.push(carryPatch);
        carry.push(carryText);
        carry.push(carryImageBkg1);
        carry.push(carryText2);
        carry.push(carryImageBkg2);
        carry.push(carryText3);
        carry.push(carryImageBkg3);
        carry.push(carryText4);


        carry.hover(new HoverListener() {
            public void hoverIn(NativeEvent nativeEvent) {
                sleepy.animate(fadeToTransparentAnimation);
                travel.animate(fadeToTransparentAnimation);
            }

            public void hoverOut(NativeEvent nativeEvent) {
                sleepy.animate(fadeToNormalAnimation);
                travel.animate(fadeToNormalAnimation);
            }
        });

    }

}