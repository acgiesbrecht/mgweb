package org.mg.mgweb.entity.models;

import java.time.LocalDateTime;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;

public class CuotaModel {

    private LocalDateTime fecha;
    private Long monto;

    /**
     * @return the fecha
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the monto
     */
    public Long getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(Long monto) {
        this.monto = monto;
    }

}
