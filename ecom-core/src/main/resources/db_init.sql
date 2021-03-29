create table if not exists t_bills
(
    id varchar(50) not null
        primary key,
    customer_code varchar(50) null,
    customer_name varchar(50) null
);

INSERT INTO mydb.t_bills (id, customer_code, customer_name) VALUES ('5c5dfe37175b4e77b22e82cc3febeabf', 'PD1235777', 'Vu Hong Tien');
INSERT INTO mydb.t_bills (id, customer_code, customer_name) VALUES ('8a752fcd823a4ded960cdccfc59efb2f', 'PD1235666', 'Vu Hong Anh');
