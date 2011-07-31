package hu.nooon.dobido.client.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Composite;
import com.google.inject.Inject;
import hu.nooon.dobido.client.effects.animation.SiteAnimation;
import hu.nooon.dobido.client.effects.animation.impl.ScrollAnimation;
import hu.nooon.dobido.client.effects.sitecallback.SiteCallback;
import hu.nooon.dobido.client.home.constants.HomeConstants;
import hu.nooon.dobido.client.resource.DobidoClientBundle;
import hu.nooon.dobido.client.resource.MusicSiteStyleSheet;

public class Home extends Composite {

    /**
     * a deklarativ elrendezeshez a tipus
     */
    interface HomeUIBinder extends UiBinder<Widget, Home> {
    }

    /**
     * a deklarativ elrendezes peldanya (GWT - UIBinder)
     */
    private static HomeUIBinder uiBinder = GWT.create(HomeUIBinder.class);

    /**
     * faluleti stilus konstansokat tartalmazo inline css
     */
    private final MusicSiteStyleSheet CSS = DobidoClientBundle.INSTANCE.constantsCSS();

	private static final HomeConstants homeConstants = GWT.create(HomeConstants.class);

    @Inject
    private EventBus eventBus;


    @UiField
    public AbsolutePanel application;
    @UiField
    public Image logoImage;
    @UiField
    public Image menuImage;
    @UiField
    public Image productsImage;

    public Home() {
        initWidget(uiBinder.createAndBindUi(this));
    }



    @Override
    protected void onLoad() {

        application.setSize("100%", "100%");



    }


//    private void menuQueue() {
//
//        SiteAnimationQueue queue = new SiteAnimationQueue(
//                menuScrollAnimation(menuGallery, -100, -100, 100, 100, 500),
//                menuScrollAnimation(menuBio, 100, -100, 600, 200, 700),
//                menuScrollAnimation(menuMedia, 300, -100, 10, 300, 900),
//                menuScrollAnimation(menuNews, Window.getClientWidth(), -100, 200, 500, 500));
//
//        queue.start();
//    }

    private SiteAnimation menuScrollAnimation(Widget item, int fromX, int fromY, int toX, int toY, int duration) {

        application.setWidgetPosition(item, fromX, fromY);

        return new ScrollAnimation(application, item,
                new SiteCallback() {
                    public void callback() {
                    }
                }, duration, toX, toY);
    }


//    private void bindEvents() {
//
//        eventBus.addHandler(LoginEvent.TYPE, new LoginEventHandler() {
//            @Override
//            public void login(final Widget loginButton, String userName, String password) {
//
//            }
//        });
//
//        eventBus.addHandler(LogoutEvent.TYPE, new LogoutEventHandler() {
//            @Override
//            public void logout() {
//
//            }
//        });
//    }
//

}
