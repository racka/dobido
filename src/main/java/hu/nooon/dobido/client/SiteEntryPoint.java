package hu.nooon.dobido.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Document;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import hu.nooon.dobido.client.event.DriveInitEvent;
import hu.nooon.dobido.client.event.DriveInitEventHandler;
import hu.nooon.dobido.client.json.drive.DriveFileMeta;
import hu.nooon.dobido.client.json.product.ProductGoal;
import hu.nooon.dobido.client.layout.MainLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SiteEntryPoint implements EntryPoint {


    private final EventBus eventBus = new SimpleEventBus();

    private JsArray<DriveFileMeta> driveFiles;
    private Map<DriveFileMeta, List<DriveFileMeta>> hierarchy = new HashMap<DriveFileMeta, List<DriveFileMeta>>();
    private Map<String, String> fileIds = new HashMap<String, String>();

    private MainLayout mainLayout;

    public void onModuleLoad() {

        eventBus.addHandler(DriveInitEvent.TYPE, new DriveInitEventHandler() {
            @Override
            public void onDriveInit(DriveInitEvent event) {
                getSiteStructure();
                setBackground();
            }
        });


        try {
            initHierarchy().send();
        } catch (RequestException e) {
            Window.alert("Google Drive access error! Please reload the page.");
        }

        mainLayout = new MainLayout();
        RootPanel.get().add(mainLayout);


//        try {
//            String json = SiteClientBundle.INSTANCE.structure().getText();
//            JsArray<ProductGoal> goals = ProductGoal.parse(json);
//            Window.alert("Valami:" + goals.get(1).getProductCategories().get(0).getProducts().get(0).getName());
//
//        } catch (Exception iax) {
//            Window.alert(iax.getMessage());
//        }

    }


    private String getFileId(String folderName, String fileName) {
        return fileIds.get(folderName + "/" + fileName);
    }


    private RequestBuilder initHierarchy() {
        RequestBuilder request = new RequestBuilder(RequestBuilder.GET, GWT.getModuleBaseURL() + "googledrive?op=list");
        request.setCallback(new RequestCallback() {
            @Override
            public void onResponseReceived(Request request, Response response) {

                driveFiles = DriveFileMeta.getAsArray(response.getText());

                for (int i = 0; i < driveFiles.length(); i++) {
                    DriveFileMeta meta = driveFiles.get(i);
                    if (meta.getParentId().isEmpty()) {
                        hierarchy.put(meta, new ArrayList<DriveFileMeta>());
                    }
                }

                for (int i = 0; i < driveFiles.length(); i++) {

                    DriveFileMeta meta = driveFiles.get(i);

                    if (!meta.getParentId().isEmpty()) {
                        for (DriveFileMeta parent : hierarchy.keySet()) {
                            if (parent.getId().equals(meta.getParentId())) {
                                hierarchy.get(parent).add(meta);
                                fileIds.put(parent.getTitle() + "/" + meta.getTitle(), meta.getId());
                                break;
                            }
                        }
                    }
                }

                eventBus.fireEvent(new DriveInitEvent());
            }

            @Override
            public void onError(Request request, Throwable exception) {
            }
        });

        return request;
    }

    private void setBackground() {
        String fileId = getFileId("Background", "background.jpg");

        if (!fileId.isEmpty()) {
            String URL = GWT.getModuleBaseURL() + "googledrive?op=stream&mime=image/jpg&fileID=" + fileId;
            Image bkg = new Image(URL);
            Document.get().getBody().getStyle().setBackgroundImage("url(" + bkg.getUrl() + ")");
        }

    }

    private void getSiteStructure() {

        String fileId = getFileId("Structure", "site_structure.txt");

        if (!fileId.isEmpty()) {
            String URL = GWT.getModuleBaseURL() + "googledrive?op=stream&mime=text/plain&fileID=" + fileId;
            RequestBuilder request = new RequestBuilder(RequestBuilder.GET, URL);
            request.setCallback(new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {

                    JsArray<ProductGoal> goals = ProductGoal.parse(response.getText());
                    buildMenu(goals);

                }

                @Override
                public void onError(Request request, Throwable exception) {
                    Window.alert("Google Drive access error! Please reload the page.");
                }
            });

            try {
                request.send();
            } catch (RequestException e) {
//                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }

    }


    private void buildMenu(JsArray<ProductGoal> goals) {

        for (int i=0; i < goals.length(); i++) {
            mainLayout.productsMenu.add(new Label(goals.get(i).getName()));
        }
    }


}

