package hu.nooon.dobido.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface SiteClientBundle extends ClientBundle {

    public static final SiteClientBundle INSTANCE =  GWT.create(SiteClientBundle.class);

    @ClientBundle.Source("hu/nooon/dobido/public/site_structure.txt")
    public TextResource structure();

}
