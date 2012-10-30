package hu.nooon.dobido.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class DriveFileMeta extends JavaScriptObject {

    protected DriveFileMeta() {}


    public final native String getId() /*-{ return this.id; }-*/;
    public final native String getName() /*-{ return this.name; }-*/;
    public final native String getParentId() /*-{ return this.parent; }-*/;

    public static native JsArray<DriveFileMeta> getAsArray(String json) /*-{ return eval(json); }-*/;


}
