create database vendas;

use vendas;

create table cliente
( cli_id int primary key auto_increment,
  cli_nome varchar(100) not null,
  cli_cpf varchar(14) not null unique,
  cli_email varchar(100) not null,
  cli_telefone varchar(20) not null,
  cli_endereco varchar(200) not null,
  cli_data_nascimento date not null);
  
  select * from cliente;