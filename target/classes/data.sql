
Insert into ADDRESS (id, street, postcode, city) values (nextval('address_Seq'), 'Brzozowa 1', '88500', 'Sieradz');
Insert into ADDRESS (id, street, postcode, city) values (nextval('address_Seq'), 'Żmigrodzka 44', '12540', 'Warszawa');
Insert into ADDRESS (id, street, postcode, city) values (nextval('address_Seq'), 'Puławska 32', '78654', 'Poznań');


Insert into DOCTOR (id, first_Name, last_Name, specialization, address_id, email_Address, phone_Number)
values (nextval('doctor_Seq'),'Zenek', 'Zenkowski', 'UROLOGIST', '1','+48999999999','zenek.zenkowski@wp.pl');
Insert into DOCTOR (id, first_Name, last_Name, specialization, address_id, email_Address, phone_Number)
values (nextval('doctor_Seq'),'Franek', 'Markowski', 'DERMATOLOGIST', '2','+48666666666','123.markowski@wp.pl');
Insert into DOCTOR (id, first_Name, last_Name, specialization, address_id, email_Address, phone_Number)
values (nextval('doctor_Seq'), 'Janusz', 'Nowak', 'UROLOGIST', '3','+48333333333','janusz.nowak@wp.pl');
