insert into account(username, password, email) values
('tfiolic', '$2a$10$HzTu0cVlnCPNOV.xkjVmY.BdFmxYTOCusC1R/7iJzCw/kKfnCJ2Si', 'tfiolic@tvz.hr'),
('dmilosevic', '$2a$10$zp3oex.r.D67VrZWGlZI2e/qERISqCx4RKdQR0YtZc21zhjydYjIu', 'dmilosevic@tvz.hr'),
('sglogovic', '$2a$10$i2W780u3w6zGgW509OKek.p.rP6OUr5zPkEKDhRW8l9GGkUxPztpC', 'sglogovic@tvz.hr'),
('lrukavina', '$2a$10$A/3/XlFc5yKgFFl5ZIEzE.ncYo2LMTLj2S5ZYGJD0UJL0rKIDVaCy', 'lrukavina@tvz.hr'),
('omitrovic', '$2a$10$HOoOJEp6rofZKFg68gncW.CCT4loORPjjia51CfO3wFrky.nN5KMq', 'omitrovic@tvz.hr'),
('astojanovic', '$2a$10$AlHGfq/y3sgAIChoGZaSr.9Y7cXfuR7NQBSObTEhiawAEbAu0rclG', 'astojanovic@tvz.hr');


insert into role(role_type, account_id) values
('STUDENT', 1),
('STUDENT', 2),
('STUDENT', 3),
('STUDENT', 4),
('PROFESSOR', 5),
('PROFESSOR', 6);

insert into professor(first_name, last_name, title, location, consultations, account_id) values
('Ognjen', 'Mitrović', 'dr. sc.', 'Vrbik 8', 'Ponedjeljkom i petkom od 13:00 do 14:00', 5),
('Aleksandar', 'Stojanović', 'dr. sc.', 'Brozova 6a', 'Utorkom i četvrtkom od 15:00 do 16:00', 6);

insert into student(jmbag,first_name, last_name, occupation, address, scholarship, account_id) values
('0000000000', 'Tin', 'Fiolić', 'Frontend Developer', 'Vrbik 8, 10 000 Zagreb', 0, 1),
('0000000000', 'Dominik', 'Milošević', 'Tester', 'Vrbik 8, 10 000 Zagreb', 0, 2),
('0000000000', 'Silvio', 'Glogović', 'Project Manager', 'Vrbik 8, 10 000 Zagreb', 0, 3),
('0000000000', 'Luka', 'Rukavina', 'Backend Develooper', 'Vrbik 8, 10 000 Zagreb', 0, 4);

insert into course(name, ects_number, description, semester, literature) values
('Skriptni jezici u računalnim sustavima', 6, 'Pružiti detaljni pregled cijelog područja inženjerskog razvoja otvorenih sustava i naučiti studente metodološkom razvoju programskih proizvoda', 2, 'Manger,R.: Softversko inženjerstvo, skripta, nadopunjeno drugo izdanje, Sveučilište u Zagrebu, Prirodoslovno-matematički fakultet, Matematički odsjek, Zagreb, 2013.'),
('Programsko inženjerstvo u otvorenim sustavima', 6, 'Dati pregled različitih skriptnih jezika na heterogenim operacijskim sustavima', 2, 'Microsoft PowerShell dokumentacija');

insert into professor_course(professor_id, course_id) values
(1, 1),
(2, 2);

insert into student_course(student_id, course_id) values
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(3, 1),
(3, 2),
(4, 1);

insert into schedule(tstamp_from, tstamp_to, day_of_the_week, course_id) values
('2023-02-27 17:00:00', '2023-06-30 21:00:00', 0, 1),
('2023-02-28 17:00:00', '2023-06-30 17:00:00', 1, 2);

insert into notification(tstamp_from, tstamp_to, header, description, professor_id, course_id) values
('2023-02-27 17:00:00', '2023-04-01 22:00:00', 'Obavijest o održavanju nastave', 'Do 1.4.2023. nastava će se održavati online.', 1, 1),
('2023-02-27 17:00:00', '2023-04-01 22:00:00', 'Obavijesti vezane uz nastavu', 'Za sve buduće obavijesti i pristup materijalima koristiti će se LMS sustav.', 2, 2);

insert into todo(tstamp_from, tstamp_to, header, description, account_id) values
('2023-02-27 17:00:00', '2023-06-30 17:00:00', 'Obavljanje studentskih obaveza', 'Odlazak na fakultet svaki tjedan i odrada svih obaveza', 1),
('2023-02-27 17:00:00', '2023-06-30 17:00:00', 'Odlazak na posao', 'Odlazak na posao svaki tjedan i odrada svih obaveza', 1);
