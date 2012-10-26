package hu.nooon.dobido.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("googledrive")
public interface DriveServlet extends RemoteService {

    String listFiles(String user);

}
