package hu.nooon.dobido.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DriveServletAsync {

    void listFiles(String user, AsyncCallback<String> callback);
}
