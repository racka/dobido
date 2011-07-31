package hu.nooon.dobido.client.component.loading;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class LoadingWidget extends Composite {

	interface LoadingWidgetUIBinder extends UiBinder<Widget, LoadingWidget>  {
	}

	private static LoadingWidgetUIBinder uiBinder = GWT.create(LoadingWidgetUIBinder.class);

	@UiField
	public AbsolutePanel container;

	@UiField
	public AbsolutePanel curtain;

	@UiField
	public HTMLPanel loading;

	public LoadingWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		setVisible(false);

		container.getElement().getStyle().setZIndex(20000);
		container.setSize("100%", "100%");

		curtain.getElement().getStyle().setBackgroundColor("#000000");
		curtain.getElement().getStyle().setOpacity(0.7);
		curtain.setSize("100%", "100%");

		alignElementsToWindowSize();

		Window.addResizeHandler(new ResizeHandler() {
			public void onResize(ResizeEvent event) {
				alignElementsToWindowSize();
			}
		});

		setVisible(true);
	}

	protected void alignElementsToWindowSize() {
		container.setWidgetPosition(curtain, 0, 0);
		container.setWidgetPosition(loading,
			(Window.getClientWidth() - 120) / 2,
			(Window.getClientHeight() - 40) /2
		);
	}
}
