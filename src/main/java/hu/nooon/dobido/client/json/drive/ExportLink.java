package hu.nooon.dobido.client.json.drive;

import com.google.gwt.core.client.JavaScriptObject;

public class ExportLink extends JavaScriptObject {

    protected ExportLink() {}

    public final native String getMime() /*-{ return this.mime; }-*/;
    public final native String getURL() /*-{ return this.url; }-*/;

}
