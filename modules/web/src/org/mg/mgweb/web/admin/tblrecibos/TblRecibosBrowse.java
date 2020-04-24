package org.mg.mgweb.web.admin.tblrecibos;

import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import org.mg.mgweb.entity.TblRecibos;
import org.mg.mgweb.service.InformesService;

import javax.inject.Inject;
import java.util.Map;

@UiController("mgweb_TblRecibos.browse")
@UiDescriptor("tbl-recibos-browse.xml")
@LookupComponent("tblRecibosesTable")
@LoadDataBeforeShow
public class TblRecibosBrowse extends StandardLookup<TblRecibos> {

    @Inject
    private ExportDisplay exportDisplay;
    @Inject
    private InformesService informesService;
    @Inject
    private CollectionContainer<TblRecibos> tblRecibosesDc;

    public void imprimir(){
        Map params = informesService.generarRecibo(tblRecibosesDc.getItem().getId().get());
        exportDisplay.show(new ByteArrayDataProvider((byte[]) params.get("reportParam")),
                params.get("fileName").toString(),
                ExportFormat.getByExtension("PDF"));
    }

}