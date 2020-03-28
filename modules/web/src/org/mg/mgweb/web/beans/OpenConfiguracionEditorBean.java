package org.mg.mgweb.web.beans;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Window;
import com.haulmont.cuba.web.AppUI;
import org.mg.mgweb.entity.TblConfiguraciones;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component(OpenConfiguracionEditorBean.NAME)
public class OpenConfiguracionEditorBean {
    public static final String NAME = "mgweb_OpenConfiguracionEditorBean";

    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private DataManager dataManager;

    public void openConfiguracionEditor(){
        TblConfiguraciones configuraciones = dataManager.load(TblConfiguraciones.class).one();
        AppUI ui = AppUI.getCurrent();
        Window window = ui.getTopLevelWindow();
        if (window != null) {
            screenBuilders.editor(TblConfiguraciones.class, window.getFrameOwner())
                    .editEntity(configuraciones)
                    .build()
                    .show();
        }
    }

}
