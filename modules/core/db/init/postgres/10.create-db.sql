-- begin TBL_APORTES_IMPORTE_MENSUAL_SALDO_ANTERIOR
create table tbl_aportes_importe_mensual_saldo_anterior (
    ID serial,
    --
    id_entidad integer not null,
    ano integer not null,
    importe_mesnual bigint not null,
    saldo_anterior bigint not null,
    --
    primary key (ID)
)^
-- end TBL_APORTES_IMPORTE_MENSUAL_SALDO_ANTERIOR
-- begin TBL_AREAS_SERVICIO_EN_IGLESIA
create table tbl_areas_servicio_en_iglesia (
    ID serial,
    --
    descripcion varchar(50) not null,
    --
    primary key (ID)
)^
-- end TBL_AREAS_SERVICIO_EN_IGLESIA
-- begin TBL_ASIENTOS
create table tbl_asientos (
    ID serial,
    --
    fechahora timestamp not null,
    id_cuenta_contable_debe integer not null,
    id_cuenta_contable_haber integer not null,
    observacion varchar(255),
    monto integer not null,
    id_user integer not null,
    asiento_manual boolean,
    id_centro_de_costo_debe integer not null,
    id_centro_de_costo_haber integer not null,
    --
    primary key (ID)
)^
-- end TBL_ASIENTOS
-- begin TBL_ASIENTOS_TEMPORALES
create table tbl_asientos_temporales (
    ID serial,
    --
    fechahora timestamp not null,
    id_cuenta_contable_debe integer not null,
    id_cuenta_contable_haber integer not null,
    monto integer not null,
    es_aporte boolean,
    facturado boolean,
    id_centro_de_costo_debe integer not null,
    id_centro_de_costo_haber integer not null,
    --
    primary key (ID)
)^
-- end TBL_ASIENTOS_TEMPORALES
-- begin TBL_AUTOFACTURAS
create table tbl_autofacturas (
    ID serial,
    --
    nro varchar(15) not null,
    id_timbrado integer not null,
    fechahora timestamp not null,
    nombre varchar(255) not null,
    domicilio varchar(255) not null,
    direccion_de_transaccion varchar(255) not null,
    ci varchar(20) not null,
    cantidad integer not null,
    concepto varchar(255) not null,
    precio_unitario integer not null,
    monto integer not null,
    observacion varchar(255),
    anulado boolean,
    id_user integer not null,
    condicion_contado boolean,
    --
    primary key (ID)
)^
-- end TBL_AUTOFACTURAS
-- begin TBL_CATEGORIAS_ARTICULOS
create table tbl_categorias_articulos (
    ID serial,
    --
    descripcion varchar(50),
    --
    primary key (ID)
)^
-- end TBL_CATEGORIAS_ARTICULOS
-- begin TBL_CENTROS_DE_COSTO
create table tbl_centros_de_costo (
    ID serial,
    --
    descripcion varchar(255) not null,
    id_cuenta_contable_efectivo_por_defecto integer not null,
    id_cuenta_contable_cta_cte_por_defecto integer not null,
    cta_cte integer not null,
    preferido boolean,
    es_donacion_externa boolean,
    --
    primary key (ID)
)^
-- end TBL_CENTROS_DE_COSTO
-- begin TBL_CONTRIBUYENTES
create table tbl_contribuyentes (
    ruc_sin_dv varchar(20),
    --
    dv varchar(1) not null,
    razon_social varchar(256) not null,
    --
    primary key (ruc_sin_dv)
)^
-- end TBL_CONTRIBUYENTES
-- begin TBL_CUENTAS_CONTABLES
create table tbl_cuentas_contables (
    ID integer,
    --
    descripcion varchar(255) not null,
    id_cuenta_madre integer,
    imputable boolean,
    --
    primary key (ID)
)^
-- end TBL_CUENTAS_CONTABLES
-- begin TBL_CUENTAS_CONTABLES_POR_DEFECTO
create table tbl_cuentas_contables_por_defecto (
    ID integer,
    --
    id_cuenta_haber_compras_factura_contado integer not null,
    id_cuenta_haber_compras_factura_credito integer not null,
    id_cuenta_debe_compras integer not null,
    id_cuenta_a_cobrar integer not null,
    id_cuenta_aportes integer not null,
    id_cuenta_donaciones integer not null,
    id_cuenta_caja integer not null,
    id_cuenta_cta_cte integer not null,
    --
    primary key (ID)
)^
-- end TBL_CUENTAS_CONTABLES_POR_DEFECTO
-- begin TBL_DATABASE_UPDATES
create table tbl_database_updates (
    id varchar(50),
    --
    primary key (id)
)^
-- end TBL_DATABASE_UPDATES
-- begin TBL_ENTIDADES
create table tbl_entidades (
    ID serial,
    --
    nombres varchar(128) not null,
    apellidos varchar(128) not null,
    razon_social varchar(256) not null,
    ruc_sin_dv varchar(20) not null,
    ctacte integer not null,
    domicilio varchar(50),
    box integer,
    is_miembro_activo boolean,
    id_forma_de_pago_preferida integer,
    aporte_mensual integer not null,
    id_entidad_pagante_aportes integer,
    fecha_nacimiento timestamp,
    fecha_bautismo timestamp,
    fecha_entrada_congregacion timestamp,
    fecha_salida_congregacion timestamp,
    fecha_defuncion timestamp,
    id_area_servicio_en_iglesia integer,
    id_miembros_categoria_de_pago integer,
    id_miembros_alergia integer,
    id_user integer,
    aporte_saldo_anterior bigint,
    mes_inicio_aporte integer,
    mes_fin_aporte integer,
    cantidad_de_dependientes_aportantes integer not null,
    --
    primary key (ID)
)^
-- end TBL_ENTIDADES
-- begin TBL_ENTIDADES_HISTORICO_CATEGORIAS
create table tbl_entidades_historico_categorias (
    ID serial,
    --
    id_entidad integer not null,
    id_categoria_de_pago integer not null,
    fecha timestamp,
    observaciones varchar(255),
    --
    primary key (ID)
)^
-- end TBL_ENTIDADES_HISTORICO_CATEGORIAS
-- begin TBL_EVENTO_CUOTAS
create table tbl_evento_cuotas (
    id_evento integer,
    --
    fecha_1 timestamp,
    fecha_2 timestamp,
    fecha_3 timestamp,
    fecha_4 timestamp,
    id_user integer,
    --
    primary key (id_evento)
)^
-- end TBL_EVENTO_CUOTAS
-- begin TBL_EVENTO_DETALLE
create table tbl_evento_detalle (
    ID serial,
    --
    fechahora timestamp not null,
    observacion varchar(255),
    monto integer not null,
    id_entidad integer not null,
    id_evento integer not null,
    id_categoria_articulo integer not null,
    id_forma_de_pago_preferida integer not null,
    id_user integer,
    --
    primary key (ID)
)^
-- end TBL_EVENTO_DETALLE
-- begin TBL_EVENTO_TIPOS
create table tbl_evento_tipos (
    ID integer,
    --
    descripcion varchar(50) not null,
    --
    primary key (ID)
)^
-- end TBL_EVENTO_TIPOS
-- begin TBL_EVENTOS
create table tbl_eventos (
    ID serial,
    --
    descripcion varchar(100),
    fecha timestamp not null,
    id_centro_de_costo integer not null,
    id_evento_tipo integer not null,
    id_grupo integer not null,
    id_user integer not null,
    porcentaje_aporte integer not null,
    --
    primary key (ID)
)^
-- end TBL_EVENTOS
-- begin TBL_FACTURAS
create table tbl_facturas (
    nro integer,
    --
    id_timbrado integer not null,
    fechahora timestamp not null,
    id_entidad integer not null,
    razon_social varchar(50) not null,
    ruc varchar(20) not null,
    importe_donacion integer not null,
    importe_aporte integer not null,
    anulado boolean,
    id_user integer not null,
    domicilio varchar(255),
    casilla_de_correo integer,
    --
    primary key (nro)
)^
-- end TBL_FACTURAS
-- begin TBL_FACTURAS_COMPRA
create table tbl_facturas_compra (
    ID serial,
    --
    nro varchar(15) not null,
    nro_timbrado varchar(8) not null,
    vencimiento_timbrado timestamp not null,
    condicion_contado boolean,
    fecha_vencimiento_credito timestamp,
    cuotas_credito integer,
    fechahora timestamp not null,
    razon_social varchar(255) not null,
    ruc varchar(20) not null,
    monto_exentas integer not null,
    monto_iva5 integer not null,
    monto_iva10 integer not null,
    iva5 integer not null,
    iva10 integer not null,
    observacion varchar(255),
    id_user integer not null,
    --
    primary key (ID)
)^
-- end TBL_FACTURAS_COMPRA
-- begin TBL_FORMAS_DE_PAGO
create table tbl_formas_de_pago (
    ID integer,
    --
    descripcion varchar(50) not null,
    --
    primary key (ID)
)^
-- end TBL_FORMAS_DE_PAGO
-- begin TBL_GRUPOS
create table tbl_grupos (
    ID serial,
    --
    descripcion varchar(50) not null,
    --
    primary key (ID)
)^
-- end TBL_GRUPOS
-- begin TBL_IGLESIA
create table tbl_iglesia (
    ID integer,
    --
    nombre varchar(256) not null,
    ruc_sin_dv varchar(20),
    ctacte integer,
    domicilio varchar(50),
    box integer,
    --
    primary key (ID)
)^
-- end TBL_IGLESIA
-- begin TBL_MIEMBROS_ALERGIAS
create table tbl_miembros_alergias (
    ID integer,
    --
    descripcion varchar(50) not null,
    --
    primary key (ID)
)^
-- end TBL_MIEMBROS_ALERGIAS
-- begin TBL_MIEMBROS_CATEGORIAS_DE_PAGO
create table tbl_miembros_categorias_de_pago (
    ID serial,
    --
    descripcion varchar(50) not null,
    es_activacion boolean,
    --
    primary key (ID)
)^
-- end TBL_MIEMBROS_CATEGORIAS_DE_PAGO
-- begin TBL_MIEMBROS_FAMILIAS
create table tbl_miembros_familias (
    ID serial,
    --
    descripcion varchar(50),
    foto bytea,
    --
    primary key (ID)
)^
-- end TBL_MIEMBROS_FAMILIAS
-- begin TBL_MIEMBROS_RELACIONES
create table tbl_miembros_relaciones (
    ID serial,
    --
    id_miembros_familia integer,
    id_entidad_1 integer,
    id_entidad_2 integer,
    id_miembros_relaciones_tipo integer,
    id_miembros_relaciones_rol_1 integer,
    id_miembros_relaciones_rol_2 integer,
    fecha_inicio timestamp,
    fecha_fin timestamp,
    id_user integer,
    --
    primary key (ID)
)^
-- end TBL_MIEMBROS_RELACIONES
-- begin TBL_MIEMBROS_RELACIONES_ROLES
create table tbl_miembros_relaciones_roles (
    ID serial,
    --
    descripcion varchar(50) not null,
    --
    primary key (ID)
)^
-- end TBL_MIEMBROS_RELACIONES_ROLES
-- begin TBL_MIEMBROS_RELACIONES_TIPOS
create table tbl_miembros_relaciones_tipos (
    ID serial,
    --
    descripcion varchar(50) not null,
    --
    primary key (ID)
)^
-- end TBL_MIEMBROS_RELACIONES_TIPOS
-- begin TBL_NOTAS_DE_CREDITO
create table tbl_notas_de_credito (
    ID serial,
    --
    nro varchar(15) not null,
    id_timbrado integer not null,
    fechahora timestamp not null,
    nro_factura integer not null,
    anulado boolean,
    id_user integer not null,
    --
    primary key (ID)
)^
-- end TBL_NOTAS_DE_CREDITO
-- begin TBL_NOTAS_DE_CREDITO_COMPRAS
create table tbl_notas_de_credito_compras (
    ID serial,
    --
    nro varchar(15) not null,
    nro_timbrado varchar(8) not null,
    vencimiento_timbrado timestamp not null,
    fechahora timestamp not null,
    razon_social varchar(255) not null,
    ruc varchar(20) not null,
    monto_exentas integer not null,
    monto_iva5 integer not null,
    monto_iva10 integer not null,
    iva5 integer not null,
    iva10 integer not null,
    observacion varchar(255),
    id_user integer not null,
    --
    primary key (ID)
)^
-- end TBL_NOTAS_DE_CREDITO_COMPRAS
-- begin TBL_RECIBOS
create table tbl_recibos (
    ID serial,
    --
    fechahora timestamp not null,
    concepto varchar(50),
    monto_aporte integer not null,
    monto_donacion integer not null,
    id_entidad integer not null,
    id_evento_tipo integer not null,
    id_user integer not null,
    id_evento integer,
    fechahora_compromiso timestamp,
    --
    primary key (ID)
)^
-- end TBL_RECIBOS
-- begin TBL_RECIBOS_COMPRA
create table tbl_recibos_compra (
    ID serial,
    --
    nro varchar(30) not null,
    fechahora timestamp not null,
    razon_social varchar(255) not null,
    ruc varchar(20) not null,
    monto integer not null,
    observacion varchar(255),
    id_user integer not null,
    --
    primary key (ID)
)^
-- end TBL_RECIBOS_COMPRA
-- begin TBL_ROLES
create table tbl_roles (
    ID serial,
    --
    descripcion varchar(50) not null,
    --
    primary key (ID)
)^
-- end TBL_ROLES
-- begin TBL_TIMBRADOS
create table tbl_timbrados (
    nro integer,
    --
    fecha_inicio timestamp not null,
    fecha_vencimiento timestamp not null,
    nro_factura_incio integer not null,
    nro_factura_fin integer not null,
    activo boolean,
    id_user integer not null,
    --
    primary key (nro)
)^
-- end TBL_TIMBRADOS
-- begin TBL_TIMBRADOS_AUTOFACTURAS
create table tbl_timbrados_autofacturas (
    ID serial,
    --
    nro varchar(8) not null,
    fecha_inicio timestamp not null,
    fecha_vencimiento timestamp not null,
    nro_factura_incio integer not null,
    nro_factura_fin integer not null,
    activo boolean,
    id_user integer not null,
    --
    primary key (ID)
)^
-- end TBL_TIMBRADOS_AUTOFACTURAS
-- begin TBL_TIMBRADOS_COMPRAS
create table tbl_timbrados_compras (
    nro varchar(8),
    --
    fecha_vencimiento timestamp not null,
    ruc_sin_dv varchar(20) not null,
    id_user integer,
    --
    primary key (nro)
)^
-- end TBL_TIMBRADOS_COMPRAS
-- begin TBL_TIMBRADOS_NOTAS_DE_CREDITO
create table tbl_timbrados_notas_de_credito (
    ID serial,
    --
    nro varchar(8) not null,
    establecimiento varchar(3) not null,
    punto_de_expedicion varchar(3) not null,
    fecha_inicio timestamp not null,
    fecha_vencimiento timestamp not null,
    nro_nota_de_credito_incio integer not null,
    nro_nota_de_credito_fin integer not null,
    activo boolean,
    id_user integer not null,
    --
    primary key (ID)
)^
-- end TBL_TIMBRADOS_NOTAS_DE_CREDITO
-- begin TBL_TRANSFERENCIAS
create table tbl_transferencias (
    ID serial,
    --
    fechahora timestamp not null,
    concepto varchar(50),
    monto_aporte integer not null,
    monto_donacion integer not null,
    id_entidad integer not null,
    id_evento_tipo integer not null,
    cobrado boolean,
    id_user integer not null,
    id_evento integer,
    fechahora_compromiso timestamp,
    id_evento_detalle integer,
    seq_pago integer not null,
    --
    primary key (ID)
)^
-- end TBL_TRANSFERENCIAS
-- begin TBL_USERS
create table tbl_users (
    ID serial,
    --
    nombre varchar(50) not null,
    password varchar(100) not null,
    nombrecompleto varchar(100) not null,
    --
    primary key (ID)
)^
-- end TBL_USERS
-- begin TBL_AUTOFACTURAS_ASIENTOS
create table tbl_autofacturas_asientos (
    id_autofactura integer,
    id_asiento integer,
    primary key (id_autofactura, id_asiento)
)^
-- end TBL_AUTOFACTURAS_ASIENTOS
-- begin TBL_NOTAS_DE_CREDITO_ASIENTOS
create table tbl_notas_de_credito_asientos (
    id_nota_de_credito integer,
    id_asiento integer,
    primary key (id_nota_de_credito, id_asiento)
)^
-- end TBL_NOTAS_DE_CREDITO_ASIENTOS
-- begin TBL_FACTURAS_COMPRA_ASIENTOS
create table tbl_facturas_compra_asientos (
    id_factura_compra integer,
    id_asiento integer,
    primary key (id_factura_compra, id_asiento)
)^
-- end TBL_FACTURAS_COMPRA_ASIENTOS
-- begin TBL_EVENTO_DETALLE_ASIENTOS
create table tbl_evento_detalle_asientos (
    id_evento_detalle integer,
    id_asiento integer,
    primary key (id_evento_detalle, id_asiento)
)^
-- end TBL_EVENTO_DETALLE_ASIENTOS
-- begin TBL_ASIENTOS_ASIENTOS_TEMPORALES
create table tbl_asientos_asientos_temporales (
    id_asiento_temporal integer,
    id_asiento integer,
    primary key (id_asiento_temporal, id_asiento)
)^
-- end TBL_ASIENTOS_ASIENTOS_TEMPORALES
-- begin TBL_FACTURAS_ASIENTOS
create table tbl_facturas_asientos (
    nro_factura integer,
    id_asiento integer,
    primary key (nro_factura, id_asiento)
)^
-- end TBL_FACTURAS_ASIENTOS
-- begin TBL_NOTAS_DE_CREDITO_COMPRAS_ASIENTOS
create table tbl_notas_de_credito_compras_asientos (
    id_nota_de_credito integer,
    id_asiento integer,
    primary key (id_nota_de_credito, id_asiento)
)^
-- end TBL_NOTAS_DE_CREDITO_COMPRAS_ASIENTOS
-- begin TBL_RECIBOS_COMPRA_FACTURAS_COMPRA
create table tbl_recibos_compra_facturas_compra (
    id_recibo integer,
    id_factura_compra integer,
    primary key (id_recibo, id_factura_compra)
)^
-- end TBL_RECIBOS_COMPRA_FACTURAS_COMPRA
-- begin TBL_RECIBOS_COMPRA_ASIENTOS
create table tbl_recibos_compra_asientos (
    id_recibo integer,
    id_asiento integer,
    primary key (id_recibo, id_asiento)
)^
-- end TBL_RECIBOS_COMPRA_ASIENTOS
-- begin TBL_RECIBOS_ASIENTOS_TEMPORALES
create table tbl_recibos_asientos_temporales (
    id_recibo integer,
    id_asiento_temporal integer,
    primary key (id_recibo, id_asiento_temporal)
)^
-- end TBL_RECIBOS_ASIENTOS_TEMPORALES
-- begin TBL_GRUPOS_USERS
create table tbl_grupos_users (
    id_user integer,
    id_grupo integer,
    primary key (id_user, id_grupo)
)^
-- end TBL_GRUPOS_USERS
-- begin TBL_TRANSFERENCIAS_ASIENTOS_TEMPORALES
create table tbl_transferencias_asientos_temporales (
    id_transferencia integer,
    id_asiento_temporal integer,
    primary key (id_transferencia, id_asiento_temporal)
)^
-- end TBL_TRANSFERENCIAS_ASIENTOS_TEMPORALES
-- begin TBL_ROLES_USERS
create table tbl_roles_users (
    id_user integer,
    id_role integer,
    primary key (id_user, id_role)
)^
-- end TBL_ROLES_USERS-- begin TBL_CONFIGURACIONES
create table TBL_CONFIGURACIONES (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
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
-- end TBL_CONFIGURACIONES
