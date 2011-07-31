package hu.nooon.dobido.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import hu.nooon.dobido.client.home.Home;

@GinModules(DobidoGinModule.class)
public interface DobidoGinjector extends Ginjector {
    Home getHome();
}
