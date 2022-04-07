
insert into users (username, displayName, password) values ('admin', 'admin', 'admin');
insert into users (username, displayName, password) values ('user', 'user', 'user');
insert into users (username, displayName, password) values ('user1', 'name', 'password');
insert into users (username, displayName, password) values ('user2', 'name', 'password');

insert into conta (user, numero, agencia, banco, tipoconta) values (1, '123456789', '123', 'Itau', 'CC');
insert into conta (user, numero, agencia, banco, tipoconta) values (2, '987654321', '123', 'Bradesco', 'CC');
insert into conta (user, numero, agencia, banco, tipoconta) values (1, '123456789', '123', 'Itau', 'CP');
insert into conta (user, numero, agencia, banco, tipoconta) values (2, '987654321', '123', 'Bradesco', 'CP');
insert into conta (user, numero, agencia, banco, tipoconta) values (1, '123456789', '123', 'TESTE', 'CARTAO');
insert into conta (user, numero, agencia, banco, tipoconta) values (1, '987654321', '123', 'Bradesco', 'CC');
insert into conta (user, numero, agencia, banco, tipoconta) values (3, '123456789', '123', 'Itau', 'CP');

insert into movimento (conta, valor, dataVencimento, dataPagamento, valorPago, categoria, descricao, movimentoTipo) values (1, 100, '2020-01-01', '2020-01-01', 100, 'Alimentacao', 'Alimentacao', 'RECEITA');
insert into movimento (conta, valor, dataVencimento, dataPagamento, valorPago, categoria, descricao, movimentoTipo) values (1, 100, '2020-01-01', '2020-01-01', 100, 'Transporte', 'Transporte', 'DESPESA');
