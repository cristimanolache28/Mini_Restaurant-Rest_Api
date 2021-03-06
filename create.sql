create table categories (id integer generated by default as identity, name varchar(255) not null, primary key (id));
create table employers (id integer generated by default as identity, badge_code varchar(255) not null, job_title varchar(255) not null, name varchar(255) not null, primary key (id));
create table ingredients (id integer generated by default as identity, name varchar(255) not null, primary key (id));
create table order_products (id_order integer not null, id_product integer not null);
create table orders (id integer generated by default as identity, discount integer not null, order_date timestamp, total double not null, id_employer integer, primary key (id));
create table product_ingredients (id_product integer not null, id_ingredient integer not null, primary key (id_product, id_ingredient));
create table products (id integer generated by default as identity, name varchar(255) not null, price double not null, category_id integer, primary key (id));
alter table order_products add constraint UK_bshf9f4eifx3m4dy43s85c2aj unique (id_product);
alter table product_ingredients add constraint UK_eldd0847fs924ui28jyhgy7uw unique (id_ingredient);
alter table order_products add constraint FKcv24a13chxlos4qk6ns191o94 foreign key (id_product) references products;
alter table order_products add constraint FK2dsdad0hrbro0jpbv24abdmae foreign key (id_order) references orders;
alter table orders add constraint FKaoqdmblkj8c95vcrsm813s2p1 foreign key (id_employer) references employers;
alter table product_ingredients add constraint FKobqmqfrrgsoiw6vkltk4gg6os foreign key (id_ingredient) references ingredients;
alter table product_ingredients add constraint FK6rajyq2513nfey4i6i91dn94e foreign key (id_product) references products;
alter table products add constraint FKog2rp4qthbtt2lfyhfo32lsw9 foreign key (category_id) references categories;
