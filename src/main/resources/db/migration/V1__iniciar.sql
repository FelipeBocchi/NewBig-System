CREATE TABLE product(
    id serial primary key,
    productName varchar(100) not null,
    description varchar(100) not null,
    department varchar(100) not null,
    category varchar(100) not null ,
    bar_code int not null ,
    cost_price DECIMAL(10,2),
    sale_price DECIMAL(10,2),
    minimum_stock int not null ,
    type varchar(100) not null ,
    unit varchar(100) not null
)