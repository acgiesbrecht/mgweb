package org.mg.mgweb.web.admin.tbltransferencias;

import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import org.mg.mgweb.entity.TblTransferencias;
import org.mg.mgweb.service.InformesService;

import javax.inject.Inject;
import java.util.Map;

@UiController("mgweb_TblTransferencias.browse")
@UiDescriptor("tbl-transferencias-browse.xml")
@LookupComponent("tblTransferenciasesTable")
@LoadDataBeforeShow
public class TblTransferenciasBrowse extends StandardLookup<TblTransferencias> {

    @Inject
    private ExportDisplay exportDisplay;
    @Inject
    private InformesService informesService;
    @Inject
    private CollectionContainer<TblTransferencias> tblTransferenciasesDc;

    public void imprimir(){
        Map params = informesService.generarTransferencia(tblTransferenciasesDc.getItem().getId().get());
        exportDisplay.show(new ByteArrayDataProvider((byte[]) params.get("reportParam")),
                params.get("fileName").toString(),
                ExportFormat.getByExtension("PDF"));
    }

}