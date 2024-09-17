--O arquivo "data.sql" executa operacoes em um banco de dados H2, que e um banco em memoria apenas
--para praticar e estudar

CREATE TABLE task (
    id integer primary key auto_increment not null,
    taskName varchar(100) not null,
    beginDate timestamp,
    endDate timestamp,
    notes varchar(500)
);