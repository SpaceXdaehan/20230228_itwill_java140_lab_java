-- 테이블에서 데이터를 검색:
-- (1) projection: 테이블에서 원하는 컬럼들을 선택.
-- (2) selection: 테이블에서 조건을 만족하는 레코드(행, row)들을 검색.
-- select column_name, ... 
-- from table_name 
-- where 조건식 
-- order by column_name, ...;
-- 조건식에서 사용되는 연산자들:
--   (1) 비교 연산자: =, !=, >, >=, <, <=, is null, is not null, ...
--   (2) 논리 연산자: and, or, not

-- 직원 테이블에서 10번 부서에서 근무하는 직원들의 부서번호, 사번, 이름을 출력.
select deptno, empno, ename
from emp
where deptno = 10;

-- 직원 테이블에서 수당(comm)이 null이 아닌 직원들의 사번, 부서번호, 이름, 수당을 출력.
select empno, deptno, ename, comm
from emp
where comm is not null;

-- 직원 테이블에서 급여(sal)가 2000 이상인 직원들의 이름, 직무, 급여를 출력.
select ename, job, sal
from emp
where sal >= 2000;

-- 직원 테이블에서 급여가 2000 이상 3000 이하인 직원들의 이름, 직무, 급여를 출력
-- 급여의 내림차순으로 정렬.
select ename, job, sal
from emp
where sal >= 2000 and sal <= 3000
order by sal desc;

select ename, job, sal
from emp
where sal between 2000 and 3000
order by sal desc;








