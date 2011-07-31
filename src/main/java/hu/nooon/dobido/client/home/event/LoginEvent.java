package hu.nooon.dobido.client.home.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.Widget;

public class LoginEvent extends GwtEvent<LoginEventHandler> {

    public static Type<LoginEventHandler> TYPE = new Type<LoginEventHandler>();
    private Widget loginButton;
    private String userName, password;

    public LoginEvent(Widget loginButton, String userName, String password) {
        this.loginButton = loginButton;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Type<LoginEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(LoginEventHandler handler) {
        handler.login(loginButton, userName, password);
    }
}
