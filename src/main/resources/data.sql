



Insert into DOCTOR (id, pesel, first_Name, last_Name, specialization, street, house_number,postcode,city,country, email_Address, phone_Number)
values (nextval('doctor_Seq'),'50121213459','Zenek', 'Zenkowski', 'UROLOGIST', 'Brzozowa', '1', '88500', 'Sieradz','Poland' ,'+48999999999','zenek.zenkowski@wp.pl');
Insert into DOCTOR (id,pesel, first_Name, last_Name, specialization, street, house_number, postcode,city,country, email_Address, phone_Number)
values (nextval('doctor_Seq'),'69101099988', 'Franek', 'Markowski', 'DERMATOLOGIST','Żmigrodzka','44','12540', 'Warszawa','Poland','+48666666666','123.markowski@wp.pl');
Insert into DOCTOR (id,pesel, first_Name, last_Name, specialization, street, house_number,postcode,city,country, email_Address, phone_Number)
values (nextval('doctor_Seq'),'60090910099', 'Janusz', 'Nowak', 'UROLOGIST', 'Puławska','32', '78654', 'Poznań','Poland','+48333333333','janusz.nowak@wp.pl');

insert into ROLE (id, authority) values (nextval('role_seq'), 'USER');
insert into ROLE (id, authority) values (nextval('role_seq'), 'ADMIN');

insert INTO USER (username, password, first_name, last_name, role_id) values ('user', '$2a$10$KvxPudrieuxpEgxw3e4yPOuYK59PgfQshx3RaVUTCpbKB82DC/0RC', 'Imie', 'Nazwisko', 1);
insert INTO USER (username, password, first_name, last_name, role_id) values ('admin', '$2a$10$IPJizmA0rxJBq9incE/PWub6B2nIDGm3z/2cIz6hAs/hgvKlQ5F9q', 'Imie1', 'Nazwisko1', 2);

commit;