



Insert into DOCTOR (id, pesel, first_Name, last_Name, specialization, street, house_number,postcode,city,country, email_Address, phone_Number, floor_Number, door_Number)
values (nextval('doctor_Seq'),'50121213459','Zenek', 'Zenkowski', 'UROLOGIST', 'Brzozowa', '1', '88500', 'Sieradz','Poland' ,'+48999999999','zenek.zenkowski@wp.pl', '2', '14');
Insert into DOCTOR (id,pesel, first_Name, last_Name, specialization, street, house_number, postcode,city,country, email_Address, phone_Number, floor_Number, door_Number)
values (nextval('doctor_Seq'),'69101099988', 'Franek', 'Markowski', 'DERMATOLOGIST','Żmigrodzka','44','12540', 'Warszawa','Poland','+48666666666','123.markowski@wp.pl', '1', '1');
Insert into DOCTOR (id,pesel, first_Name, last_Name, specialization, street, house_number,postcode,city,country, email_Address, phone_Number, floor_Number, door_Number)
values (nextval('doctor_Seq'),'60090910099', 'Janusz', 'Nowak', 'UROLOGIST', 'Puławska','32', '78654', 'Poznań','Poland','+48333333333','janusz.nowak@wp.pl', '2', '12');
Insert into DOCTOR (id,pesel, first_Name, last_Name, specialization, street, house_number,postcode,city,country, email_Address, phone_Number, floor_Number, door_Number)
values (nextval('doctor_Seq'),'60090910091', 'Michal', 'Michalski', 'PEDIATRICIAN', 'Leszczyńskiego','32', '38652', 'Bydgoszcz','Poland','+48333333332','michal.michalski@wp.pl', '2', '9');


Insert into PATIENT (id,pesel, first_Name, last_Name,street, house_number,postcode,city,country,phone_Number,email) values (nextval('patient_Seq'),'9999999999', 'Kamil', 'Nowek', 'Szamotulska','12', '62-090', 'Rokietnica','Poland','+48123456789','kamil.nowek@wp.pl');
Insert into PATIENT (id,pesel, first_Name, last_Name,street, house_number,postcode,city,country,phone_Number,email) values (nextval('patient_Seq'),'6099999999', 'Janek', 'Kosynski', 'Janowiecka','13', '88-090', 'Rogowo','Poland','+48123456100','janek.kosynski@wp.pl');

Insert into APPOINTMENT (id, doctor_id, appointment_Date, appointment_Time) values (nextval('appointment_Seq'), '2', '2020-02-24', '15:00');
Insert into APPOINTMENT (id, doctor_id, appointment_Date, appointment_Time) values (nextval('appointment_Seq'), '1', '2020-02-25', '15:30');
Insert into APPOINTMENT (id, doctor_id, appointment_Date, appointment_Time) values (nextval('appointment_Seq'), '3', '2020-02-26', '14:00');
Insert into APPOINTMENT (id, doctor_id, appointment_Date, appointment_Time) values (nextval('appointment_Seq'), '2', '2020-02-25', '13:00');
Insert into APPOINTMENT (id, doctor_id, appointment_Date, appointment_Time) values (nextval('appointment_Seq'), '2', '2020-03-25', '14:00');

Insert into APPOINTMENT (id, doctor_id, patient_id, appointment_Date, appointment_Time, description) values (nextval('appointment_Seq'), '1', '1', '2020-03-03', '17:00', 'fever');
Insert into APPOINTMENT (id, doctor_id, patient_id, appointment_Date, appointment_Time, description) values (nextval('appointment_Seq'), '1', '2', '2020-03-04', '10:00', 'hangover');


commit;

