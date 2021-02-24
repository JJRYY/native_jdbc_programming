select user(), database();

show tables;

desc title;
desc department;
desc employee;

select * from title;
select * from department;
select * from employee;

delete from title where tno = 6;
delete from department where deptno = 5;

select tno,tname from title;
select deptno, deptname, floor from department;

select tno, tname from title where tno = 1;

select deptno,deptname,floor from department;

select empno,empname,title,manager,salary,dept from employee;

insert into title values (6, "인턴");
delete from title where tno=6;

update title set tname = '계약직' where tno = 6;

delete from employee where empno=4444;

select e.*, t.*, m.empno, m.empname, d.*
	from employee e join title t on e.dept = t.tno 
	left join employee m on e.manager = m.empno 
	join department d on e.dept = d.deptno;
	
create or replace view vw_employee 
(empno, empname, tno, tname, manager, mgrname, salary, dno, dname, floor)
as 
select e.empno, e.empname, e.title, t.tname, m.empno, m.empname, e.salary, d.deptno, d.deptname, d.floor
	from employee e join title t on e.title = t.tno 
		left join employee m on e.manager = m.empno 
		join department d on e.dept = d.deptno;
		
select empno, empname, tno, tname, manager, mgrname, salary, dno, dname, floor from vw_employee;


-- 2021.02.22 ----------------------------------------------------------------
create or replace view vw_full_employee
as
select e.empno
	, e.empname
	, t.tno as title_no
	, t.tname as title_name
	, e.manager as manager_no
	, m.empname as manager_name
	, e.salary
	, d.deptno
	, d.deptname
	, d.floor
	from employee e join title t on e.title = t.tno 
		left join employee m on e.manager = m.empno
		join department d on e.dept = d.deptno ;
		
select empno, empname, title_no, title_name, manager_no, manager_name, salary, deptno, deptname, floor
	from vw_full_employee;
	
select empno, empname, title as title_no, manager as manager_no, salary, dept as deptno 
	from employee;
	
insert into employee values (1004, '천사', 5, 4377, 2000000, 1);

update employee 
	set dept = 3
	where empno = 1004;
	
delete from employee where empno = 1004;
-- ----------------------------------------------------------------------------
-- 부서가 1인 사원정보를 출력
select empno, empname, title, manager, salary, dept
	from employee 
	where dept = (select deptno from department where deptno = 1);

