package hu.nooon.dobido.client.effects.animation.impl;


import com.google.gwt.user.client.ui.Widget;
import hu.nooon.dobido.client.effects.animation.SiteAnimation;
import hu.nooon.dobido.client.effects.sitecallback.SiteCallback;

public class FadeInAnimation extends SiteAnimation {

    private double firstThreshold;

    public FadeInAnimation(Widget target, SiteCallback callback, int duration) {
        super(target, callback, duration);
        this.firstThreshold = 1;
    }

    public FadeInAnimation(Widget target, double firstThreshold, SiteCallback callback, int duration) {
        super(target, callback, duration);
        this.firstThreshold = firstThreshold;
    }

    @Override
    public void animationLogic(double progress) {
        double fineTune = this.interpolate(progress);

        if (fineTune <= firstThreshold) {
            target.getElement().getStyle().setOpacity(fineTune);
        }
    }
}
