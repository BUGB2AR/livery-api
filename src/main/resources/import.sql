insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into forma_pagamento  (id, descricao) values (1, 'PIX');
insert into forma_pagamento  (id, descricao) values (2, 'DINHEIRO');

insert into estado (id, nome) values (1, 'CE');
insert into estado (id, nome) values (2, 'SC');

insert into cidade (nome, cidade_id) values ('FORTALEZA', 1 );
insert into cidade (nome, cidade_id) values ('JOINVILE',  2 );

insert into permissao (id, descricao) values (1, 'ADMIN');
insert into permissao (id, descricao) values (2, 'CLIENTE');


insert into restaurante (nome, taxa_frete, cozinha_id,forma_pagamento_id) values ('Thai Gourmet', 10, 1, 2);
insert into restaurante (nome, taxa_frete, cozinha_id,forma_pagamento_id) values ('Thai Delivery', 11, 1, 1);
insert into restaurante (nome, taxa_frete, cozinha_id,forma_pagamento_id) values ('Tuk Tuk Comida Indiana', 12, 2, 2);