package hu.nooon.dobido.client.widgets;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ImageResource;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.Callback;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MitsouGallery implements CustomLayer {

    private Paper paper;
    private List<FadedObject> thumbnails;
    private final Set thumbnailSet;
    private List<ImageResource> imgs;
    private Map<Integer, Shape> images;
    private Shape actualImage;
    private Shape thumbFrame;
    private int x, y, width, height;

    public MitsouGallery(Paper paper, List<ImageResource> imgs, List<ImageResource> thumbnails,
                         final int x, final int y, final int width, final int height,
                         final int thumbWidth, int thumbHeight) {

        this.paper = paper;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.imgs = imgs;
        this.images = new HashMap<Integer, Shape>();
        this.thumbnailSet = paper.set();
        this.thumbnails = new ArrayList<FadedObject>();
        int thumbY = (2 * height) / 3;

        int count = 0;
        for (ImageResource thumb : thumbnails) {
            Shape thumbImage = paper.image(thumb, x + count * thumbWidth, thumbY, thumbWidth, thumbHeight);
            FadedObject thumbnail = new FadedObject(thumbImage, .3);
            this.thumbnails.add(thumbnail);
            this.thumbnailSet.push(thumbImage);

            final int actualCount = count;
            thumbImage.click(new MouseEventListener() {
                @Override
                public void notifyMouseEvent(NativeEvent nativeEvent) {
                    Shape newImage = getImage(actualCount);
                    showNewShape(actualImage, newImage);
                    actualImage = newImage;
                }
            });

            count++;
        }

        if (count > 0) {
            thumbFrame = paper.rect(x, thumbY, width, thumbHeight);
            thumbFrame.attr(Attrs.create().stroke("white").strokeWidth(3));
        }

        thumbnailSet.toFront();
        final int sumWidth = thumbWidth * thumbnails.size();
        final int maxDelta = sumWidth - width;
        this.thumbnailSet.mouseMove(new MouseEventListener() {
            @Override
            public void notifyMouseEvent(NativeEvent nativeEvent) {
                int deltaX = (int) Math.floor(maxDelta * ((double) (nativeEvent.getClientX() - x) / (double) (width)));

                for (int i = 0; i < thumbnailSet.size(); i++) {
                    thumbnailSet.item(i).attr(Attrs.create().x(x - deltaX + i * thumbWidth));
                }

            }
        });
    }

    private Shape getImage(int index) {

        if (!images.containsKey(index)) {
            ImageResource img = imgs.get(index);
            Shape image = paper.image(img,
                    x + ((width - img.getWidth())/2),
                    y, // + ((height - img.getHeight())/2),
                    img.getWidth(), img.getHeight());
            image.attr(Attrs.create().opacity(0)).hide();
            images.put(index, image);
        }

        return images.get(index);
    }

    private void showNewShape(final Shape obsoleteShape, final Shape actualShape) {
        if (obsoleteShape != null) {
            obsoleteShape.stop();
            obsoleteShape.animate(
                    Raphael.animation(Attrs.create().opacity(0), 200, Raphael.EASING_LINEAR,
                            new Callback() {
                                @Override
                                public void call(Shape shape) {
                                    actualShape.toBack().show().animate(Raphael.animation(
                                            Attrs.create().opacity(1), 200, Raphael.EASING_LINEAR));
                                }
                            }).delay(getRandom(500)));
        } else {
            actualShape.toBack().show().animate(Raphael.animation(
                    Attrs.create().opacity(1),
                    200, Raphael.EASING_LINEAR).delay(getRandom(500)));
        }
    }

    private int getRandom(int max) {
        int nextRandom = (int) Math.floor(com.google.gwt.user.client.Random.nextDouble() * max);
        return nextRandom != 0 ? nextRandom : max;
    }

    @Override
    public CustomLayer clear() {
        return this;
    }

    @Override
    public CustomLayer show(boolean animated) {
        thumbnailSet.show().toFront();
        return this;
    }

    @Override
    public CustomLayer hide(boolean animated) {
        actualImage.toBack().hide();
        thumbnailSet.toBack().hide();
        thumbFrame.toBack().hide();
        return this;
    }

    @Override
    public CustomLayer removeShape(int index, boolean animated) {
        return this;
    }
}
