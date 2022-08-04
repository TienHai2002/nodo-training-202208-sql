--cau 1
select * from SALGRADE;
--cau 2
select * from emp;
--cau 3
select JOB from EMP;
--cau 4
select ENAME ,SAL * 12  REMUNERATION from EMP;
--cau 5
select ENAME || 'HAS HELP THE POSITION OF PRESIDENT IN DEPT' || DEPTNO || 'SINCE' || HIREDATE from EMP;



SELECT ENAME,DEPTNO,SAL FROM EMP WHERE SAL  BETWEEN  2000 AND 3000;
select DEPTNO , ENAME  from EMP order by DEPTNO ASC ;
select * from EMP where DEPTNO in(10,20) order by ENAME asc;
select ENAME,JOB  from emp where JOB='CLERK' and DEPTNO in(20);
SELECT ename FROM emp WHERE ename LIKE '%LL%' or ENAME like '%TH%';
select ENAME,JOB,SAL from EMP where JOB not in('PRESIDENT');
select ENAME,DEPTNO,HIREDATE from EMP where trunc(HIREDATE) between to_date('01/01/1983','dd/mm/yyyy') and to_date('31/12/1983','dd/mm/yyyy');
select ENAME ,SAL * 12  ANUAl_SAL ,COMM ,JOB from EMP where JOB='SALESMAN' and COMM < SAL order by SAL desc ;