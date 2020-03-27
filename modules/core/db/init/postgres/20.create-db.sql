-- begin TBL_APORTES_IMPORTE_MENSUAL_SALDO_ANTERIOR
alter table tbl_aportes_importe_mensual_saldo_anterior add constraint FK_TBL_APORTES_IMPORTE_MENSUAL_SALDO_ANTERIOR_ON_ID_ENTIDAD foreign key (ID_ENTIDAD) references tbl_entidades(ID)^
create index IDX_TBL_APORTES_IMPORTE_MENSUAL_SALDO_ANTERIOR_ON_ID_ENTIDAD on tbl_aportes_importe_mensual_saldo_anterior (ID_ENTIDAD)^
-- end TBL_APORTES_IMPORTE_MENSUAL_SALDO_ANTERIOR
-- begin TBL_ASIENTOS
alter table tbl_asientos add constraint FK_TBL_ASIENTOS_ON_ID_CUENTA_CONTABLE_DEBE foreign key (ID_CUENTA_CONTABLE_DEBE) references tbl_cuentas_contables(ID)^
alter table tbl_asientos add constraint FK_TBL_ASIENTOS_ON_ID_CUENTA_CONTABLE_HABER foreign key (ID_CUENTA_CONTABLE_HABER) references tbl_cuentas_contables(ID)^
alter table tbl_asientos add constraint FK_TBL_ASIENTOS_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
alter table tbl_asientos add constraint FK_TBL_ASIENTOS_ON_ID_CENTRO_DE_COSTO_DEBE foreign key (ID_CENTRO_DE_COSTO_DEBE) references tbl_centros_de_costo(ID)^
alter table tbl_asientos add constraint FK_TBL_ASIENTOS_ON_ID_CENTRO_DE_COSTO_HABER foreign key (ID_CENTRO_DE_COSTO_HABER) references tbl_centros_de_costo(ID)^
create index IDX_TBL_ASIENTOS_ON_ID_CUENTA_CONTABLE_DEBE on tbl_asientos (ID_CUENTA_CONTABLE_DEBE)^
create index IDX_TBL_ASIENTOS_ON_ID_CUENTA_CONTABLE_HABER on tbl_asientos (ID_CUENTA_CONTABLE_HABER)^
create index IDX_TBL_ASIENTOS_ON_ID_USER on tbl_asientos (ID_USER)^
create index IDX_TBL_ASIENTOS_ON_ID_CENTRO_DE_COSTO_DEBE on tbl_asientos (ID_CENTRO_DE_COSTO_DEBE)^
create index IDX_TBL_ASIENTOS_ON_ID_CENTRO_DE_COSTO_HABER on tbl_asientos (ID_CENTRO_DE_COSTO_HABER)^
-- end TBL_ASIENTOS
-- begin TBL_ASIENTOS_TEMPORALES
alter table tbl_asientos_temporales add constraint FK_TBL_ASIENTOS_TEMPORALES_ON_ID_CUENTA_CONTABLE_DEBE foreign key (ID_CUENTA_CONTABLE_DEBE) references tbl_cuentas_contables(ID)^
alter table tbl_asientos_temporales add constraint FK_TBL_ASIENTOS_TEMPORALES_ON_ID_CUENTA_CONTABLE_HABER foreign key (ID_CUENTA_CONTABLE_HABER) references tbl_cuentas_contables(ID)^
alter table tbl_asientos_temporales add constraint FK_TBL_ASIENTOS_TEMPORALES_ON_ID_CENTRO_DE_COSTO_DEBE foreign key (ID_CENTRO_DE_COSTO_DEBE) references tbl_centros_de_costo(ID)^
alter table tbl_asientos_temporales add constraint FK_TBL_ASIENTOS_TEMPORALES_ON_ID_CENTRO_DE_COSTO_HABER foreign key (ID_CENTRO_DE_COSTO_HABER) references tbl_centros_de_costo(ID)^
create index IDX_TBL_ASIENTOS_TEMPORALES_ON_ID_CUENTA_CONTABLE_DEBE on tbl_asientos_temporales (ID_CUENTA_CONTABLE_DEBE)^
create index IDX_TBL_ASIENTOS_TEMPORALES_ON_ID_CUENTA_CONTABLE_HABER on tbl_asientos_temporales (ID_CUENTA_CONTABLE_HABER)^
create index IDX_TBL_ASIENTOS_TEMPORALES_ON_ID_CENTRO_DE_COSTO_DEBE on tbl_asientos_temporales (ID_CENTRO_DE_COSTO_DEBE)^
create index IDX_TBL_ASIENTOS_TEMPORALES_ON_ID_CENTRO_DE_COSTO_HABER on tbl_asientos_temporales (ID_CENTRO_DE_COSTO_HABER)^
-- end TBL_ASIENTOS_TEMPORALES
-- begin TBL_AUTOFACTURAS
alter table tbl_autofacturas add constraint FK_TBL_AUTOFACTURAS_ON_ID_TIMBRADO foreign key (ID_TIMBRADO) references tbl_timbrados_autofacturas(ID)^
alter table tbl_autofacturas add constraint FK_TBL_AUTOFACTURAS_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
create index IDX_TBL_AUTOFACTURAS_ON_ID_TIMBRADO on tbl_autofacturas (ID_TIMBRADO)^
create index IDX_TBL_AUTOFACTURAS_ON_ID_USER on tbl_autofacturas (ID_USER)^
-- end TBL_AUTOFACTURAS
-- begin TBL_CENTROS_DE_COSTO
alter table tbl_centros_de_costo add constraint FK_TBL_CENTRDECOSTO_ON_ID_CUENTA_CONTABLE_EFECTIVO_POR_DEFECTO foreign key (ID_CUENTA_CONTABLE_EFECTIVO_POR_DEFECTO) references tbl_cuentas_contables(ID)^
alter table tbl_centros_de_costo add constraint FK_TBL_CENTDECOST_ON_ID_CUENTA_CONTABLE_CTA_CTE_POR_DEFECTO foreign key (ID_CUENTA_CONTABLE_CTA_CTE_POR_DEFECTO) references tbl_cuentas_contables(ID)^
create index IDX_TBL_CENTRDECOSTO_ON_IDCUENTCONTAEFECTPORDEFEC1 on tbl_centros_de_costo (ID_CUENTA_CONTABLE_EFECTIVO_POR_DEFECTO)^
create index IDX_TBL_CENTDECOST_ON_ID_CUENTA_CONTABLE_CTA_CTE_POR_DEFECTO1 on tbl_centros_de_costo (ID_CUENTA_CONTABLE_CTA_CTE_POR_DEFECTO)^
-- end TBL_CENTROS_DE_COSTO
-- begin TBL_CUENTAS_CONTABLES
alter table tbl_cuentas_contables add constraint FK_TBL_CUENTAS_CONTABLES_ON_ID_CUENTA_MADRE foreign key (ID_CUENTA_MADRE) references tbl_cuentas_contables(ID)^
create index IDX_TBL_CUENTAS_CONTABLES_ON_ID_CUENTA_MADRE on tbl_cuentas_contables (ID_CUENTA_MADRE)^
-- end TBL_CUENTAS_CONTABLES
-- begin TBL_CUENTAS_CONTABLES_POR_DEFECTO
alter table tbl_cuentas_contables_por_defecto add constraint FK_TBL_CUENCONTPORDEFE_ON_IDCUENHABECOMPFACTCONT foreign key (ID_CUENTA_HABER_COMPRAS_FACTURA_CONTADO) references tbl_cuentas_contables(ID)^
alter table tbl_cuentas_contables_por_defecto add constraint FK_TBL_CUENCONTPORDEFE_ON_IDCUENHABECOMPFACTCRED foreign key (ID_CUENTA_HABER_COMPRAS_FACTURA_CREDITO) references tbl_cuentas_contables(ID)^
alter table tbl_cuentas_contables_por_defecto add constraint FK_TBL_CUENTAS_CONTABLES_POR_DEFECTO_ON_ID_CUENTA_DEBE_COMPRAS foreign key (ID_CUENTA_DEBE_COMPRAS) references tbl_cuentas_contables(ID)^
alter table tbl_cuentas_contables_por_defecto add constraint FK_TBL_CUENTAS_CONTABLES_POR_DEFECTO_ON_ID_CUENTA_A_COBRAR foreign key (ID_CUENTA_A_COBRAR) references tbl_cuentas_contables(ID)^
alter table tbl_cuentas_contables_por_defecto add constraint FK_TBL_CUENTAS_CONTABLES_POR_DEFECTO_ON_ID_CUENTA_APORTES foreign key (ID_CUENTA_APORTES) references tbl_cuentas_contables(ID)^
alter table tbl_cuentas_contables_por_defecto add constraint FK_TBL_CUENTAS_CONTABLES_POR_DEFECTO_ON_ID_CUENTA_DONACIONES foreign key (ID_CUENTA_DONACIONES) references tbl_cuentas_contables(ID)^
alter table tbl_cuentas_contables_por_defecto add constraint FK_TBL_CUENTAS_CONTABLES_POR_DEFECTO_ON_ID_CUENTA_CAJA foreign key (ID_CUENTA_CAJA) references tbl_cuentas_contables(ID)^
alter table tbl_cuentas_contables_por_defecto add constraint FK_TBL_CUENTAS_CONTABLES_POR_DEFECTO_ON_ID_CUENTA_CTA_CTE foreign key (ID_CUENTA_CTA_CTE) references tbl_cuentas_contables(ID)^
create index IDX_TBL_CUENCONTPORDEFE_ON_IDCUENHABECOMPFACTCONT1 on tbl_cuentas_contables_por_defecto (ID_CUENTA_HABER_COMPRAS_FACTURA_CONTADO)^
create index IDX_TBL_CUENCONTPORDEFE_ON_IDCUENHABECOMPFACTCRED1 on tbl_cuentas_contables_por_defecto (ID_CUENTA_HABER_COMPRAS_FACTURA_CREDITO)^
create index IDX_TBL_CUENTCONTAPORDEFEC_ON_ID_CUENTA_DEBE_COMPRAS1 on tbl_cuentas_contables_por_defecto (ID_CUENTA_DEBE_COMPRAS)^
create index IDX_TBL_CUENTAS_CONTABLES_POR_DEFECTO_ON_ID_CUENTA_A_COBRAR on tbl_cuentas_contables_por_defecto (ID_CUENTA_A_COBRAR)^
create index IDX_TBL_CUENTAS_CONTABLES_POR_DEFECTO_ON_ID_CUENTA_APORTES on tbl_cuentas_contables_por_defecto (ID_CUENTA_APORTES)^
create index IDX_TBL_CUENTAS_CONTABLES_POR_DEFECTO_ON_ID_CUENTA_DONACIONES on tbl_cuentas_contables_por_defecto (ID_CUENTA_DONACIONES)^
create index IDX_TBL_CUENTAS_CONTABLES_POR_DEFECTO_ON_ID_CUENTA_CAJA on tbl_cuentas_contables_por_defecto (ID_CUENTA_CAJA)^
create index IDX_TBL_CUENTAS_CONTABLES_POR_DEFECTO_ON_ID_CUENTA_CTA_CTE on tbl_cuentas_contables_por_defecto (ID_CUENTA_CTA_CTE)^
-- end TBL_CUENTAS_CONTABLES_POR_DEFECTO
-- begin TBL_ENTIDADES
alter table tbl_entidades add constraint FK_TBL_ENTIDADES_ON_ID_FORMA_DE_PAGO_PREFERIDA foreign key (ID_FORMA_DE_PAGO_PREFERIDA) references tbl_formas_de_pago(ID)^
alter table tbl_entidades add constraint FK_TBL_ENTIDADES_ON_ID_ENTIDAD_PAGANTE_APORTES foreign key (ID_ENTIDAD_PAGANTE_APORTES) references tbl_entidades(ID)^
alter table tbl_entidades add constraint FK_TBL_ENTIDADES_ON_ID_AREA_SERVICIO_EN_IGLESIA foreign key (ID_AREA_SERVICIO_EN_IGLESIA) references tbl_areas_servicio_en_iglesia(ID)^
alter table tbl_entidades add constraint FK_TBL_ENTIDADES_ON_ID_MIEMBROS_CATEGORIA_DE_PAGO foreign key (ID_MIEMBROS_CATEGORIA_DE_PAGO) references tbl_miembros_categorias_de_pago(ID)^
alter table tbl_entidades add constraint FK_TBL_ENTIDADES_ON_ID_MIEMBROS_ALERGIA foreign key (ID_MIEMBROS_ALERGIA) references tbl_miembros_alergias(ID)^
alter table tbl_entidades add constraint FK_TBL_ENTIDADES_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
create index IDX_TBL_ENTIDADES_ON_ID_FORMA_DE_PAGO_PREFERIDA on tbl_entidades (ID_FORMA_DE_PAGO_PREFERIDA)^
create index IDX_TBL_ENTIDADES_ON_ID_ENTIDAD_PAGANTE_APORTES on tbl_entidades (ID_ENTIDAD_PAGANTE_APORTES)^
create index IDX_TBL_ENTIDADES_ON_ID_AREA_SERVICIO_EN_IGLESIA on tbl_entidades (ID_AREA_SERVICIO_EN_IGLESIA)^
create index IDX_TBL_ENTIDADES_ON_ID_MIEMBROS_CATEGORIA_DE_PAGO on tbl_entidades (ID_MIEMBROS_CATEGORIA_DE_PAGO)^
create index IDX_TBL_ENTIDADES_ON_ID_MIEMBROS_ALERGIA on tbl_entidades (ID_MIEMBROS_ALERGIA)^
create index IDX_TBL_ENTIDADES_ON_ID_USER on tbl_entidades (ID_USER)^
-- end TBL_ENTIDADES
-- begin TBL_ENTIDADES_HISTORICO_CATEGORIAS
alter table tbl_entidades_historico_categorias add constraint FK_TBL_ENTIDADES_HISTORICO_CATEGORIAS_ON_ID_ENTIDAD foreign key (ID_ENTIDAD) references tbl_entidades(ID)^
alter table tbl_entidades_historico_categorias add constraint FK_TBL_ENTIDADES_HISTORICO_CATEGORIAS_ON_ID_CATEGORIA_DE_PAGO foreign key (ID_CATEGORIA_DE_PAGO) references tbl_miembros_categorias_de_pago(ID)^
create index IDX_TBL_ENTIDADES_HISTORICO_CATEGORIAS_ON_ID_ENTIDAD on tbl_entidades_historico_categorias (ID_ENTIDAD)^
create index IDX_TBL_ENTIDADES_HISTORICO_CATEGORIAS_ON_ID_CATEGORIA_DE_PAGO on tbl_entidades_historico_categorias (ID_CATEGORIA_DE_PAGO)^
-- end TBL_ENTIDADES_HISTORICO_CATEGORIAS
-- begin TBL_EVENTO_DETALLE
alter table tbl_evento_detalle add constraint FK_TBL_EVENTO_DETALLE_ON_ID_ENTIDAD foreign key (ID_ENTIDAD) references tbl_entidades(ID)^
alter table tbl_evento_detalle add constraint FK_TBL_EVENTO_DETALLE_ON_ID_EVENTO foreign key (ID_EVENTO) references tbl_eventos(ID)^
alter table tbl_evento_detalle add constraint FK_TBL_EVENTO_DETALLE_ON_ID_CATEGORIA_ARTICULO foreign key (ID_CATEGORIA_ARTICULO) references tbl_categorias_articulos(ID)^
alter table tbl_evento_detalle add constraint FK_TBL_EVENTO_DETALLE_ON_ID_FORMA_DE_PAGO_PREFERIDA foreign key (ID_FORMA_DE_PAGO_PREFERIDA) references tbl_formas_de_pago(ID)^
alter table tbl_evento_detalle add constraint FK_TBL_EVENTO_DETALLE_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
create index IDX_TBL_EVENTO_DETALLE_ON_ID_ENTIDAD on tbl_evento_detalle (ID_ENTIDAD)^
create index IDX_TBL_EVENTO_DETALLE_ON_ID_EVENTO on tbl_evento_detalle (ID_EVENTO)^
create index IDX_TBL_EVENTO_DETALLE_ON_ID_CATEGORIA_ARTICULO on tbl_evento_detalle (ID_CATEGORIA_ARTICULO)^
create index IDX_TBL_EVENTO_DETALLE_ON_ID_FORMA_DE_PAGO_PREFERIDA on tbl_evento_detalle (ID_FORMA_DE_PAGO_PREFERIDA)^
create index IDX_TBL_EVENTO_DETALLE_ON_ID_USER on tbl_evento_detalle (ID_USER)^
-- end TBL_EVENTO_DETALLE
-- begin TBL_EVENTOS
alter table tbl_eventos add constraint FK_TBL_EVENTOS_ON_ID_EVENTO_TIPO foreign key (ID_EVENTO_TIPO) references tbl_evento_tipos(ID)^
alter table tbl_eventos add constraint FK_TBL_EVENTOS_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
alter table tbl_eventos add constraint FK_TBL_EVENTOS_ON_ID_GRUPO foreign key (ID_GRUPO) references tbl_grupos(ID)^
alter table tbl_eventos add constraint FK_TBL_EVENTOS_ON_ID_CENTRO_DE_COSTO foreign key (ID_CENTRO_DE_COSTO) references tbl_centros_de_costo(ID)^
create index IDX_TBL_EVENTOS_ON_ID_EVENTO_TIPO on tbl_eventos (ID_EVENTO_TIPO)^
create index IDX_TBL_EVENTOS_ON_ID_USER on tbl_eventos (ID_USER)^
create index IDX_TBL_EVENTOS_ON_ID_GRUPO on tbl_eventos (ID_GRUPO)^
create index IDX_TBL_EVENTOS_ON_ID_CENTRO_DE_COSTO on tbl_eventos (ID_CENTRO_DE_COSTO)^
-- end TBL_EVENTOS
-- begin TBL_FACTURAS
alter table tbl_facturas add constraint FK_TBL_FACTURAS_ON_ID_TIMBRADO foreign key (ID_TIMBRADO) references tbl_timbrados(nro)^
alter table tbl_facturas add constraint FK_TBL_FACTURAS_ON_ID_ENTIDAD foreign key (ID_ENTIDAD) references tbl_entidades(ID)^
alter table tbl_facturas add constraint FK_TBL_FACTURAS_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
create index IDX_TBL_FACTURAS_ON_ID_TIMBRADO on tbl_facturas (ID_TIMBRADO)^
create index IDX_TBL_FACTURAS_ON_ID_ENTIDAD on tbl_facturas (ID_ENTIDAD)^
create index IDX_TBL_FACTURAS_ON_ID_USER on tbl_facturas (ID_USER)^
-- end TBL_FACTURAS
-- begin TBL_FACTURAS_COMPRA
alter table tbl_facturas_compra add constraint FK_TBL_FACTURAS_COMPRA_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
create index IDX_TBL_FACTURAS_COMPRA_ON_ID_USER on tbl_facturas_compra (ID_USER)^
-- end TBL_FACTURAS_COMPRA
-- begin TBL_MIEMBROS_RELACIONES
alter table tbl_miembros_relaciones add constraint FK_TBL_MIEMBROS_RELACIONES_ON_ID_MIEMBROS_FAMILIA foreign key (ID_MIEMBROS_FAMILIA) references tbl_miembros_familias(ID)^
alter table tbl_miembros_relaciones add constraint FK_TBL_MIEMBROS_RELACIONES_ON_ID_ENTIDAD_1 foreign key (ID_ENTIDAD_1) references tbl_entidades(ID)^
alter table tbl_miembros_relaciones add constraint FK_TBL_MIEMBROS_RELACIONES_ON_ID_ENTIDAD_2 foreign key (ID_ENTIDAD_2) references tbl_entidades(ID)^
alter table tbl_miembros_relaciones add constraint FK_TBL_MIEMBROS_RELACIONES_ON_ID_MIEMBROS_RELACIONES_TIPO foreign key (ID_MIEMBROS_RELACIONES_TIPO) references tbl_miembros_relaciones_tipos(ID)^
alter table tbl_miembros_relaciones add constraint FK_TBL_MIEMBROS_RELACIONES_ON_ID_MIEMBROS_RELACIONES_ROL_1 foreign key (ID_MIEMBROS_RELACIONES_ROL_1) references tbl_miembros_relaciones_roles(ID)^
alter table tbl_miembros_relaciones add constraint FK_TBL_MIEMBROS_RELACIONES_ON_ID_MIEMBROS_RELACIONES_ROL_2 foreign key (ID_MIEMBROS_RELACIONES_ROL_2) references tbl_miembros_relaciones_roles(ID)^
alter table tbl_miembros_relaciones add constraint FK_TBL_MIEMBROS_RELACIONES_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
create index IDX_TBL_MIEMBROS_RELACIONES_ON_ID_MIEMBROS_FAMILIA on tbl_miembros_relaciones (ID_MIEMBROS_FAMILIA)^
create index IDX_TBL_MIEMBROS_RELACIONES_ON_ID_ENTIDAD_1 on tbl_miembros_relaciones (ID_ENTIDAD_1)^
create index IDX_TBL_MIEMBROS_RELACIONES_ON_ID_ENTIDAD_2 on tbl_miembros_relaciones (ID_ENTIDAD_2)^
create index IDX_TBL_MIEMBROS_RELACIONES_ON_ID_MIEMBROS_RELACIONES_TIPO on tbl_miembros_relaciones (ID_MIEMBROS_RELACIONES_TIPO)^
create index IDX_TBL_MIEMBROS_RELACIONES_ON_ID_MIEMBROS_RELACIONES_ROL_1 on tbl_miembros_relaciones (ID_MIEMBROS_RELACIONES_ROL_1)^
create index IDX_TBL_MIEMBROS_RELACIONES_ON_ID_MIEMBROS_RELACIONES_ROL_2 on tbl_miembros_relaciones (ID_MIEMBROS_RELACIONES_ROL_2)^
create index IDX_TBL_MIEMBROS_RELACIONES_ON_ID_USER on tbl_miembros_relaciones (ID_USER)^
-- end TBL_MIEMBROS_RELACIONES
-- begin TBL_NOTAS_DE_CREDITO
alter table tbl_notas_de_credito add constraint FK_TBL_NOTAS_DE_CREDITO_ON_ID_TIMBRADO foreign key (ID_TIMBRADO) references tbl_timbrados_notas_de_credito(ID)^
alter table tbl_notas_de_credito add constraint FK_TBL_NOTAS_DE_CREDITO_ON_NRO_FACTURA foreign key (NRO_FACTURA) references tbl_facturas(nro)^
alter table tbl_notas_de_credito add constraint FK_TBL_NOTAS_DE_CREDITO_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
create index IDX_TBL_NOTAS_DE_CREDITO_ON_ID_TIMBRADO on tbl_notas_de_credito (ID_TIMBRADO)^
create index IDX_TBL_NOTAS_DE_CREDITO_ON_NRO_FACTURA on tbl_notas_de_credito (NRO_FACTURA)^
create index IDX_TBL_NOTAS_DE_CREDITO_ON_ID_USER on tbl_notas_de_credito (ID_USER)^
-- end TBL_NOTAS_DE_CREDITO
-- begin TBL_NOTAS_DE_CREDITO_COMPRAS
alter table tbl_notas_de_credito_compras add constraint FK_TBL_NOTAS_DE_CREDITO_COMPRAS_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
create index IDX_TBL_NOTAS_DE_CREDITO_COMPRAS_ON_ID_USER on tbl_notas_de_credito_compras (ID_USER)^
-- end TBL_NOTAS_DE_CREDITO_COMPRAS
-- begin TBL_RECIBOS
alter table tbl_recibos add constraint FK_TBL_RECIBOS_ON_ID_ENTIDAD foreign key (ID_ENTIDAD) references tbl_entidades(ID)^
alter table tbl_recibos add constraint FK_TBL_RECIBOS_ON_ID_EVENTO_TIPO foreign key (ID_EVENTO_TIPO) references tbl_evento_tipos(ID)^
alter table tbl_recibos add constraint FK_TBL_RECIBOS_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
alter table tbl_recibos add constraint FK_TBL_RECIBOS_ON_ID_EVENTO foreign key (ID_EVENTO) references tbl_eventos(ID)^
create index IDX_TBL_RECIBOS_ON_ID_ENTIDAD on tbl_recibos (ID_ENTIDAD)^
create index IDX_TBL_RECIBOS_ON_ID_EVENTO_TIPO on tbl_recibos (ID_EVENTO_TIPO)^
create index IDX_TBL_RECIBOS_ON_ID_USER on tbl_recibos (ID_USER)^
create index IDX_TBL_RECIBOS_ON_ID_EVENTO on tbl_recibos (ID_EVENTO)^
-- end TBL_RECIBOS
-- begin TBL_RECIBOS_COMPRA
alter table tbl_recibos_compra add constraint FK_TBL_RECIBOS_COMPRA_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
create index IDX_TBL_RECIBOS_COMPRA_ON_ID_USER on tbl_recibos_compra (ID_USER)^
-- end TBL_RECIBOS_COMPRA
-- begin TBL_TIMBRADOS
alter table tbl_timbrados add constraint FK_TBL_TIMBRADOS_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
create index IDX_TBL_TIMBRADOS_ON_ID_USER on tbl_timbrados (ID_USER)^
-- end TBL_TIMBRADOS
-- begin TBL_TIMBRADOS_AUTOFACTURAS
alter table tbl_timbrados_autofacturas add constraint FK_TBL_TIMBRADOS_AUTOFACTURAS_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
create index IDX_TBL_TIMBRADOS_AUTOFACTURAS_ON_ID_USER on tbl_timbrados_autofacturas (ID_USER)^
-- end TBL_TIMBRADOS_AUTOFACTURAS
-- begin TBL_TIMBRADOS_NOTAS_DE_CREDITO
alter table tbl_timbrados_notas_de_credito add constraint FK_TBL_TIMBRADOS_NOTAS_DE_CREDITO_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
create index IDX_TBL_TIMBRADOS_NOTAS_DE_CREDITO_ON_ID_USER on tbl_timbrados_notas_de_credito (ID_USER)^
-- end TBL_TIMBRADOS_NOTAS_DE_CREDITO
-- begin TBL_TRANSFERENCIAS
alter table tbl_transferencias add constraint FK_TBL_TRANSFERENCIAS_ON_ID_ENTIDAD foreign key (ID_ENTIDAD) references tbl_entidades(ID)^
alter table tbl_transferencias add constraint FK_TBL_TRANSFERENCIAS_ON_ID_EVENTO_TIPO foreign key (ID_EVENTO_TIPO) references tbl_evento_tipos(ID)^
alter table tbl_transferencias add constraint FK_TBL_TRANSFERENCIAS_ON_ID_USER foreign key (ID_USER) references tbl_users(ID)^
alter table tbl_transferencias add constraint FK_TBL_TRANSFERENCIAS_ON_ID_EVENTO foreign key (ID_EVENTO) references tbl_eventos(ID)^
alter table tbl_transferencias add constraint FK_TBL_TRANSFERENCIAS_ON_ID_EVENTO_DETALLE foreign key (ID_EVENTO_DETALLE) references tbl_evento_detalle(ID)^
create index IDX_TBL_TRANSFERENCIAS_ON_ID_ENTIDAD on tbl_transferencias (ID_ENTIDAD)^
create index IDX_TBL_TRANSFERENCIAS_ON_ID_EVENTO_TIPO on tbl_transferencias (ID_EVENTO_TIPO)^
create index IDX_TBL_TRANSFERENCIAS_ON_ID_USER on tbl_transferencias (ID_USER)^
create index IDX_TBL_TRANSFERENCIAS_ON_ID_EVENTO on tbl_transferencias (ID_EVENTO)^
create index IDX_TBL_TRANSFERENCIAS_ON_ID_EVENTO_DETALLE on tbl_transferencias (ID_EVENTO_DETALLE)^
-- end TBL_TRANSFERENCIAS
-- begin TBL_AUTOFACTURAS_ASIENTOS
alter table tbl_autofacturas_asientos add constraint FK_TBLAUTASI_ON_TBL_AUTOFACTURAS foreign key (id_autofactura) references tbl_autofacturas(ID)^
alter table tbl_autofacturas_asientos add constraint FK_TBLAUTASI_ON_TBL_ASIENTOS foreign key (id_asiento) references tbl_asientos(ID)^
-- end TBL_AUTOFACTURAS_ASIENTOS
-- begin TBL_NOTAS_DE_CREDITO_ASIENTOS
alter table tbl_notas_de_credito_asientos add constraint FK_TBLNOTDECREASI_ON_TBL_NOTAS_DE_CREDITO foreign key (id_nota_de_credito) references tbl_notas_de_credito(ID)^
alter table tbl_notas_de_credito_asientos add constraint FK_TBLNOTDECREASI_ON_TBL_ASIENTOS foreign key (id_asiento) references tbl_asientos(ID)^
-- end TBL_NOTAS_DE_CREDITO_ASIENTOS
-- begin TBL_FACTURAS_COMPRA_ASIENTOS
alter table tbl_facturas_compra_asientos add constraint FK_TBLFACCOMASI_ON_TBL_FACTURAS_COMPRA foreign key (id_factura_compra) references tbl_facturas_compra(ID)^
alter table tbl_facturas_compra_asientos add constraint FK_TBLFACCOMASI_ON_TBL_ASIENTOS foreign key (id_asiento) references tbl_asientos(ID)^
-- end TBL_FACTURAS_COMPRA_ASIENTOS
-- begin TBL_EVENTO_DETALLE_ASIENTOS
alter table tbl_evento_detalle_asientos add constraint FK_TBLEVEDETASI_ON_TBL_EVENTO_DETALLE foreign key (id_evento_detalle) references tbl_evento_detalle(ID)^
alter table tbl_evento_detalle_asientos add constraint FK_TBLEVEDETASI_ON_TBL_ASIENTOS foreign key (id_asiento) references tbl_asientos(ID)^
-- end TBL_EVENTO_DETALLE_ASIENTOS
-- begin TBL_ASIENTOS_ASIENTOS_TEMPORALES
alter table tbl_asientos_asientos_temporales add constraint FK_TBLASIASITEM_ON_TBL_ASIENTOS_TEMPORALES foreign key (id_asiento_temporal) references tbl_asientos_temporales(ID)^
alter table tbl_asientos_asientos_temporales add constraint FK_TBLASIASITEM_ON_TBL_ASIENTOS foreign key (id_asiento) references tbl_asientos(ID)^
-- end TBL_ASIENTOS_ASIENTOS_TEMPORALES
-- begin TBL_FACTURAS_ASIENTOS
alter table tbl_facturas_asientos add constraint FK_TBLFACASI_ON_TBL_FACTURAS foreign key (nro_factura) references tbl_facturas(nro)^
alter table tbl_facturas_asientos add constraint FK_TBLFACASI_ON_TBL_ASIENTOS foreign key (id_asiento) references tbl_asientos(ID)^
-- end TBL_FACTURAS_ASIENTOS
-- begin TBL_NOTAS_DE_CREDITO_COMPRAS_ASIENTOS
alter table tbl_notas_de_credito_compras_asientos add constraint FK_TBLNOTDECRECOMASI_ON_TBL_NOTAS_DE_CREDITO_COMPRAS foreign key (id_nota_de_credito) references tbl_notas_de_credito_compras(ID)^
alter table tbl_notas_de_credito_compras_asientos add constraint FK_TBLNOTDECRECOMASI_ON_TBL_ASIENTOS foreign key (id_asiento) references tbl_asientos(ID)^
-- end TBL_NOTAS_DE_CREDITO_COMPRAS_ASIENTOS
-- begin TBL_RECIBOS_COMPRA_FACTURAS_COMPRA
alter table tbl_recibos_compra_facturas_compra add constraint FK_TBLRECCOMFACCOM_ON_TBL_RECIBOS_COMPRA foreign key (id_recibo) references tbl_recibos_compra(ID)^
alter table tbl_recibos_compra_facturas_compra add constraint FK_TBLRECCOMFACCOM_ON_TBL_FACTURAS_COMPRA foreign key (id_factura_compra) references tbl_facturas_compra(ID)^
-- end TBL_RECIBOS_COMPRA_FACTURAS_COMPRA
-- begin TBL_RECIBOS_COMPRA_ASIENTOS
alter table tbl_recibos_compra_asientos add constraint FK_TBLRECCOMASI_ON_TBL_RECIBOS_COMPRA foreign key (id_recibo) references tbl_recibos_compra(ID)^
alter table tbl_recibos_compra_asientos add constraint FK_TBLRECCOMASI_ON_TBL_ASIENTOS foreign key (id_asiento) references tbl_asientos(ID)^
-- end TBL_RECIBOS_COMPRA_ASIENTOS
-- begin TBL_RECIBOS_ASIENTOS_TEMPORALES
alter table tbl_recibos_asientos_temporales add constraint FK_TBLRECASITEM_ON_TBL_RECIBOS foreign key (id_recibo) references tbl_recibos(ID)^
alter table tbl_recibos_asientos_temporales add constraint FK_TBLRECASITEM_ON_TBL_ASIENTOS_TEMPORALES foreign key (id_asiento_temporal) references tbl_asientos_temporales(ID)^
-- end TBL_RECIBOS_ASIENTOS_TEMPORALES
-- begin TBL_GRUPOS_USERS
alter table tbl_grupos_users add constraint FK_TBLGRUUSE_ON_TBL_USERS foreign key (id_user) references tbl_users(ID)^
alter table tbl_grupos_users add constraint FK_TBLGRUUSE_ON_TBL_GRUPOS foreign key (id_grupo) references tbl_grupos(ID)^
-- end TBL_GRUPOS_USERS
-- begin TBL_TRANSFERENCIAS_ASIENTOS_TEMPORALES
alter table tbl_transferencias_asientos_temporales add constraint FK_TBLTRAASITEM_ON_TBL_TRANSFERENCIAS foreign key (id_transferencia) references tbl_transferencias(ID)^
alter table tbl_transferencias_asientos_temporales add constraint FK_TBLTRAASITEM_ON_TBL_ASIENTOS_TEMPORALES foreign key (id_asiento_temporal) references tbl_asientos_temporales(ID)^
-- end TBL_TRANSFERENCIAS_ASIENTOS_TEMPORALES
-- begin TBL_ROLES_USERS
alter table tbl_roles_users add constraint FK_TBLROLUSE_ON_TBL_USERS foreign key (id_user) references tbl_users(ID)^
alter table tbl_roles_users add constraint FK_TBLROLUSE_ON_TBL_ROLES foreign key (id_role) references tbl_roles(ID)^
-- end TBL_ROLES_USERS
