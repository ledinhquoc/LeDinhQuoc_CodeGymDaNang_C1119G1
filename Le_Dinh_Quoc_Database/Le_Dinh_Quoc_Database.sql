-- TASK 1: 
use `case_study_database`;
Create Table `case_study_database`.type_customers (
    type_customer_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type_customer_name nvarchar(50)
);
Create Table `case_study_database`.customers (
    customer_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    full_name nvarchar(50) not null,
    birthday date,
    id_card varchar(45),
    phone_number varchar(50),
    email varchar(50) not null,
    address nvarchar(500) not null,
    type_customer_id INT UNSIGNED,
    constraint fk_type_customer foreign key(type_customer_id) references type_customers(type_customer_id)
);
Create Table `case_study_database`.type_rents (
    type_rent_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type_rent_name nvarchar(50),
    price int
);  
Create Table `case_study_database`.positions (
    position_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    position_name nvarchar(50)
);  
Create Table `case_study_database`.educations (
    education_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    education_name nvarchar(50)
);  
Create Table `case_study_database`.departments (
    department_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    department_name nvarchar(50)
);  
Create Table `case_study_database`.employees (
    employee_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    full_name nvarchar(50) not null,
    birthday date,
    id_card varchar(45),
    salary decimal(18,2),
    phone_number varchar(50),
    email varchar(50) not null,
    address nvarchar(500) not null,
    position_id INT UNSIGNED,
    constraint fk_position foreign key(position_id) references positions(position_id),
    education_id INT UNSIGNED,
    constraint fk_education foreign key(education_id) references educations(education_id),
    department_id INT UNSIGNED,
    constraint fk_department foreign key(department_id) references departments(department_id)
);
Create Table `case_study_database`.type_services (
    type_service_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type_services_name varchar(50)
);  
Create Table `case_study_database`.accompanied_services (
    accompanied_service_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    accompanied_service_name varchar(50),
    price int,
    unit varchar(50),
    accompanied_service_status varchar(30)
);  
Create Table `case_study_database`.services (
    service_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    service_status varchar(30),
    service_name varchar(50),
    area_used int,
    number_floors int,
    number_max_people int,
    rental_costs decimal(18,2),
    accompanied_service_status varchar(30),
    type_rent_id INT UNSIGNED,
    constraint fk_type_rent foreign key(type_rent_id) references type_rents(type_rent_id),
    type_service_id INT UNSIGNED,
    constraint fk_type_service foreign key(type_service_id) references type_services(type_service_id)
);  
Create Table `case_study_database`.contracts (
    contract_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    contract_date date,
    contract_date_end date,
    deposit decimal(18,2),
    total decimal(18,2),
    employee_id INT UNSIGNED,
    constraint fk_employee foreign key(employee_id) references employees(employee_id),
    customer_id INT UNSIGNED,
    constraint fk_customer foreign key(customer_id) references customers(customer_id),
    service_id INT UNSIGNED,
    constraint fk_service FOREIGN KEY(service_id) REFERENCES services(service_id)
);  
Create Table `case_study_database`.contract_details (
    contract_detail_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    quantity int,
    contract_id INT UNSIGNED,
    constraint fk_contract foreign key(contract_id) references contracts(contract_id),
    accompanied_service_id INT UNSIGNED,
    constraint fk_accompanied_service foreign key(accompanied_service_id) references accompanied_services(accompanied_service_id)
);  
insert into `case_study_database`.departments(department_name) 
values ('Laundry'),('receptionist'),('restaurant'),('security'),('office');

insert into `case_study_database`.positions(position_name) 
values ('Manager'),('head_office'),('Supervisor'),('staff');

insert into `case_study_database`.educations(education_name) 
values ('Postgradute'),('university_graduate'),('college_graduate'),('secondary_graduate');

insert into `case_study_database`.employees(full_name,birthday,id_card,salary,phone_number,
email, address,position_id, education_id, department_id)
values('Hoàng Văn A','1990-01-24', '012312345', 7000000.00, '076121212', 'abc1@gamil.com', 'Quảng Trị',4 ,3 ,2 ),
('Đặng Văn B', '1970-07-12', '012312346', 20000000.00, '0932121234', 'abc2@gamil.com', 'Đà Nẵng',1 ,1 ,5 ),
('Trần C', '1991-02-14', '012312347', 9000000.00, '033121256', 'abc3@gamil.com', 'Quảng Bình',2 ,2 ,3),
('Khánh Trang', '1994-10-12', '012312348', 7000000.00, '044121278', 'Trang@gamil.com', 'Quảng Trị',4 ,3 ,1),
('Nguyễn Thị Trang', '1992-11-11', '012312398', 15000000.00, '0231213412', 'ab23@gamil.com', 'Đà Nẵng',3 ,1 ,2),
('Hoàng Thị Ngọc Quỳnh', '1994-08-06', '012312432', 15000000.00, '012123434', 'abewq4@gamil.com', 'Huế',2 ,2 ,5),
('Trần Thị Thu Út', '1980-06-19',' 012312567', 9000000.00, '02324356', 'abqwe@gamil.com', 'Đà Nẵng',3 ,2 ,3),
('Lê Văn C', '1982-05-21', '012845743', 7000000.00, '0821212345', 'abqq223@gamil.com', 'Quảng Nam',4 ,2 ,2),
('Hoàng Ngọc G', '1981-04-14', '012324183', 15000000.00, '094121278', 'abcwqe224@gamil.com', 'Hà Nội',2 ,3 ,4),
('Trần Long Hoàng Ngọc', '1979-02-15', '012324179', 15000000.00, '0541212986', 'abdsad4@gamil.com', 'Quảng Trị',2 ,1 ,5);

insert into `case_study_database`.type_customers(type_customer_name)
values ('Diamond'),('Platinium'),('Gold'),('Silver'),('Member');

insert into customers(full_name,birthday,id_card,phone_number,email,address,type_customer_id)
values ('Hoàng Long', '1970-03-15', '098765432', '023567344', 'zxcs@gmail.com', 'Quảng Trị', 1),
('Trần Văn A', '1968-09-15', '098712322', '023567865', 'zxwqe232cs@gmail.com', 'Đà Nẵng', 1),
('Nguyễn Ngọc B', '1990-07-15', '06755432', '023567432', 'zx23cs@gmail.com', 'Quảng Trị', 3),
('Lê Văn C', '1969-06-15', '098734534', '023567423', '5asd6@gmail.com', 'Quảng Trị', 5),
('Nguyễn Hà', '1983-05-15', '09886652', '023549676', 'zxmkucs@gmail.com', 'Đà Nẵng', 2),
('Hoàng Văn C', '1985-11-25', '094355432', '023565624', 'zxqwecs@gmail.com', 'Vinh', 1),
('Trần B', '1995-04-25', '098765232', '023567631', 'zxcs@gmail.com', 'Quảng Ngãi', 1),
('Đoàn A', '1993-06-24', '098765412', '023567231', 'fdsd@gmail.com', 'Quảng Trị', 2),
('Trần Văn A', '1982-01-23', '098767332', '023847324', 'zghghgxcs@gmail.com', 'Đà Nẵng', 1),
('Lê Văn K', '1965-02-04', '097123132', '098367344', 'zxwewcs@gmail.com', 'Quảng Ngãi', 2);

insert into `case_study_database`.type_rents(type_rent_name,price) 
values ('Năm',100000000.00),
('Tháng',15000000.00),('Ngày',1000000.00),('Gio',200000.00);

insert into `case_study_database`.type_services(type_services_name) 
values ('Villa'),('House'),('Room');

insert into `case_study_database`.services(service_status,service_name,area_used,number_floors,number_max_people,rental_costs,accompanied_service_status,type_rent_id,type_service_id)
values('a','Villa1',100.00,3,3,1000000.00,'f',2,1),
('b','House1', 50.00, 2 , 3, 750000.00,'u',3, 2),
('c','House2', 60.00, 2 , 5, 850000.00,'c',4, 2),
('d','Room1', 30.00, 1 , 3, 300000.00,'k',3, 3),
('e','Villa2', 150.00, 4 , 5, 1500000.00,'y',3, 1),
('f','House3', 50.00, 1 , 3, 5000000.00,'o',2, 2),
('g','Romm2', 25.00, 1 , 2, 1500000.00,'u',4, 3),
('k','Villa3', 100.00, 2 , 2, 6000000.00,'e',2, 1);


insert into `case_study_database`.accompanied_services(accompanied_service_name,price,unit,accompanied_service_status)
values('Massage',500000.00,1,'good'),
('Car',400000.00,1,'good'),
('foods',150000,2,'good'),
('drinks',100000,2,'good'),
('Karaoke',5000000,5,'good');

insert into `case_study_database`.contracts(contract_date,contract_date_end,deposit,total,employee_id,customer_id,service_id)
values('2019-09-24','2019-10-01','5000000.00',25000000.00,1,3,1),
('2019-10-24','2019-10-30',2000000.00,12000000.00, 1, 2,1),
('2019-01-31','2019-02-24',1000000.00,9000000.0, 3,3,1),
('2015-05-12','2019-02-20',2000000.00,15000000.00, 2,6,1),
('2019-04-12','2019-04-15', 1000000.00,12000000.00, 5,4,5),
('2016-01-12','2019-01-15',1000000.00,13000000.00, 1,1,2),
('2019-06-20','2019-03-01',2000000.00,14000000.00,7,7,8),
('2015-08-15','2018-04-12',1000000.00,8000000.00,8,4,7);

insert into `case_study_database`.contract_details(quantity,contract_id,accompanied_service_id)
values (3,41,8),(4,42,6),(2,42,7),(5,48,10),(2,44,10),(2,44,8),(2,45,9),(1,47,6),(2,45,7),(3,46,9),(4,47,8);

-- TASK 2:
select * from `case_Study_database`.employees
 where (full_name REGEXP "H.*|T.*|K.*")  and length(full_name)<15;
 
-- TASK 3:
select * from `case_study_database`.customers where (DATEDIFF(CURRENT_DATE(),birthday) > 18*365 and DATEDIFF(CURRENT_DATE(),birthday) < 50*365 
and address in ("Đà Nẵng", "Quảng Trị"));

-- TASK 4:
select c.full_name,c.customer_id,count(ct.customer_id) as number_of_contract
from `case_study_database`.customers c
join `case_study_database`.contracts ct on c.customer_id =ct.customer_id
join `case_study_database`.type_customers tc on c.customer_id =tc.type_customer_id
where tc.type_customer_name = 'Gold'
group by ct.customer_id
order by number_of_contract;

-- TASK 5:
select c.customer_id, c.full_name, tc.type_customer_name,
ct.contract_id,sv.service_name,ct.contract_date,ct.contract_date_end,
sum(sv.rental_costs + cd.quantity * acs.price) as total 
from `case_study_database`.customers c 
left join `case_study_database`.type_customers tc on c.customer_id = tc.type_customer_id
left join `case_study_database`.contracts ct on c.customer_id = ct.customer_id
left join `case_study_database`.services sv on ct.service_id = sv.service_id
left join `case_study_database`.contract_details cd on ct.contract_id = cd.contract_id
left join `case_study_database`.accompanied_services acs on cd.accompanied_service_id = acs.accompanied_service_id;

-- TASK 6:
select sv.service_id,sv.service_name,sv.area_used,sv.rental_costs,sv.service_name
from `case_study_database`.services sv 
inner join `case_study_database`.type_services ts on sv.type_service_id = ts.type_service_id
where not exists(select ct.service_id 
				 from `case_study_database`.contracts  ct
				 where(ct.contract_date between '2019-01-01' and '2019-03-31' )
				 AND ct.service_id = sv.service_id);
                 
-- TASK 7:
select sv.service_id, sv.service_name, sv.area_used, sv.number_max_people, sv.rental_costs, ts.type_services_name
from `case_study_database`.services sv 
inner join `case_study_database`.type_services ts on sv.type_service_id = ts.type_service_id
where not exists(select ct.contract_id  
from `case_study_database`.contracts ct where year(ct.contract_date) = '2018' and ct.service_id = sv.service_id)
and not exists(select ct.contract_id 
from `case_study_database`.contracts ct where year(ct.contract_date) = '2019' and ct.service_id = sv.service_id);

-- TASK 8:
-- select distinct `case_study_database`.customers.full_name from `case_study_database`.customers
-- select cm.full_name from `case_study_database`.customers cm group by cm.full_name
-- select cm.full_name from `case_study_database`.customers cm union select cm.full_name from `case_study_database`.customers cm 

-- TASK 9:
select month(ct.contract_date) as Thang, count(ct.contract_id) as SoKhachHang
from `case_study_database`.contracts ct 
where year(ct.contract_date) = 2019
group by month(ct.contract_date);

-- TASK 10:
select ct.contract_id, ct.contract_date, ct.contract_date_end, ct.deposit, count(`case_Study_database`.contract_details.contract_detail_id) as SoLuongDichVuDiKem
from `case_study_database`.contracts ct
inner join `case_study_database`.contract_details on ct.contract_id = `case_study_database`.contract_details.contract_id
group by `case_study_database`.contract_details.contract_id;
 -- TASK 11:
select acs.accompanied_service_id ,acs.accompanied_service_name, acs.price,
 acs.unit, acs.accompanied_service_status, tc.type_customer_name,cm.address
from `case_study_database`.accompanied_services acs 
join `case_study_database`.contract_details cd on acs.accompanied_service_id = cd.accompanied_service_id
join `case_study_database`.contracts ct on cd.contract_id = ct.contract_id
join `case_study_database`.customers cm on ct.customer_id = cm.customer_id
join `case_study_database`.type_customers tc on cm.type_customer_id = tc.type_customer_id
where tc.type_customer_name = 'Diamond' and cm.address in ('Vinh','Quảng Ngãi');

-- TASK 12:
select ct.contract_id, ct.contract_date, sv.service_id, em.full_name, cm.full_name, cm.phone_number, sv.service_name, ct.deposit
from `case_study_database`.accompanied_services acs 
inner join `case_study_database`.contract_details cd on cd.accompanied_service_id = acs.accompanied_service_id
inner join `case_study_database`.contracts ct on ct.contract_id = cd.contract_id
inner join `case_study_database`.customers cm on cm.customer_id = ct.customer_id
inner join `case_study_database`.services sv on ct.service_id = sv.service_id
inner join `case_study_database`.employees em on em.employee_id = ct.employee_id
where
exists( select ct.contract_date 
from `case_study_database`.contracts where ct.service_id = sv.service_id and ct.contract_date between '2019-01-01' and '2019-12-31')
and not exists(select ct.contract_date 
from `case_study_database`.contracts where ct.service_id = sv.service_id and ct.contract_date between '2019-01-01' and '2019-06-30')
group by cd.contract_id;

-- TASK 13:
select A.accompanied_service_id, max(A.so_lan_dat)
from(select acs.*, count(cd.accompanied_service_id) as so_lan_dat
from `case_Study_database`.accompanied_services acs
inner join `case_study_database`.contract_details cd on cd.accompanied_service_id = acs.accompanied_service_id
inner join `case_Study_database`.contracts ct on ct.contract_id = cd.contract_id
group by acs.accompanied_service_id) A;

-- TASK 14:
select ct.contract_id,ts.type_services_name, acs.accompanied_service_name, count(cd.accompanied_service_id) as so_luong_su_dung
from `case_study_database`.accompanied_services acs
inner join `case_study_database`.contract_details cd on cd.accompanied_service_id = acs.accompanied_service_id
inner join `case_study_database`.contracts ct on ct.contract_id = cd.contract_id
inner join `case_study_database`.services sv on sv.service_id = ct.service_id
inner join `case_study_database`.type_services ts on ts.type_service_id = sv.type_service_id
group by ts.type_service_id
having so_luong_su_dung = 1;

-- TASK 15:
select ep.employee_id,ep.full_name, ep.phone_number, count(ct.employee_id) as so_luong_hop_dong
from `case_study_database`.employees ep
inner join `case_study_database`.contracts ct on ep.employee_id = ct.employee_id
where ct.contract_date between '2019-01-01' and '2019-12-31'
group by ep.employee_id
having so_luong_hop_dong <= 3;

-- TASK 16:
set sql_safe_updates = 0;
SET FOREIGN_KEY_CHECKS = OFF;
delete from `case_study_database`.employees
where exists( select ct.employee_id
from `case_study_database`.contracts ct where ct.contract_date between '2017-01-01' and '2019-12-31' 
and ct.employee_id = `case_study_database`.employees.employee_id );
SET FOREIGN_KEY_CHECKS = ON;
set sql_safe_updates = 1;

-- TASK 17:
update `case_study_database`.customers, 
(select cm.customer_id
from `case_study_database`.customers cm
inner join `case_study_database`.type_customers tc on tc.type_customer_id = cm.type_customer_id
inner join `case_study_database`.contracts ct on ct.customer_id = cm.customer_id
where tc.type_customer_name = 'Platinium'
and ct.total > 10000000
and year(ct.contract_date) = '2019'
group by ct.contract_id)
temp set `case_study_database`.customers.type_customer_id = 1 where `case_study_database`.customers.customer_id = temp.customer_id;

-- TASK 18:
set sql_safe_updates = 0;
delete `case_study_database`.customers,`case_study_database`.contract_details from `case_study_database`.customers cm
inner join `case_study_database`.contracts ct on ct.contract_id = cm.customer_id
left join `case_study_database`.contract_details cd on cd.contract_id = ct.contract_id
where not exists (select ct.contract_id  from `case_study_database`.contracts ct where ct.contract_date > '2016-01-01'
and ct.customer_id = cm.customer_id);
set sql_safe_updates = 1;

-- TASK 19:
set sql_safe_updates = 0;
update `case_study_database`.accompanied_services,(select acs.accompanied_service_id 
from `case_study_database`.accompanied_services acs 
inner join `case_study_database`.contract_details cd on cd.accompanied_service_id = acs.accompanied_service_id
inner join `case_study_database`.contracts ct on ct.contract_id = cd.contract_id
where year(ct.contract_date) = '2019'
group by cd.accompanied_service_id
having count(acs.accompanied_service_id) >= 10)
temp set `case_study_database`.accompanied_services.price = (`case_study_database`.accompanied_services.price * 2)
 where `case_study_database`.accompanied_services.accompanied_service_id = temp.accompanied_service_id;
 
 -- TASK 20:
 select eml.employee_id, eml.full_name, eml.email,eml.phone_number,eml.birthday,eml.address, "nhan_vien"
 from `case_study_database`.employees eml 
 union all
 select cm.customer_id,cm.full_name,cm.email,cm.phone_number,cm.birthday,cm.address,"khach_hang"
 from `case_study_database`.customers cm;




