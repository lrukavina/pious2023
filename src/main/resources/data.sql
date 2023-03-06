insert into account(username, password, email) values
('tfiolic', '123', 'tfiolic@tvz.hr'),
('dmilosevic', '123', 'dmilosevic@tvz.hr'),
('sglogovic', '123', 'sglogovic@tvz.hr'),
('lrukavina', '123', 'lrukavina@tvz.hr'),
('omitrovic', '123', 'omitrovic@tvz.hr');


insert into role(role_type, account_id) values
('STUDENT', 1),
('STUDENT', 2),
('STUDENT', 3),
('STUDENT', 4),
('PROFESSOR', 5);

insert into professor(first_name, last_name, title, location, consultations, account_id) values
('Ognjen', 'Mitrović', 'dr. sc.', 'Vrbik 8', 'Ponedjeljkom i petkom od 13:00 do 14:00', 4);

insert into student(jmbag,first_name, last_name, occupation, address, scholarship, account_id) values
('0000000000', 'Tin', 'Fiolić', 'Frontend Developer', 'Vrbik 8, 10 000 Zagreb', 0, 1),
('0000000000', 'Dominik', 'Milošević', 'Tester', 'Vrbik 8, 10 000 Zagreb', 0, 2),
('0000000000', 'Silvio', 'Glogović', 'Project Manager', 'Vrbik 8, 10 000 Zagreb', 0, 3),
('0000000000', 'Luka', 'Rukavina', 'Backend Develooper', 'Vrbik 8, 10 000 Zagreb', 0, 4);

insert into course(name, ects_number, description, semester, literature) values
('Programsko inženjerstvo u otvorenim sustavima', 6, 'Pružiti detaljni pregled cijelog područja inženjerskog razvoja otvorenih sustava i naučiti studente metodološkom razvoju programskih proizvoda', 2, 'Manger,R.: Softversko inženjerstvo, skripta, nadopunjeno drugo izdanje, Sveučilište u Zagrebu, Prirodoslovno-matematički fakultet, Matematički odsjek, Zagreb, 2013.');

insert into professor_course(professor_id, course_id) values
(1, 1);

insert into student_course(student_id, course_id) values
(1, 1),
(2, 1),
(3, 1),
(4, 1);

insert into schedule(tstamp_from, tstamp_to, day_of_the_week, course_id) values
('2023-02-27 17:00:00', '2023-06-30 17:00:00', 0, 1),
('2023-02-28 17:00:00', '2023-06-30 17:00:00', 1, 1);
