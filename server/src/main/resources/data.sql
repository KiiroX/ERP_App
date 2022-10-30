INSERT INTO users (name, email) VALUES ('Andre', 'andre@gmail.com');
INSERT INTO users (name, email) VALUES ('Clang', 'clang@gmail.com');
INSERT INTO users (name, email) VALUES ('Yosi', 'yosi@gmail.com');

INSERT INTO supplier (name, country) VALUES ('Juani', 'Venezuela');
INSERT INTO supplier (name, country) VALUES ('Antonio', 'Venezuela');
INSERT INTO supplier (name, country) VALUES ('Johana', 'Spain');
INSERT INTO supplier (name, country) VALUES ('Buddy', 'Spain');

INSERT INTO item (item_code, description, price, state, creation_date, creator_id_user, supplier_id_supplier) VALUES(1234, 'Item 1234', 20, 'ACTIVE', '2022-10-27', 1, 1);
INSERT INTO item (item_code, description, price, state, creation_date, creator_id_user, supplier_id_supplier) VALUES(1235, 'Item 1235', 10, 'ACTIVE', '2022-10-15', 2, 1);
INSERT INTO item (item_code, description, price, state, creation_date, creator_id_user, supplier_id_supplier) VALUES(1236, 'Item 1236', 5.5, 'DISCONTINUED', '2022-10-10', 3, 1);
INSERT INTO item (item_code, description, price, state, creation_date, creator_id_user, supplier_id_supplier) VALUES(1237, 'Item 1237', 0.5, 'DISCONTINUED', '2022-10-28', 1, 2);
INSERT INTO item (item_code, description, price, state, creation_date, creator_id_user, supplier_id_supplier) VALUES(1238, 'Item 1238', 13, 'ACTIVE', '2022-10-01', 2, 2);
INSERT INTO item (item_code, description, price, state, creation_date, creator_id_user, supplier_id_supplier) VALUES(1239, 'Item 1239', 20, 'DISCONTINUED', '2022-10-27', 3, 2);
INSERT INTO item (item_code, description, price, state, creation_date, creator_id_user, supplier_id_supplier) VALUES(1210, 'Item 1210', 39.99, 'ACTIVE', '2022-10-15', 3, 3);
INSERT INTO item (item_code, description, price, state, creation_date, creator_id_user, supplier_id_supplier) VALUES(1211, 'Item 1211', 10, 'DISCONTINUED', '2022-10-10', 2, 3);
INSERT INTO item (item_code, description, price, state, creation_date, creator_id_user, supplier_id_supplier) VALUES(1212, 'Item 1212', 100, 'ACTIVE', '2022-10-28', 1, 3);
INSERT INTO item (item_code, description, price, state, creation_date, creator_id_user, supplier_id_supplier) VALUES(1213, 'Item 1213', 7, 'ACTIVE', '2022-10-01', 3, 4);

INSERT INTO reduced_price (reduced_price, start_date, end_date, item_id_item) VALUES (30, '2022-11-01', '2022-11-05', 7);
INSERT INTO reduced_price (reduced_price, start_date, end_date, item_id_item) VALUES (8, '2022-11-01', '2022-11-07', 2);
INSERT INTO reduced_price (reduced_price, start_date, end_date, item_id_item) VALUES (80, '2022-11-12', '2022-11-13', 9);
INSERT INTO reduced_price (reduced_price, start_date, end_date, item_id_item) VALUES (30, '2022-12-01', '2022-12-05', 7);