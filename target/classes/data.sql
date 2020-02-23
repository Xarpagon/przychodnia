



Insert into DOCTOR (id, pesel, first_Name, last_Name, specialization, street, house_number,postcode,city,country, email_Address, phone_Number)
values (nextval('doctor_Seq'),'50121213459','Zenek', 'Zenkowski', 'UROLOGIST', 'Brzozowa', '1', '88500', 'Sieradz','Poland' ,'+48999999999','zenek.zenkowski@wp.pl');
Insert into DOCTOR (id,pesel, first_Name, last_Name, specialization, street, house_number, postcode,city,country, email_Address, phone_Number)
values (nextval('doctor_Seq'),'69101099988', 'Franek', 'Markowski', 'DERMATOLOGIST','Żmigrodzka','44','12540', 'Warszawa','Poland','+48666666666','123.markowski@wp.pl');
Insert into DOCTOR (id,pesel, first_Name, last_Name, specialization, street, house_number,postcode,city,country, email_Address, phone_Number)
values (nextval('doctor_Seq'),'60090910099', 'Janusz', 'Nowak', 'UROLOGIST', 'Puławska','32', '78654', 'Poznań','Poland','+48333333333','janusz.nowak@wp.pl');


commit;