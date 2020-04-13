package org.mg.mgweb.web.admin.tbleventos;

import com.haulmont.cuba.gui.screen.*;
import org.mg.mgweb.entity.TblEventos;

@UiController("mgweb_TblEventos.browse")
@UiDescriptor("tbl-eventos-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class TblEventosBrowse extends MasterDetailScreen<TblEventos> {
}