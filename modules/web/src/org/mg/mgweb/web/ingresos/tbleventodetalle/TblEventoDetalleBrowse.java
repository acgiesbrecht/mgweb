package org.mg.mgweb.web.ingresos.tbleventodetalle;

import com.haulmont.cuba.gui.actions.list.CreateAction;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.haulmont.cuba.security.global.UserSession;
import org.mg.mgweb.entity.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@UiController("mgweb_TblEventoDetalle.browse")
@UiDescriptor("tbl-evento-detalle-browse.xml")
@LookupComponent("table")
public class TblEventoDetalleBrowse extends MasterDetailScreen<TblEventoDetalle> {

    @Inject
    private CollectionLoader<TblEventoDetalle> tblEventoDetallesDl;
    @Inject
    private LookupField<TblEventos> lookupFieldEvento;
    @Inject
    private UserSession userSession;
    @Inject
    private CollectionContainer<TblEventos> tblEventosDc;
    @Inject
    private DataContext dataContext;
    @Inject
    private InstanceContainer<TblCuentasContablesPorDefecto> cuentasContablesPorDefectoDc;
    @Named("table.create")
    private CreateAction<TblEventoDetalle> tableCreate;
    @Inject
    private CollectionContainer<TblCategoriasArticulos> tblCategoriasArticulosDc;

    @Subscribe
    public void onInitEntity(InitEntityEvent<TblEventoDetalle> event) {
        event.getEntity().setFechahora(LocalDateTime.now());
        event.getEntity().setIdCategoriaArticulo(tblCategoriasArticulosDc.getItems().get(tblCategoriasArticulosDc.getItems().size() - 1));
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        try {
            getEditedEntity().setIdEvento(lookupFieldEvento.getValue());
            getEditedEntity().setIdFormaDePagoPreferida(getEditedEntity().getIdEntidad().getIdFormaDePagoPreferida());
            getEditedEntity().setIdUser(userSession.getUser());
            TblEventoDetalle e = getEditedEntity();
            if (getEditedEntity().getTblAsientos() == null) {
                List<TblAsientos> tblAsientosList = new ArrayList<>();
                TblAsientos asientoAporte = dataContext.create(TblAsientos.class);
                asientoAporte.setFechahora(getEditedEntity().getFechahora());
                asientoAporte.setIdCentroDeCostoDebe(getEditedEntity().getIdEvento().getIdCentroDeCosto());
                asientoAporte.setIdCentroDeCostoHaber(getEditedEntity().getIdEvento().getIdCentroDeCosto());
                asientoAporte.setIdCuentaContableDebe(cuentasContablesPorDefectoDc.getItem().getIdCuentaACobrar());
                asientoAporte.setIdCuentaContableHaber(cuentasContablesPorDefectoDc.getItem().getIdCuentaAportes());
                asientoAporte.setMonto(getEditedEntity().getMonto() * getEditedEntity().getIdEvento().getPorcentajeAporte() / 100);
                asientoAporte.setIdUser(userSession.getUser());

                tblAsientosList.add(asientoAporte);

                TblAsientos asientoDonacion = dataContext.create(TblAsientos.class);
                asientoDonacion.setFechahora(getEditedEntity().getFechahora());
                asientoDonacion.setIdCentroDeCostoDebe(getEditedEntity().getIdEvento().getIdCentroDeCosto());
                asientoDonacion.setIdCentroDeCostoHaber(getEditedEntity().getIdEvento().getIdCentroDeCosto());
                asientoDonacion.setIdCuentaContableDebe(cuentasContablesPorDefectoDc.getItem().getIdCuentaACobrar());
                asientoDonacion.setIdCuentaContableHaber(cuentasContablesPorDefectoDc.getItem().getIdCuentaDonaciones());
                asientoDonacion.setMonto(getEditedEntity().getMonto() - (getEditedEntity().getMonto() * getEditedEntity().getIdEvento().getPorcentajeAporte() / 100));
                asientoDonacion.setIdUser(userSession.getUser());

                tblAsientosList.add(asientoDonacion);

                getEditedEntity().setTblAsientos(tblAsientosList);
            } else {
                for (TblAsientos asiento : getEditedEntity().getTblAsientos()) {
                    if (asiento.getIdCuentaContableHaber().equals(cuentasContablesPorDefectoDc.getItem().getIdCuentaAportes())) {
                        asiento.setMonto(getEditedEntity().getMonto() * getEditedEntity().getIdEvento().getPorcentajeAporte() / 100);
                    } else {
                        asiento.setMonto(getEditedEntity().getMonto() - (getEditedEntity().getMonto() * getEditedEntity().getIdEvento().getPorcentajeAporte() / 100));
                    }
                }
            }
            event.resume();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Subscribe(id = "tblEventoDetallesDl", target = Target.DATA_LOADER)
    public void onTblEventoDetallesDlPreLoad(CollectionLoader.PreLoadEvent<TblEventoDetalle> event) {
        if (tblEventosDc.getItems().size() == 0) {
            event.preventLoad();
            tableCreate.setEnabled(false);
        } else {
            tableCreate.setEnabled(true);
        }
    }

    @Subscribe("lookupFieldEventoTipo")
    public void onLookupFieldEventoTipoValueChange(HasValue.ValueChangeEvent<TblEventoTipos> event) {
        lookupFieldEvento.setValue(null);
        tableCreate.setEnabled(false);
    }


}