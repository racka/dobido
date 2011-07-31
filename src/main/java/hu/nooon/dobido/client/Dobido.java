package hu.nooon.dobido.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import hu.nooon.dobido.client.gin.DobidoGinjector;

public class Dobido implements EntryPoint {

	public void onModuleLoad() {

        DobidoGinjector injector = GWT.create(DobidoGinjector.class);
        RootPanel.get().add(injector.getHome());
    }
}