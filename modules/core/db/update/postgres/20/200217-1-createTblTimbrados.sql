create table TBL_TIMBRADOS (
    ID serial,
    --
    NRO integer not null,
    FECHA_INICIO date not null,
    FECHA_VENCIMIENTO date not null,
    NRO_FACTURA_INICIO integer not null,
    NRO_FACTURA_FIN integer not null,
    ACTIVO date,
    ID_USER uuid,
    --
    primary key (ID)
);