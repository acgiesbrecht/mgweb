-- update tbl_eventos set ID_CENTRO_DE_COSTO = <default_value> where ID_CENTRO_DE_COSTO is null ;
alter table tbl_eventos alter column ID_CENTRO_DE_COSTO set not null ;
