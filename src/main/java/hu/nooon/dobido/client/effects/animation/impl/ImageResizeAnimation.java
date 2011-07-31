package hu.nooon.dobido.client.effects.animation.impl;


import com.google.gwt.user.client.ui.Image;
import hu.nooon.dobido.client.effects.animation.SiteAnimation;
import hu.nooon.dobido.client.effects.sitecallback.SiteCallback;

public class ImageResizeAnimation extends SiteAnimation {

    private int startWidth;
    private int startHeight;
    private int targetWidth;
    private int targetHeight;

    public ImageResizeAnimation(Image target, SiteCallback callback, int duration,
                                int targetWidth, int targetHeight) {
        super(null, target, callback, duration);
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;

        startWidth = target.getWidth();
        startHeight = target.getHeight();
    }

    @Override
    public void animationLogic(double progress) {
        double fineTune = this.interpolate(progress);

        target.setPixelSize(startWidth + (int)(fineTune * (targetWidth - startWidth)),
                startHeight + (int)(fineTune * (targetHeight - startHeight)));
    }
}
