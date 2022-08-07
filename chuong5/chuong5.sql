--chương 5
select * from dept;
select * from emp;
select * from SALGRADE;
-- 1. Hiển thị toàn bộ tên nhân viên và tên phòng ban làm việc sắp xếp theo tên phòng ban.
SELECT A.DEPTNO, A.ENAME
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO
ORDER BY A.DEPTNO asc ;
-- 2. Hiển thị tên nhân viên, vị trí địa lý, tên phòng với điều kiện lương >1500.
select ENAME ,LOC,DNAME from EMP inner join DEPT on EMP.DEPTNO = DEPT.DEPTNO where SAL > 1500;
-- ENAME LOC DNAME
-- KING NEW YORK ACCOUNTING
-- BLAKE CHICAGO SALES
-- CLARK NEW YORK ACCOUNTING
-- JONES DALLAS RESEARCH
-- ALLEN CHICAGO SALES
-- FORD DALLAS RESEARCH
-- SCOTT DALLAS RESEARCH

-- 3. Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương.
-- ENAME JOB SAL GRADE
-- JAMES CLERK 950 1
-- SMITH CLERK 800 1
-- ADAMS CLERK 1100 1
-- MARTIN SALESMAN 1250 2
-- WARD SALESMAN 1250 2
-- MILLER CLERK 1300 2
-- ALLEN SALESMAN 1600 3
-- TURNER SALESMAN 1500 3
-- BLAKE MANAGER 2850 4
-- CLARK MANAGER 2450 4
-- JONES MANAGER 2975 4
-- FORD ANALYST 3000 4
-- SCOTT ANALYST 3000 4
-- KING PRESIDENT 5000 5

select ENAME , JOB ,SAL , GRADE from EMP ,SALGRADE;
-- 4. Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương, với điều kiện mức
-- lương=3.
-- ENAME JOB SAL GRADE
-- ALLEN SALESMAN 1600 3
-- TURNER SALESMAN 1500 3
  select ENAME , JOB ,SAL , GRADE  from EMP ,SALGRADE where GRADE=3;
-- 5. Hiển thị những nhân viên tại DALLAS
-- ENAME LOC SAL
-- JONES DALLAS 2975
-- FORD DALLAS 3000
-- SMITH DALLAS 800
-- SCOTT DALLAS 3000
-- ADAMS DALLAS 1100
select ENAME,LOC,SAL from EMP inner join DEPT on EMP.DEPTNO = DEPT.DEPTNO where LOC like 'DALLAS';
select * FROM DEPT;
-- 6. Hiển thị tên nhân viên , nghề nghiệp, lương, mức lương, tên phòng làm việc trừ nhân
-- viên có nghề là cleck và sắp xếp theo chiều giảm.
select ENAME , JOB , SAL , GRADE , DNAME from SALGRADE , EMP inner join DEPT on EMP.DEPTNO = DEPT.DEPTNO where JOB not in ('CLERK');
select * from SALGRADE;
-- ENAME JOB SAL GRADE DNAME
-- MARTIN SALESMAN 1250 2 SALES
-- WARD SALESMAN 1250 2 SALES
-- ALLEN SALESMAN 1600 3 SALES
-- TURNER SALESMAN 1500 3 SALES
-- BLAKE MANAGER 2850 4 SALES
-- CLARK MANAGER 2450 4 ACCOUNTING
-- JONES MANAGER 2975 4 RESEARCH
-- FORD ANALYST 3000 4 RESEARCH
-- SCOTT ANALYST 3000 4 RESEARCH
-- KING PRESIDENT 5000 5 ACCOUNTING
-- 7. Hiển thị chi tiết về những nhân viên kiếm được 36000 $ 1 năm hoặc nghề là cleck.
-- (gồm các trường tên, nghề, thu nhập, mã phòng, tên phòng, mức lương)
select e.ENAME,e.JOB, e.SAL as ANUAL_SAL,GRADE from SALGRADE ,  EMP e  join  DEPT d on e.DEPTNO = d.DEPTNO where e.SAL > 36000 or e.JOB ='CLERK';
-- ENAME JOB ANUAL_SAL DNAME GRADE
-- JAMES CLERK 11400 SALES 1
-- SMITH CLERK 9600 RESEARCH 1
-- ADAMS CLERK 13200 RESEARCH 1
-- MILLER CLERK 15600 ACCOUNTING 2
-- FORD ANALYST 36000 RESEARCH 4
-- SCOTT ANALYST 36000 RESEARCH 4
-- 8. Hiển thị những phòng không có nhân viên nào làm việc.
select d.DEPTNO , d.DNAME, d.LOC from EMP e inner join DEPT d on e.DEPTNO = d.DEPTNO where d.SAR is null;
-- DEPTNO DNAME LOC
-- 40 OPERATIONS BOSTON
-- 9. Hiển thị mã nhân viên, tên nhân viên, mã người quản lý, tên người quản lý
select m.EMPNO, e.ENAME EMP_NAME,e.MGR MRG, m.ENAME MRG_NAME
from EMP e,EMP m
where e.MGR = m.EMPNO;
select * from EMP;
-- EMP_NAME EMP_SAL MGR_NAME MGR_SAL
-- BLAKE 2850 KING 5000
-- CLARK 2450 KING 5000
-- JONES 2975 KING 5000
-- MARTIN 1250 BLAKE 2850
-- ALLEN 1600 BLAKE 2850
-- TURNER 1500 BLAKE 2850
-- JAMES 950 BLAKE 2850
-- WARD 1250 BLAKE 2850
-- FORD 3000 JONES 2975
-- SMITH 800 FORD 3000
-- SCOTT 3000 JONES 2975
-- ADAMS 1100 SCOTT 3000
-- MILLER 1300 CLARK 2450
-- 10. Như câu 9 hiển thị thêm thông tin về ông KING.
select m.EMPNO, e.ENAME EMP_NAME,e.MGR MRG, m.ENAME MRG_NAME
from EMP e,EMP m
where e.MGR = m.EMPNO;
-- EMP_NAME EMP_SAL MGR_NAME MGR_SAL
-- KING 5000
-- BLAKE 2850 KING 5000
-- CLARK 2450 KING 5000
-- JONES 2975 KING 5000
-- MARTIN 1250 BLAKE 2850
-- ALLEN 1600 BLAKE 2850
-- TURNER 1500 BLAKE 2850
-- JAMES 950 BLAKE 2850
-- WARD 1250 BLAKE 2850
-- FORD 3000 JONES 2975
-- SMITH 800 FORD 3000
-- SCOTT 3000 JONES 2975
-- ADAMS 1100 SCOTT 3000
-- MILLER 1300 CLARK 2450
-- 11. Hiển thị nghề nghiệp được tuyển dụng vào năm 1981 và không được tuyển dụng vào
-- năm 1994.
select distinct job
from emp
where job in(select job from emp where extract(year from hiredate ) =1981)
  and job not in(select job from emp where extract(year from hiredate ) =19941)
-- 12. Tìm những nhân viên gia nhập công ty trước giám đốc của họ.
select e.ENAME ,to_char(e.HIREDATE,'dd-mm-yyyy') EMP_HIREDATE,
       m.ENAME ,to_char(m.HIREDATE,'dd-mm-yyyy') MRG_HIREDATE
from EMP e, EMP m
where e.MGR = m.EMPNO and e.HIREDATE < m.HIREDATE;
-- 13. Tìm tất cả các nhân viên, ngày gia nhập công ty, tên nhân viên, tên người giám đốc
-- và ngày gia nhập công ty của người giám đốc ấy.
-- EMP_NAME EMP_SAL MGR_NAME MGR_SAL
-- BLAKE 2850 BLAKE 2850
-- MARTIN 1250 BLAKE 2850
-- ALLEN 1600 BLAKE 2850
-- TURNER 1500 BLAKE 2850
-- JAMES 950 BLAKE 2850
-- WARD 1250 BLAKE 2850
-- CLARK 2450 CLARK 2450
-- MILLER 1300 CLARK 2450
-- JONES 2975 JONES 2975
-- FORD 3000 JONES 2975
-- SMITH 800 JONES 2975
-- SCOTT 3300 JONES 2975
-- ADAMS 1100 JONES 2975
-- 13 rows selected.
select e.ENAME EMP_NAME,e.SAL EMP_SAL,
       m.ENAME MRG_NAME,m.SAL MGR_SAL
from EMP e, EMP m
where e.MGR = m.EMPNO ;
-- 14. Tìm những nhân viên kiếm được lương cao nhất trong mỗi loại nghề nghiệp.
-- JOB MAX(SAL)
-- ANALYST 3000
-- CLERK 1300
-- MANAGER 2975
-- PRESIDENT 5000
-- SALESMAN 1600
select job ,max(sal) from emp
group by job;
-- 15. Tìm mức lương cao nhất trong mỗi phòng ban, sắp xếp theo thứ tự phòng ban.
-- ENAME JOB DEPTNO SAL
-- KING PRESIDENT 10 5000
-- SCOTT SALEMAN 20 3300
-- BLAKE MANAGER 30 2850
select ENAME, JOB , DEPTNO , SAL from EMP where SAL in (select max(SAL) from EMP group by DEPTNO)
order by DEPTNO;
-- 16. Tìm nhân viên gia nhập vào phòng ban sớm nhất
select ename, to_char(hiredate,'dd-MM-yyyy') hiredate, deptno from emp
where hiredate in(select min(hiredate) from emp group by deptno);
-- ENAME HIREDATE DEPTNO
-- CLARK 09-06-1981 10
-- SMITH 17-12-1980 20
-- ALLEN 20-02-1981 30
-- 17. Hiển thị những nhân viên có mức lương lớn hơn lương TB của phòng ban mà họ làm
-- việc.
select distinct e.empno,e.ename, e.sal ,m.deptno
from emp e, emp m
where e.DEPTNO=m.DEPTNO
group by m.deptno, e.empno,e.ename, e.sal
having e.sal > avg(m.sal)
-- EMPNO ENAME SAL DEPTNO
-- 7839 KING 5000 10
-- 7566 JONES 2975 20
-- 7902 FORD 3000 20
-- 7788 SCOTT 3300 20
-- 7698 BLAKE 2850 30
-- 7499 ALLEN 1600 30
-- 18. Hiển thị tên nhân viên, mã nhân viên, mã giám đốc, tên giám đốc, phòng ban làm
-- việc của giám đốc, mức lương của giám đốc.
-- EMP_NUMBER EMP_NAME EMP_SAL MGR_NUMBER MGR_NAME MGR_DEPT MGR_GRADE
-- 7698 BLAKE 2850 7698 BLAKE 30 4
-- 7654 MARTIN 1250 7698 BLAKE 30 4
-- 7499 ALLEN 1600 7698 BLAKE 30 4
-- 7844 TURNER 1500 7698 BLAKE 30 4
-- 7900 JAMES 950 7698 BLAKE 30 4
-- 7521 WARD 1250 7698 BLAKE 30 4
-- 7782 CLARK 2450 7782 CLARK 10 4
-- 7934 MILLER 1300 7782 CLARK 10 4
-- 7566 JONES 2975 7566 JONES 20 4
-- 7902 FORD 3000 7566 JONES 20 4
-- 7369 SMITH 800 7566 JONES 20 4
-- 7788 SCOTT 3300 7566 JONES 20 4
-- 7876 ADAMS 1100 7566 JONES 20 4
-- 13 rows selected.
select e.empno emp_number, e.ename emp_name, e.sal emp_sal, m.mgr mgr_number,
       m.ename mgr_name, m.deptno mgr_dept,grade
from emp e join emp m on e.mgr = m.empno, salgrade;