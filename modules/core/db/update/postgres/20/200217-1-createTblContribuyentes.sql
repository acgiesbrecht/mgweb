create table TBL_CONTRIBUYENTES (
    ID serial,
    --
    RUC_SIN_DV varchar(20) not null,
    DV varchar(1) not null,
    RAZON_SOCIAL varchar(255) not null,
    --
    primary key (ID)
);