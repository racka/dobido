package hu.nooon.dobido.server.rpc;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.drive.Drive;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import hu.nooon.dobido.client.rpc.DriveServlet;
import hu.nooon.dobido.server.drive.MyGoogleDrive;

import java.io.IOException;

public class DriveServletImpl extends RemoteServiceServlet implements DriveServlet {

    public static final String CLIENT_SECRETS_FILE_PATH
            = "/WEB-INF/client_secrets.json";


    @Override
    public String listFiles(String user) {

        try {
            Credential credential = MyGoogleDrive.buildEmptyCredential(
                    getServletContext().getResourceAsStream(CLIENT_SECRETS_FILE_PATH)
            );
            Drive drive = MyGoogleDrive.buildService((GoogleCredential) credential);

            return MyGoogleDrive.getFileNames(drive);

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return "...";
    }
}
