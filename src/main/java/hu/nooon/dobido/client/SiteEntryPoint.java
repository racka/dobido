package hu.nooon.dobido.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Document;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.ui.Image;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import hu.nooon.dobido.client.database.MyRequestFactory;
import hu.nooon.dobido.client.event.DriveInitEvent;
import hu.nooon.dobido.client.event.DriveInitEventHandler;
import hu.nooon.dobido.client.json.DriveFileMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SiteEntryPoint implements EntryPoint {


    private final EventBus eventBus = new SimpleEventBus();
    private MyRequestFactory requestFactory;

    /*
            menu1.click(new MouseEventListener() {
            @Override
            public void notifyMouseEvent(NativeEvent nativeEvent) {
                DummyRequest request = requestFactory.dummyRequest();
                DummyProxy newDummy = request.create(DummyProxy.class);
                newDummy.setName("Ez");
                Request<Void> createReq = request.persist().using(newDummy);
                createReq.fire(new Receiver<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        paper.text(10, 10, "SIKER");
                    }
                });
            }
        });

                menu2Bkg.click(new MouseEventListener() {
            @Override
            public void notifyMouseEvent(NativeEvent nativeEvent) {
                DummyRequest request = requestFactory.dummyRequest();

                Request<DummyProxy> findRequest = request.findByName("Ez");
                findRequest.fire(new Receiver<DummyProxy>() {
                    @Override
                    public void onSuccess(DummyProxy response) {
                        paper.text(100, 100, response.getName()).attr(font1);
                    }
                });
            }
        });


     */

    private JsArray<DriveFileMeta> driveFiles;
    private Map<DriveFileMeta, List<DriveFileMeta>> hierarchy = new HashMap<DriveFileMeta, List<DriveFileMeta>>();

    public void onModuleLoad() {

        eventBus.addHandler(DriveInitEvent.TYPE, new DriveInitEventHandler() {
            @Override
            public void onDriveInit(DriveInitEvent event) {
                setBackground();
            }
        });


        RequestBuilder init = initHierarchy();
        try {
            init.send();
        } catch (RequestException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


//        requestFactory = GWT.create(MyRequestFactory.class);
//        requestFactory.initialize(eventBus);

//        Composite layout = new MainLayout();
//        RootLayoutPanel.get().add(layout);


    }


//    private String folderContent(String folderName) {
//        StringBuilder content = new StringBuilder("");
//        for (DriveFileMeta parent : hierarchy.keySet()) {
//            if (parent.getName().equals(folderName)) {
//
//                for (DriveFileMeta meta : hierarchy.get(parent)) {
//                    content.append(" [").append(meta.getName()).append("] ");
//                }
//            }
//        }
//
//        return content.toString();
//    }

    private String getFileId(String folderName, String fileName) {
        for (DriveFileMeta parent : hierarchy.keySet()) {
            if (parent.getName().equals(folderName)) {

                for (DriveFileMeta meta : hierarchy.get(parent)) {
                    if (meta.getName().equals(fileName)) {
                        return meta.getId();
                    }
                }
            }
        }

        return "";
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
            String URL = GWT.getModuleBaseURL() + "googledrive?op=stream&fileType=image&fileID=" + fileId;
            Image bkg = new Image(URL);
            Document.get().getBody().getStyle().setBackgroundImage("url(" + bkg.getUrl() + ")");
        }

    }


}

