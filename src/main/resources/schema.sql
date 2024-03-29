create table if not exists account(
    id identity,
    username varchar(25) not null,
    password varchar (255) not null,
    email varchar(25) not null,
    phone varchar (25),
    image varchar (255)
    );

create table if not exists role(
    id identity,
    role_type varchar (255) not null,
    account_id bigint not null,
    constraint fk_account foreign key (account_id) references account(id)
    );

create table if not exists professor(
    id identity,
    first_name varchar (255) not null,
    last_name varchar (255) not null,
    title varchar (255),
    location varchar (255),
    consultations varchar (255),
    account_id bigint not null,
    constraint fk_professor_account foreign key (account_id) references account(id)
);

create table if not exists student(
    id identity,
    jmbag varchar (10) not null,
    first_name varchar (255) not null,
    last_name varchar (255) not null,
    occupation varchar (255),
    address varchar (255),
    scholarship int,
    account_id bigint not null,
    constraint fk_student_account foreign key (account_id) references account(id)
);

create table if not exists course(
    id identity,
    name varchar (255) not null,
    ects_number int not null,
    description text,
    semester int not null,
    literature text
);

create table if not exists professor_course(
    professor_id bigint not null,
    course_id bigint not null,
    constraint fk_professor foreign key (professor_id) references professor(id),
    constraint fk_professor_course foreign key (course_id) references course(id)
);

create table if not exists student_course(
    student_id bigint not null,
    course_id bigint not null,
    constraint fk_student foreign key (student_id) references student(id),
    constraint fk_student_course foreign key (course_id) references course(id)
);

create table if not exists schedule(
    id identity,
    tstamp_from timestamp not null,
    tstamp_to timestamp not null,
    day_of_the_week int,
    course_id bigint not null,
    constraint fk_schedule_course foreign key (course_id) references course(id)
);

create table if not exists todo(
    id identity,
    tstamp_from timestamp not null,
    tstamp_to timestamp not null,
    header varchar (255) not null,
    description text,
    account_id  bigint not null,
    constraint fk_todo_account foreign key (account_id) references account(id)
);

create table if not exists notification(
    id identity,
    tstamp_from timestamp not null,
    tstamp_to timestamp not null,
    header varchar (255) not null,
    description text not null,
    professor_id bigint not null,
    course_id bigint not null,
    constraint fk_professor_notification foreign key (professor_id) references professor(id),
    constraint fk_course_notification foreign key (course_id) references course(id)
);

create table if not exists student_grade(
    student_id bigint not null,
    course_id bigint not null,
    grade bigint not null,
    constraint fk_student_grade foreign key (student_id) references student(id),
    constraint fk_student_course_grade foreign key (course_id) references course(id)
)