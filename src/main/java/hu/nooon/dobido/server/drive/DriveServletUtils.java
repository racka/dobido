package hu.nooon.dobido.server.drive;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.gwt.user.server.Base64Utils;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.*;

public abstract class DriveServletUtils extends HttpServlet {

    protected static final HttpTransport TRANSPORT = new NetHttpTransport();
    protected static final JsonFactory JSON_FACTORY = new JacksonFactory();

    private static final String SERVICE_ACCOUNT = "74120609504-riafge3nedeg0lig6shodjudr2j5bciq@developer.gserviceaccount.com";
    private static final String CERT_PATH = "/WEB-INF/pk.p12";
    private static final String CERT_PASS = "notasecret";


    protected Credential getCredential() throws IOException, KeyStoreException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException {

        java.security.KeyStore keyStore = java.security.KeyStore.getInstance("PKCS12");
        keyStore.load(getServletContext().getResourceAsStream(CERT_PATH), CERT_PASS.toCharArray());

        PrivateKey pk = null;
        for (Enumeration enumeration = keyStore.aliases(); enumeration.hasMoreElements(); ) {
            String alias = (String) enumeration.nextElement();
            if (keyStore.isKeyEntry(alias)) {
                pk = (PrivateKey) keyStore.getKey(alias, CERT_PASS.toCharArray());
            }
        }

        return new GoogleCredential.Builder().setTransport(TRANSPORT)
                .setJsonFactory(JSON_FACTORY)
                .setServiceAccountScopes(DriveScopes.DRIVE)
                .setServiceAccountId(SERVICE_ACCOUNT)
                .setServiceAccountPrivateKey(pk)
                .build();
    }



    protected Drive getDriveService() throws IOException, GeneralSecurityException {
        Credential credential = getCredential();
        return new Drive.Builder(TRANSPORT, JSON_FACTORY, credential).build();
    }



    /**
     * Retrieve a list of File resources.
     *
     * @param service Drive API service instance.
     * @return List of File resources.
     */
    protected List<File> listFiles(Drive service) throws IOException {
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


    protected File getFile(Drive service, String fileID) throws IOException {
        File result = null;

        Drive.Files.Get request = service.files().get(fileID);

        try {
            result = request.execute();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }

        return result;
    }


    /**
     * Download a file's content.
     *
     * @param service Drive API service instance.
     * @param file Drive File instance.
     * @return InputStream containing the file's content if successful,
     *         {@code null} otherwise.
     */
    protected InputStream downloadFile(Drive service, File file) {
        return downloadURL(service, file.getDownloadUrl());
    }

    protected InputStream downloadURL(Drive service, String URL) {
        if (URL != null && URL.length() > 0) {
            try {
                HttpResponse resp =
                        service.getRequestFactory().buildGetRequest(new GenericUrl(URL))
                                .execute();
                return resp.getContent();
            } catch (IOException e) {
                // An error occurred.
                e.printStackTrace();
                return null;
            }
        } else {
            // The file doesn't have any content stored on Drive.
            return null;
        }
    }


    protected String getImageData(byte[] imageByteArray){
        String base64 = Base64Utils.toBase64(imageByteArray);
        base64 = "data:image/png;base64,"+base64;
        return base64;
    }
    
    
    protected String driveFileToCustomJSON(Collection<File> files) {
        StringBuilder customJSON = new StringBuilder("");

        customJSON.append("[");
        int counter = 0;
        for (File file : files) {
            if (counter != 0) {
                customJSON.append(",");
            }
            customJSON.append("{");
            customJSON.append("\"id\":\"").append(file.getId()).append("\"");
            customJSON.append(",\"title\":\"").append(file.getTitle()).append("\"");
            customJSON.append(",\"downloadUrl\":\"").append(file.getDownloadUrl()).append("\"");
            customJSON.append(",\"parent\":\"").append(file.getParents().isEmpty() ? "" : file.getParents().get(0).getId()).append("\"");
            if (file.getExportLinks() != null) {
                customJSON.append(",\"exportLinks\":[");
                int exportLinkCounter = 0;
                for (Map.Entry exportLink : file.getExportLinks().entrySet()) {
                    if (exportLinkCounter != 0) {
                        customJSON.append(",");
                    }
                    customJSON.append("{");
                    customJSON.append("\"mime\":\"").append(exportLink.getKey()).append("\"");
                    customJSON.append(",\"url\":\"").append(exportLink.getValue()).append("\"");
                    customJSON.append("}");
                    exportLinkCounter++;
                }
                customJSON.append("]");
            }
            customJSON.append("}");
            counter++;
        }
        customJSON.append("]");

        return customJSON.toString();
    }


}
