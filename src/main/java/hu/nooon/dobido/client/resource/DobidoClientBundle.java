package hu.nooon.dobido.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface DobidoClientBundle extends ClientBundle {

    public static final DobidoClientBundle INSTANCE =  GWT.create(DobidoClientBundle.class);

}
