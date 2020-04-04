package org.mg.mgweb.web.informes;

import com.haulmont.cuba.gui.components.BrowserFrame;
import com.haulmont.cuba.gui.components.StreamResource;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.util.Map;

@UiController("mgweb_Screenreport")
@UiDescriptor("screenreport.xml")
public class Screenreport extends Screen {

    @Inject
    protected BrowserFrame browserFrame;

    private Map<String, Object> params;

    public void setParams(Map<String, Object> params) {
        this.params = params;
        byte[] bytes = (byte[]) params.get("reportParam");

        if (bytes != null) {
            this.getWindow().setCaption(params.get("reportScreenCaption").toString());
            browserFrame.setSource(StreamResource.class)
                    .setStreamSupplier(() -> new ByteArrayInputStream(bytes))
                    .setFileName(params.get("fileName").toString());
        }
    }

}