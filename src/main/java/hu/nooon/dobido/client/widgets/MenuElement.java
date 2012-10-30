package hu.nooon.dobido.client.widgets;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.*;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import hu.nooon.dobido.client.rpc.DriveServlet;
import hu.nooon.dobido.client.rpc.DriveServletAsync;

public class MenuElement extends Composite {

    interface MyUIBinder extends UiBinder<Widget, MenuElement> {}
    private static MyUIBinder uiBinder = GWT.create(MyUIBinder.class);

    private DriveServletAsync drive = (DriveServletAsync) GWT.create(DriveServlet.class);

    @UiField(provided = true)
    public Label xLabel;

    @UiField(provided = true)
    public Label yLabel;

    @UiField
    public HTMLPanel panel;

    public MenuElement(int x, int y) {
        xLabel = new Label("X: " + x);
        yLabel = new Label("Y: " + y);
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("xLabel")
    void handleClick(ClickEvent e) {

        String URL = Window.Location.getProtocol() + "//" + Window.Location.getHost() + "/dobido/googledrive";
//        xLabel.setText(URL);
        panel.add(new HTML("<img src=\"" + URL + "\" />"));


//        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, URL);
//        requestBuilder.setCallback(new RequestCallback() {
//            @Override
//            public void onResponseReceived(Request request, Response response) {
//
//                panel.add(new HTML("<img src=\"" + response.getText() + "\" />"));
//
//            }
//
//            @Override
//            public void onError(Request request, Throwable exception) {
//                //To change body of implemented methods use File | Settings | File Templates.
//            }
//        });
//
//        try {
//            requestBuilder.send();
//        } catch (RequestException e1) {
//            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }


//
//        drive.listFiles("", new AsyncCallback<String>() {
//            @Override
//            public void onFailure(Throwable caught) {
//            }
//
//            @Override
//            public void onSuccess(String result) {
//                xLabel.setText(result);
//            }
//        });

    }

}
