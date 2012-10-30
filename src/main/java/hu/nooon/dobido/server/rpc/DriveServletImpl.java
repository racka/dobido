package hu.nooon.dobido.server.rpc;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.gwt.user.server.Base64Utils;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.List;

public class DriveServletImpl extends DriveServletUtils {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            Drive service = getDriveService();
            List<File> files = listFiles(service);

            for (File file : files) {

                if (file.getTitle().equals("facebook.png")) {

                    resp.setContentType("image/png");
                    resp.setContentLength(file.getFileSize().intValue());

                    BufferedInputStream input = null;
                    BufferedOutputStream output = null;

                    try {
//                        String imageData = getImageData(IOUtils.toByteArray(downloadFile(service, file)));
//                        input = new BufferedInputStream(IOUtils.toInputStream(imageData));

                        input = new BufferedInputStream(downloadFile(service, file));
                        output = new BufferedOutputStream(resp.getOutputStream());

                        byte[] buffer = new byte[8192];
                        for (int length = 0; (length = input.read(buffer)) > 0; ) {
                            output.write(buffer, 0, length);
                        }
                    } finally {
                        if (output != null) try {
                            output.close();
                        } catch (IOException ignore) {
                        }
                        if (input != null) try {
                            input.close();
                        } catch (IOException ignore) {
                        }
                    }

                }


            }


        } catch (GeneralSecurityException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }


    public String getImageData(byte[] imageByteArray){
        String base64 = Base64Utils.toBase64(imageByteArray);
        base64 = "data:image/png;base64,"+base64;
        return base64;
    }



}
