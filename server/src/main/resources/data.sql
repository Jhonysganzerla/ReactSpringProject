
insert into user (id,username, displayname, password) values (1, 'admin', 'admin', 'admin');
insert into user (id,username, displayname, password) values (2, 'user', 'user', 'user');
insert into user (id,username, displayname, password) values (3, 'user1', 'name', 'password');
insert into user (id,username, displayname, password) values (4, 'user2', 'name', 'password');

insert into conta (id,user_id, numero, agencia, banco, tipoconta) values (1, 1, '123456789', '123', 'Itau', 'CC');
insert into conta (id,user_id, numero, agencia, banco, tipoconta) values (2, 2, '987654321', '123', 'Bradesco', 'CC');
insert into conta (id,user_id, numero, agencia, banco, tipoconta) values (3, 1, '123456789', '123', 'Itau', 'CP');
insert into conta (id,user_id, numero, agencia, banco, tipoconta) values (4, 2, '987654321', '123', 'Bradesco', 'CP');
insert into conta (id,user_id, numero, agencia, banco, tipoconta) values (5, 1, '123456789', '123', 'TESTE', 'CARTAO');
insert into conta (id,user_id, numero, agencia, banco, tipoconta) values (6, 1, '987654321', '123', 'Bradesco', 'CC');
insert into conta (id,user_id, numero, agencia, banco, tipoconta) values (7, 3, '123456789', '123', 'Itau', 'CP');

insert into movimento (id,conta_id, valor, datavencimento, datapagamento, valorpago, categoria, descricao, movimentotipo) values (1, 1, 100, '2020-01-01', '2020-01-01', 100, 'Alimentacao', 'Alimentacao', 'RECEITA');
insert into movimento (id,conta_id, valor, datavencimento, datapagamento, valorpago, categoria, descricao, movimentotipo) values (2, 1, 100, '2020-01-01', '2020-01-01', 100, 'Transporte', 'Transporte', 'DESPESA');
