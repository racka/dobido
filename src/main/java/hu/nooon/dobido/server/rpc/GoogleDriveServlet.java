package hu.nooon.dobido.server.rpc;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.util.List;

public class GoogleDriveServlet extends DriveServletUtils {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String operation = req.getParameter("op");

        if ("stream".equals(operation)) {
            streamFile(req, resp);
        } else if ("list".equals(operation)) {
            listFiles(req, resp);
        }

    }

    protected void streamFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fileType = req.getParameter("fileType");
        String fileID = req.getParameter("fileID");
        if (fileID == null || fileType == null) {
            resp.getOutputStream().write("File data is missing".getBytes());
            return;
        }

        try {

            Drive service = getDriveService();
            List<File> files = listFiles(service);

            for (File file : files) {

                if (file.getId().equals(fileID)) {

                    resp.setContentType(fileType + "/" + file.getFileExtension());
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

                }


            }


        } catch (GeneralSecurityException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    protected void listFiles(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {

            Drive service = getDriveService();
            List<File> files = listFiles(service);

            if (files.isEmpty()) {
                return;
            }

            PrintWriter out = resp.getWriter();
            out.println("[");
            int counter = 0;
            for (File file : files) {
                if (counter != 0) {
                    out.print(",");
                }
                out.print("{");
                out.print("\"id\":\"" + file.getId() + "\",");
                out.print("\"name\":\"" + file.getTitle() + "\",");
                out.print("\"parent\":\"" + (file.getParents().isEmpty() ? "" : file.getParents().get(0).getId()) + "\"");
                out.println("}");
                counter++;
            }
            out.println("]");


        } catch (GeneralSecurityException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }


}
