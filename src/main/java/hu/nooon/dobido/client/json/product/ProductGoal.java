package hu.nooon.dobido.client.json.product;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;


public class ProductGoal extends JavaScriptObject {

    protected ProductGoal() {}

    public final native String getName() /*-{ return this.name; }-*/;
    public final native String getColor() /*-{ return this.color; }-*/;
    public final native JsArray<ProductCategory> getProductCategories() /*-{ return this.ProductCategories; }-*/;


    public static native JsArray<ProductGoal> parse(String json) /*-{ return eval('(' + json + ')'); }-*/;


}
