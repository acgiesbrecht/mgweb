package org.mg.mgweb.web.admin.tblrecibos;

import com.haulmont.cuba.gui.screen.*;
import org.mg.mgweb.entity.TblRecibos;

@UiController("mgweb_TblRecibos.edit")
@UiDescriptor("tbl-recibos-edit.xml")
@EditedEntityContainer("tblRecibosDc")
@LoadDataBeforeShow
public class TblRecibosEdit extends StandardEditor<TblRecibos> {
}