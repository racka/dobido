package hu.nooon.dobido.client.json.product;

import com.google.gwt.core.client.JavaScriptObject;

public class Product extends JavaScriptObject {

    protected Product() {}

    public final native String getName() /*-{ return this.name; }-*/;
    public final native String getQuantity() /*-{ return this.quantity; }-*/;
    public final native String getOrder() /*-{ return this.inOrder; }-*/;
    public final native String getImageFolder() /*-{ return this.imageFolder; }-*/;
    public final native String getImageFile() /*-{ return this.imageFile; }-*/;

}
