alter table consultas add motivoCancelamento varchar(100) not null;
update consultas set motivoCancelamento = null;