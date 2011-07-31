package hu.nooon.dobido.client.home.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.ui.Widget;

public interface LoginEventHandler extends EventHandler {

    void login(Widget loginButton, String userName, String password);

}
