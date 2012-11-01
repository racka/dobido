package hu.nooon.dobido.server.drive;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class GoogleDriveServlet extends DriveServletUtils {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String operation = req.getParameter("op");

        if ("stream".equals(operation)) {
            streamFile(req, resp);
        } else if ("list".equals(operation)) {
            listFiles(resp);
        }

    }

    protected void streamFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String mime = req.getParameter("mime");
        String fileID = req.getParameter("fileID");
        if (fileID == null || mime == null) {
            resp.getOutputStream().write("File data is missing".getBytes());
            return;
        }

        try {

            Drive service = getDriveService();
            File file = getFile(service, fileID);

            resp.setContentType(mime);
            resp.setContentLength(file.getFileSize().intValue());

            BufferedInputStream input = null;
            BufferedOutputStream output = null;

            try {
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


        } catch (GeneralSecurityException e) {
            resp.getWriter().print(e.getMessage());
        }

    }

    protected void listFiles(HttpServletResponse resp) throws IOException {

        try {

            Drive service = getDriveService();
            List<File> files = listFiles(service);

            if (files.isEmpty()) {
                return;
            }

            resp.getWriter().print(driveFileToCustomJSON(files));


        } catch (GeneralSecurityException e) {
            resp.getWriter().print(e.getMessage());
        }
    }


}
