use bsin;

insert into uzytkownik(login, haslo) values ('Jan', '$2a$10$xWi5AQASyKJV/FN3XIqapugK1bcPmvisFy9uvNUuijpEZuEJ/XIZW');
insert into uzytkownik(login, haslo) values ('Dawid', '$2a$10$fRsktk7metunk/MbiiskMOvCEZwq0LBpZnQqO2cp5psV1x4qQZ75W');
insert into uzytkownik(login, haslo) values ('Ryan', '$2a$10$fCN3l25MFWXLvAR.rfCiPOvXZ6N97Gwz.BjcLIDXIrtblIuhJT//W');

insert into talon(wartosc, id_uzytkownik) values (5000, 1);
insert into talon(wartosc, id_uzytkownik) values (1000, 3);
insert into talon(wartosc, id_uzytkownik) values (20000, 2);
insert into talon(wartosc, id_uzytkownik) values (14000, 2);
insert into talon(wartosc, id_uzytkownik) values (300, 1);