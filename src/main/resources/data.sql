INSERT INTO tb_address (place, complement, district, city, state, postal_code)
VALUES ('Rua Angelo Pucci','','Vila Lucimar','Inhumas','GO','75403-592');
INSERT INTO tb_address (place, complement, district, city, state, postal_code)
VALUES ('Rua SMR 7','','Village Santa Rita','Goiânia','GO','74395-018');

INSERT INTO tb_user (name,email,cpf,birth_date) VALUES('Kaio Rocha Ribeiro','kaio.rocharibeiro@gmail.com','02813642142', '1988-07-06');
INSERT INTO tb_user (name,email,cpf,birth_date) VALUES('Anna Vitória Rodrigues Rocha','annavitoria@gmail.com','02525525445','2017-11-22');

INSERT INTO tb_user_address (user_id,address_id) VALUES (1,2);
INSERT INTO tb_user_address (user_id,address_id) VALUES (1,1);
INSERT INTO tb_user_address (user_id,address_id) VALUES (2,1);
INSERT INTO tb_user_address (user_id,address_id) VALUES (2,2);
