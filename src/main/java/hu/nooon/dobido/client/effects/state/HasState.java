package hu.nooon.dobido.client.effects.state;

public interface HasState {

    WebComponentState getState();
    void setState(WebComponentState newState);

}
