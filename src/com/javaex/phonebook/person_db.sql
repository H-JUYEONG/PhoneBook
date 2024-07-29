/*-----------------------------
root 계정
-------------------------------*/

-- root 사용
use mysql;

-- person 계정 만들기
create user 'person'@'%' identified by 'person';

-- person_db 만들기
create database person_db
default character set utf8mb4
collate utf8mb4_general_ci
default encryption='n'
;

 -- person 권한부여
grant all privileges on person_db.* to 'person'@'%';

-- 계정을 생성하거나 권한을 수정한 후, 변경된 권한을 즉시 적용
flush privileges;


/*-----------------------------
person 계정
-------------------------------*/

-- person_db 사용
use person_db;

-- 테이블 생성
create table person(
    person_id integer primary key auto_increment,
    person_name varchar(50),
    person_hp varchar(50),
    person_company varchar(50)
);

-- 데이터 삽입
insert into person values(null, '이효리', '010-2222-3333', '031-2323-4441');
insert into person values(null, '정우성', '010-2323-2323', '02-5555-5555');
insert into person values(null, '이정재', '010-9999-9999', '02-8888-8888');

-- 데이터 조회
select person_id,
	   person_name,
       person_hp,
       person_company
from person
;

-- 데이터 삭제
delete from person
where person_id = ?
;

-- 데이터 수정
update person
set person_name = ?
where person_id = ?
;
