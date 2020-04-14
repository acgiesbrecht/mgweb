package org.mg.mgweb.web.ingresos.tbleventodetalle;

import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import org.mg.mgweb.entity.TblEntidades;
import org.mg.mgweb.entity.TblEventos;
import org.mg.mgweb.service.RematesService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@UiController("mgweb_RematesPagosScreen")
@UiDescriptor("remates-pagos-screen.xml")
public class RematesPagosScreen extends Screen {

    @Inject
    private LookupField<TblEventos> lookupFieldEvento;
    @Inject
    private CollectionLoader<TblEntidades> tblEntidadesDl;
    @Inject
    private RematesService rematesService;
    @Inject
    private CollectionContainer<TblEntidades> tblEntidadesDc;
    @Inject
    private LookupField<TblEntidades> lookupFieldEntidad;

    @Install(to = "tblEntidadesDl", target = Target.DATA_LOADER)
    private List<TblEntidades> tblEntidadesDlLoadDelegate(LoadContext<TblEntidades> loadContext) {
        /*if (lookupFieldEvento.getValue() != null) {
            return rematesService.getEntidadesConSaldo(lookupFieldEvento.getValue());
        }*/
        return new ArrayList<>();
    }

    @Subscribe("lookupFieldEvento")
    public void onLookupFieldEventoValueChange(HasValue.ValueChangeEvent<TblEventos> event) {
        //tblEntidadesDl.load();
        //lookupFieldEntidad.setOptionsList(tblEntidadesDc.getItems());
        lookupFieldEntidad.setOptionsList(rematesService.getEntidadesConSaldo(lookupFieldEvento.getValue()));
        //System.out.println(tblEntidadesDc.getItems().size());
    }



}