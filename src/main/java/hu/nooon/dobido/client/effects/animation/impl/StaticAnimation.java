package hu.nooon.dobido.client.effects.animation.impl;


import hu.nooon.dobido.client.effects.animation.SiteAnimation;
import hu.nooon.dobido.client.effects.sitecallback.SiteCallback;

public class StaticAnimation extends SiteAnimation {

    private SiteCallback staticCallback;
    public StaticAnimation(SiteCallback callback) {
        super(null, null, callback, 1);
        this.staticCallback = callback;
    }

    private boolean done = false;

    @Override
    public void animationLogic(double progress) {
        if (!done) {
            done = true;
            staticCallback.callback();
        }
    }
}
