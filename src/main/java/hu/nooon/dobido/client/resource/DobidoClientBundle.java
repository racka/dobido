package hu.nooon.dobido.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface DobidoClientBundle extends ClientBundle {

    public static final DobidoClientBundle INSTANCE =  GWT.create(DobidoClientBundle.class);

    @Source("hu/nooon/dobido/public/stylesheets/constants.css")
    MusicSiteStyleSheet constantsCSS();

    @Source("hu/nooon/dobido/public/images/dobido_logo.png")
    ImageResource logo();

    @Source("hu/nooon/dobido/public/images/dobido_products.png")
    ImageResource products();

    @Source("hu/nooon/dobido/public/images/dobido_menu.png")
    ImageResource menu();


}
