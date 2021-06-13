
drop table if exists toll_details;
drop table if exists rates;

create table toll_details(
	toll_details_id integer auto_increment primary key,
	vehicle_number varchar(30) not null,
	route varchar(10) not null,
	amount integer not null,
	expiry_date date not null
);

create table rates(
	id int auto_increment primary key,
	single int not null,
	return_trip int not null
);

insert into rates values (1, 100, 200);
commit;