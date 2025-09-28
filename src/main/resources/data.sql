-- Insert Data User total 40 data
TRUNCATE public.users;
ALTER SEQUENCE users_id_seq RESTART WITH 1;

INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person1', 'last human', 'person1@gmail.com', '08888888881', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person2', 'last human', 'person2@gmail.com', '08888888882', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person3', 'last human', 'person3@gmail.com', '08888888883', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person4', 'last human', 'person4@gmail.com', '08888888884', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person5', 'last human', 'person5@gmail.com', '08888888885', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person6', 'last human', 'person6@gmail.com', '08888888886', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person7', 'last human', 'person7@gmail.com', '08888888887', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person8', 'last human', 'person8@gmail.com', '08888888888', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person9', 'last human', 'person9@gmail.com', '08888888889', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person10', 'last human', 'person10@gmail.com', '08888888810', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person11', 'last human', 'person11@gmail.com', '08888888811', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person12', 'last human', 'person12@gmail.com', '08888888812', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person13', 'last human', 'person13@gmail.com', '08888888813', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person14', 'last human', 'person14@gmail.com', '08888888814', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person15', 'last human', 'person15@gmail.com', '08888888815', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person16', 'last human', 'person16@gmail.com', '08888888816', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person17', 'last human', 'person17@gmail.com', '08888888817', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person18', 'last human', 'person18@gmail.com', '08888888818', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person19', 'last human', 'person19@gmail.com', '08888888819', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person20', 'last human', 'person20@gmail.com', '08888888820', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person21', 'last human', 'person21@gmail.com', '08888888821', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person22', 'last human', 'person22@gmail.com', '08888888822', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person23', 'last human', 'person23@gmail.com', '08888888823', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person24', 'last human', 'person24@gmail.com', '08888888824', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person25', 'last human', 'person25@gmail.com', '08888888825', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person26', 'last human', 'person26@gmail.com', '08888888826', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person27', 'last human', 'person27@gmail.com', '08888888827', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person28', 'last human', 'person28@gmail.com', '08888888828', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person29', 'last human', 'person29@gmail.com', '08888888829', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person30', 'last human', 'person30@gmail.com', '08888888830', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person31', 'last human', 'person31@gmail.com', '08888888831', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person32', 'last human', 'person32@gmail.com', '08888888832', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person33', 'last human', 'person33@gmail.com', '08888888833', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person34', 'last human', 'person34@gmail.com', '08888888834', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person35', 'last human', 'person35@gmail.com', '08888888835', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person36', 'last human', 'person36@gmail.com', '08888888836', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person37', 'last human', 'person37@gmail.com', '08888888837', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person38', 'last human', 'person38@gmail.com', '08888888838', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person39', 'last human', 'person39@gmail.com', '08888888839', 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.users
(id, first_name, last_name, email, phone, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('users_id_seq'::regclass), 'person40', 'last human', 'person40@gmail.com', '08888888840', 'SYSTEM', 'SYSTEM', NOW(), NOW());

-- Insert Data Item total 40 data
TRUNCATE public.items;
ALTER SEQUENCE items_id_seq RESTART WITH 1;

INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang1', 'Deskripsi Barang 1', 1000, 500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang2', 'Deskripsi Barang 2', 2000, 1000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang3', 'Deskripsi Barang 3', 3000, 1500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang4', 'Deskripsi Barang 4', 4000, 2000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang5', 'Deskripsi Barang 5', 5000, 2500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang6', 'Deskripsi Barang 6', 6000, 3000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang7', 'Deskripsi Barang 7', 7000, 3500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang8', 'Deskripsi Barang 8', 8000, 4000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang9', 'Deskripsi Barang 9', 9000, 4500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang10', 'Deskripsi Barang 10', 10000, 5000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang11', 'Deskripsi Barang 11', 11000, 5500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang12', 'Deskripsi Barang 12', 12000, 6000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang13', 'Deskripsi Barang 13', 13000, 6500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang14', 'Deskripsi Barang 14', 14000, 7000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang15', 'Deskripsi Barang 15', 15000, 7500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang16', 'Deskripsi Barang 16', 16000, 8000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang17', 'Deskripsi Barang 17', 17000, 8500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang18', 'Deskripsi Barang 18', 18000, 9000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang19', 'Deskripsi Barang 19', 19000, 9500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang20', 'Deskripsi Barang 20', 20000, 10000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang21', 'Deskripsi Barang 21', 21000, 10500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang22', 'Deskripsi Barang 22', 22000, 11000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang23', 'Deskripsi Barang 23', 23000, 11500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang24', 'Deskripsi Barang 24', 24000, 12000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang25', 'Deskripsi Barang 25', 25000, 12500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang26', 'Deskripsi Barang 26', 26000, 13000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang27', 'Deskripsi Barang 27', 27000, 13500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang28', 'Deskripsi Barang 28', 28000, 14000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang29', 'Deskripsi Barang 29', 29000, 14500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang30', 'Deskripsi Barang 30', 30000, 15000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang31', 'Deskripsi Barang 31', 31000, 15500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang32', 'Deskripsi Barang 32', 32000, 16000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang33', 'Deskripsi Barang 33', 33000, 16500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang34', 'Deskripsi Barang 34', 34000, 17000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang35', 'Deskripsi Barang 35', 35000, 17500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang36', 'Deskripsi Barang 36', 36000, 18000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang37', 'Deskripsi Barang 37', 37000, 18500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang38', 'Deskripsi Barang 38', 38000, 19000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang39', 'Deskripsi Barang 39', 39000, 19500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.items
(id, name, description, price, cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('items_id_seq'::regclass), 'Barang40', 'Deskripsi Barang 40', 40000, 20000, 'SYSTEM', 'SYSTEM', NOW(), NOW());

-- Insert Data Purchase Order Header total 40 data
TRUNCATE public.po_h CASCADE;
ALTER SEQUENCE po_h_id_seq RESTART WITH 1;

INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 1', 1000, 500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 2', 2000, 1000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 3', 3000, 1500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 4', 4000, 2000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 5', 5000, 2500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 6', 6000, 3000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 7', 7000, 3500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 8', 8000, 4000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 9', 9000, 4500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 10', 10000, 5000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 11', 11000, 5500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 12', 12000, 6000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 13', 13000, 6500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 14', 14000, 7000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 15', 15000, 7500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 16', 16000, 8000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 17', 17000, 8500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 18', 18000, 9000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 19', 19000, 9500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 20', 20000, 10000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 21', 21000, 10500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 22', 22000, 11000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 23', 23000, 11500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 24', 24000, 12000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 25', 25000, 12500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 26', 26000, 13000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 27', 27000, 13500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 28', 28000, 14000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 29', 29000, 14500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 30', 30000, 15000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 31', 31000, 15500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 32', 32000, 16000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 33', 33000, 16500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 34', 34000, 17000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 35', 35000, 17500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 36', 36000, 18000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 37', 37000, 18500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 38', 38000, 19000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 39', 39000, 19500, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_h
(id, datetime, desciption, total_price, total_cost, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_h_id_seq'::regclass), NOW(), 'Transaksi 40', 40000, 20000, 'SYSTEM', 'SYSTEM', NOW(), NOW());

-- Insert Data Purchase Order Detail total 40 data
TRUNCATE public.po_d;
ALTER SEQUENCE po_d_id_seq RESTART WITH 1;

INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 1, 1, 1, 500, 1000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 2, 2, 1, 1000, 2000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 3, 3, 1, 1500, 3000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 4, 4, 1, 2000, 4000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 5, 5, 1, 2500, 5000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 6, 6, 1, 3000, 6000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 7, 7, 1, 3500, 7000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 8, 8, 1, 4000, 8000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 9, 9, 1, 4500, 9000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 10, 10, 1, 5000, 10000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 11, 11, 1, 5500, 11000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 12, 12, 1, 6000, 12000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 13, 13, 1, 6500, 13000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 14, 14, 1, 7000, 14000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 15, 15, 1, 7500, 15000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 16, 16, 1, 8000, 16000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 17, 17, 1, 8500, 17000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 18, 18, 1, 9000, 18000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 19, 19, 1, 9500, 19000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 20, 20, 1, 10000, 20000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 21, 21, 1, 10500, 21000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 22, 22, 1, 11000, 22000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 23, 23, 1, 11500, 23000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 24, 24, 1, 12000, 24000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 25, 25, 1, 12500, 25000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 26, 26, 1, 13000, 26000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 27, 27, 1, 13500, 27000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 28, 28, 1, 14000, 28000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 29, 29, 1, 14500, 29000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 30, 30, 1, 15000, 30000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 31, 31, 1, 15500, 31000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 32, 32, 1, 16000, 32000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 33, 33, 1, 16500, 33000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 34, 34, 1, 17000, 34000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 35, 35, 1, 17500, 35000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 36, 36, 1, 18000, 36000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 37, 37, 1, 18500, 37000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 38, 38, 1, 19000, 38000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 39, 39, 1, 19500, 39000, 'SYSTEM', 'SYSTEM', NOW(), NOW());
INSERT INTO public.po_d
(id, poh_id, item_id, item_qty, item_cost, item_price, created_by, updated_by, created_datetime, updated_datetime)
VALUES(nextval('po_d_id_seq'::regclass), 40, 40, 1, 20000, 40000, 'SYSTEM', 'SYSTEM', NOW(), NOW());

