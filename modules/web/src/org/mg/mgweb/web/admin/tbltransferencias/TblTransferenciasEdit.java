package org.mg.mgweb.web.admin.tbltransferencias;

import com.haulmont.cuba.gui.screen.*;
import org.mg.mgweb.entity.TblTransferencias;

@UiController("mgweb_TblTransferencias.edit")
@UiDescriptor("tbl-transferencias-edit.xml")
@EditedEntityContainer("tblTransferenciasDc")
@LoadDataBeforeShow
public class TblTransferenciasEdit extends StandardEditor<TblTransferencias> {
}