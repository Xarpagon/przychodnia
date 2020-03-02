


insert into ROLE (id, authority) values (nextval('role_seq'), 'USER');
insert into ROLE (id, authority) values (nextval('role_seq'), 'DOCTOR');
insert into ROLE (id, authority) values (nextval('role_seq'), 'ADMIN');

insert INTO USER (username, password, role_id, pesel, first_Name, last_name, street, house_number, postcode, city, country, phone_number, email_Address)
values ('madek', '$2a$10$aVB0m0l0PraM3hkKeeqx0eSEWazbui3mwBiptrGlU/CrlrCFxgkjy', 1, '82110319936','Mada','Zielinski', 'Brzozowa', '1','88450','Warszawa', 'Poland', '+48800700800', 'mada.zielinski@wp.pl');
insert INTO USER (username, password, role_id, pesel, first_Name, last_name, street, house_number, postcode, city, country, phone_number, email_Address)
values ('kazek', '$2a$10$FlnRYjhKb8vOBbWSWXa/VeCCJqBFa2l8q5ykUA6YYVnE8t7xbmTHW', 1, '82110319900','Kazik','Staszewski', 'Janowiecka', '2','88454','Wroclaw', 'Poland', '+48800700700', 'kazik.staszewski@wp.pl');
insert INTO USER (username, password, role_id, pesel, first_Name, last_name, street, house_number, postcode, city, country, phone_number, email_Address)
values ('maro', '$2a$10$IURGquRaIhD1Qx5i9/gfgeQ6Qg7DO4vn9upoNorNTHmLmo1kkq/Mu', 1, '82110319936','Marek','Markowski', 'Rogowska', '3','11290','Poznan', 'Poland', '+48800700800', 'marek.markowski@wp.pl');
insert INTO USER (username, password, role_id, pesel, first_Name, last_name, street, house_number, postcode, city, country, phone_number, email_Address)
values ('janek', '$2a$10$KvxPudrieuxpEgxw3e4yPOuYK59PgfQshx3RaVUTCpbKB82DC/0RC', 1, '50110319936','Jan','Nowak', 'Jesionowa', '12','88650','Gniezno', 'Poland', '+48800700805', 'jan.nowak@wp.pl');

Insert into DOCTOR (id, specialization, floor_Number, door_Number)values (nextval('doctor_Seq'), 'UROLOGIST', '2', '12');
Insert into DOCTOR (id, specialization, floor_Number, door_Number)values (nextval('doctor_Seq'), 'RADIOLOGIST', '1', '6');
Insert into DOCTOR (id, specialization, floor_Number, door_Number)values (nextval('doctor_Seq'), 'HEMATOLOGIST', '1', '4');

insert INTO USER (username, password, role_id, pesel, first_Name, last_name, street, house_number, postcode, city, country, phone_number, email_Address, doctor_id)values ('doctor1', '$2a$10$IPJizmA0rxJBq9incE/PWub6B2nIDGm3z/2cIz6hAs/hgvKlQ5F9q', 2, '50101044456', 'Andrew', 'Nowak', 'Kasztanowa', '34', '80600', 'Poznan', 'Poland', '+48790989900', 'andrew.nowak@wp.pl', 1);
insert INTO USER (username, password, role_id, pesel, first_Name, last_name, street, house_number, postcode, city, country, phone_number, email_Address, doctor_id)values ('doctor2', '$2a$10$SgCjHGlv.exiSDwhQEUNfu3VxhRT7.jeKRs.HwfUy2UI/MjBdQtGO', 2, '40101044456', 'Arel', 'Nowaczyk', 'Kasztan', '12', '80630', 'Poznan', 'Poland', '+48790989911', 'arel.nowaczyk@wp.pl',2);
insert INTO USER (username, password, role_id, pesel, first_Name, last_name, street, house_number, postcode, city, country, phone_number, email_Address, doctor_id)values ('doctor3', '$2a$10$IPJizmA0rxJBq9incE/PWub6B2nIDGm3z/2cIz6hAs/hgvKlQ5F9q', 2, '6099999999', 'Janek', 'Kosynski', 'Janowiecka','13', '88-090', 'Rogowo','Poland','+48123456100','janek.kosynski@wp.pl',3);






Insert into APPOINTMENT (id, doctor_id, appointment_Date) values (nextval('appointment_Seq'), '2', '2020-02-24 15:00:00');
Insert into APPOINTMENT (id, doctor_id, appointment_Date) values (nextval('appointment_Seq'), '1', '2020-02-25 15:30:00');
Insert into APPOINTMENT (id, doctor_id, appointment_Date) values (nextval('appointment_Seq'), '3', '2020-02-26 14:00:00');
Insert into APPOINTMENT (id, doctor_id, appointment_Date) values (nextval('appointment_Seq'), '2', '2020-02-25 13:00:00');
Insert into APPOINTMENT (id, doctor_id, appointment_Date) values (nextval('appointment_Seq'), '2', '2020-03-25 14:00:00');

Insert into APPOINTMENT (id, doctor_id, patient_username, appointment_Date, description) values (nextval('appointment_Seq'), '1', 'madek', '2020-03-03 17:00:00', 'fever');
Insert into APPOINTMENT (id, doctor_id, patient_username, appointment_Date, description) values (nextval('appointment_Seq'), '1', 'kazek', '2020-03-04 10:00:00', 'hangover');

Insert into USER_APPOINTMENT_SET (appointment_Set_id, user_username) values (2, 'doctor1');
Insert into USER_APPOINTMENT_SET (appointment_Set_id, user_username) values (6, 'doctor1');
Insert into USER_APPOINTMENT_SET (appointment_Set_id, user_username) values (7, 'doctor1');

Insert into USER_APPOINTMENT_SET (appointment_Set_id, user_username) values (1, 'doctor2');
Insert into USER_APPOINTMENT_SET (appointment_Set_id, user_username) values (4, 'doctor2');
Insert into USER_APPOINTMENT_SET (appointment_Set_id, user_username) values (5, 'doctor2');

Insert into USER_APPOINTMENT_SET (appointment_Set_id, user_username) values (3, 'doctor3');



commit;

