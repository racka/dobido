package hu.nooon.dobido.client.json.product;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ProductCategory extends JavaScriptObject {

    protected ProductCategory() {}

    public final native String getName() /*-{ return this.name; }-*/;
    public final native String getCoverImageFolder() /*-{ return this.coverImageFolder; }-*/;
    public final native String getcoverImageFile() /*-{ return this.coverImageFile; }-*/;
    public final native JsArray<Product> getProducts() /*-{ return this.Products; }-*/;


}
