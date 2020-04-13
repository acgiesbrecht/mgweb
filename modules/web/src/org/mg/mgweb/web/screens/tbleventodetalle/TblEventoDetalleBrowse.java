package org.mg.mgweb.web.screens.tbleventodetalle;

import com.haulmont.cuba.gui.components.DateField;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.global.UserSession;
import org.mg.mgweb.entity.TblEventoDetalle;
import org.mg.mgweb.entity.TblEventos;

import javax.inject.Inject;
import java.time.LocalDateTime;

@UiController("mgweb_TblEventoDetalle.browse")
@UiDescriptor("tbl-evento-detalle-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class TblEventoDetalleBrowse extends MasterDetailScreen<TblEventoDetalle> {

    @Inject
    private CollectionLoader<TblEventoDetalle> tblEventoDetallesDl;
    @Inject
    private LookupField<TblEventos> lookupPickerFieldEvento;
    @Inject
    private CollectionContainer<TblEventos> tblEventosDc;
    @Inject
    private CollectionLoader<TblEventos> tblEventosDl;
    @Inject
    private DateField<LocalDateTime> fechahoraField;
    @Inject
    private UserSession userSession;
    @Inject
    private CollectionContainer<TblEventoDetalle> tblEventoDetallesDc;

    @Subscribe("lookupPickerFieldEvento")
    public void onLookupPickerFieldEventoValueChange(HasValue.ValueChangeEvent<TblEventos> event) {
        if (event.getValue() != null) {
            tblEventoDetallesDl.setParameter("evento", event.getValue());
        } else {
            tblEventoDetallesDl.setParameter("evento", new TblEventos());
        }
        tblEventoDetallesDl.load();
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        if (tblEventosDc.getItems().size() > 0) {
            lookupPickerFieldEvento.setValue(tblEventosDc.getItems().get(0));
        }
    }

    @Subscribe
    public void onInitEntity(InitEntityEvent<TblEventoDetalle> event) {
        event.getEntity().setFechahora(LocalDateTime.now());
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        getEditedEntity().setIdUser(userSession.getUser());
    }





}