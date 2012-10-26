package hu.nooon.dobido.client.layout;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;
import hu.nooon.dobido.client.widgets.MenuElement;

public class MainLayout extends Composite {

    interface MyUIBinder extends UiBinder<Widget, MainLayout> {}
    private static MyUIBinder uiBinder = GWT.create(MyUIBinder.class);

    @UiField
    public FlexTable flexTable;

    public MainLayout() {

        initWidget(uiBinder.createAndBindUi(this));

        for (int j=0; j<5; j++) {
            for (int i=0; i<10; i++) {
                flexTable.setWidget(i, j, new MenuElement(i, j));
            }
        }

    }




}
