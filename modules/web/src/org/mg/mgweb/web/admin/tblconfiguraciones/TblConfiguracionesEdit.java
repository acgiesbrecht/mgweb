package org.mg.mgweb.web.admin.tblconfiguraciones;

import com.haulmont.cuba.gui.screen.*;
import org.mg.mgweb.entity.TblConfiguraciones;
import org.mg.mgweb.service.DatabaseService;

import javax.inject.Inject;

@UiController("mgweb_TblConfiguraciones.edit")
@UiDescriptor("tbl-configuraciones-edit.xml")
@EditedEntityContainer("tblConfiguracionesDc")
@LoadDataBeforeShow
public class TblConfiguracionesEdit extends StandardEditor<TblConfiguraciones> {

    @Inject
    DatabaseService databaseService;

    public void doBackup(){
        databaseService.backup();
    }

}