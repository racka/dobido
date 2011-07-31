package hu.nooon.dobido.client.effects.animation.impl;


import com.google.gwt.user.client.ui.Widget;
import hu.nooon.dobido.client.effects.animation.SiteAnimation;
import hu.nooon.dobido.client.effects.sitecallback.SiteCallback;

public class CrossFadeAnimation extends SiteAnimation {

    private Widget first;
    private Widget second;
    private double firstThreshold, secondThreshold;

    public CrossFadeAnimation(Widget first, Widget second, SiteCallback callback, int duration) {
        super(callback, duration);
        this.first = first;
        this.second = second;
    }

    public CrossFadeAnimation(Widget first, double firstThreshold, Widget second, double secondThreshold, SiteCallback callback, int duration) {
        super(callback, duration);
        this.first = first;
        this.firstThreshold = firstThreshold;
        this.second = second;
        this.secondThreshold = secondThreshold;
    }

    @Override
    public void animationLogic(double progress) {
        double fineTune = this.interpolate(progress);

        if (first != null && (1-fineTune) > firstThreshold) {
            first.getElement().getStyle().setOpacity(1 - fineTune);
        }
        if (second != null && fineTune < secondThreshold) {
            second.getElement().getStyle().setOpacity(fineTune);
        }
    }
}
