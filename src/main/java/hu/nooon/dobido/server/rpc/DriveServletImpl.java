package hu.nooon.dobido.server.rpc;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import hu.nooon.dobido.client.rpc.DriveServlet;
import hu.nooon.dobido.server.drive.CredentialMediator;
import hu.nooon.dobido.server.drive.DrEditServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DriveServletImpl extends DrEditServlet implements DriveServlet {


    @Override
    public String listFiles(String user) {

        try {
            HttpServletRequest request = getThreadLocalRequest();
            request.getSession().setAttribute(CredentialMediator.USER_ID_KEY, "74120609504.apps.googleusercontent.com");
            request.getSession().setAttribute(CredentialMediator.EMAIL_KEY, "74120609504@developer.gserviceaccount.com");


            Drive drive = getDriveService(getThreadLocalRequest(), getThreadLocalResponse());
            return getFileNames(drive);

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return "...";
    }

    /**
     * Build and return a Drive service object based on given request parameters.
     *
     * @param req Request to use to fetch code parameter or accessToken session
     *            attribute.
     * @param resp HTTP response to use for redirecting for authorization if
     *             needed.
     * @return Drive service object that is ready to make requests, or null if
     *         there was a problem.
     */
    private Drive getDriveService(HttpServletRequest req,
                                  HttpServletResponse resp) {
        Credential credentials = getCredential(req, resp);

        return new Drive.Builder(TRANSPORT, JSON_FACTORY, credentials).build();
    }


    private String getFileNames(Drive service) throws IOException {

        List<File> files = retrieveAllFiles(service);
        if (files.isEmpty()) {
            return "No info";
        }

        StringBuilder result = new StringBuilder("");

        for (File file : files) {
            result.append(file.getOriginalFilename());
        }

        return result.toString();
    }

    /**
     * Retrieve a list of File resources.
     *
     * @param service Drive API service instance.
     * @return List of File resources.
     */
    private static List<File> retrieveAllFiles(Drive service) throws IOException {
        List<File> result = new ArrayList<File>();
        Drive.Files.List request = service.files().list();

        do {
            try {
                FileList files = request.execute();

                result.addAll(files.getItems());
                request.setPageToken(files.getNextPageToken());
            } catch (IOException e) {
                System.out.println("An error occurred: " + e);
                request.setPageToken(null);
            }
        } while (request.getPageToken() != null &&
                request.getPageToken().length() > 0);

        return result;
    }


}
