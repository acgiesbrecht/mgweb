create table TBL_CONFIGURACIONES (
    ID serial,
    --
    PERIODO_FISCAL_ACTIVO integer,
    FORMATO_FACTURA varchar(50) not null,
    FORMATO_AUTOFACTURA varchar(50) not null,
    FORMATO_NOTA_DE_CREDITO varchar(50) not null,
    FRECUENCIA_COBRO_COLECTAS integer not null,
    MODO_IMPRESION_TRANSFERENCIAS integer not null,
    --
    primary key (ID)
)^
INSERT INTO TBL_CONFIGURACIONES (ID,
                                PERIODO_FISCAL_ACTIVO,
                                FORMATO_FACTURA,
                                FORMATO_AUTOFACTURA,
                                FORMATO_NOTA_DE_CREDITO,
                                FRECUENCIA_COBRO_COLECTAS,
                                MODO_IMPRESION_TRANSFERENCIAS)
                             VALUES
                                (1, 2020, 'factura', 'autofactura', 'nota_de_credito', 1, 1)^