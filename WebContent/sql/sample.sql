SELECT * FROM customer;

DELETE customer where customer_id = 'tpdud';

INSERT INTO customer
VALUES ('seyoung', '1234', '유세영', '01012345678', '25463', '101동 1101호');

INSERT INTO customer
VALUES ('mong', '1234', '유몽돌', '01098745632', '25436', '198동 1004호');

INSERT INTO customer
VALUES ('pang', '1234', '눈팽이', '01023102459', '52419', '강릉어딘가로');

INSERT INTO customer
VALUES ('suni', '1234', '진수니', '01021546359', '41257', '이케아로');

INSERT INTO customer
VALUES ('dori', '1234', '진도리', '01026587951', '41257', '이케아로');

INSERT INTO customer
VALUES ('t', '1234', '소두곰', '01023462186', '42169', '두곰두곰로');

-----------------------------------------------------------------------

SELECT * FROM board;

DELETE board where board_number=3;

INSERT INTO board 
VALUES (
	(SELECT NVL(MAX(board_number),0)+1 FROM board),
	'jinsuni',(SELECT SYSDATE FROM dual),'순두부찌개','바지락도 넣어 주새요',3
);

INSERT INTO board 
VALUES (
	(SELECT NVL(MAX(board_number),0)+1 FROM board),
	'mong',(SELECT SYSDATE FROM dual),'고구마','고구마가 제일 맛있엉',4
);

INSERT INTO board 
VALUES (
	(SELECT NVL(MAX(board_number),0)+1 FROM board),
	'pang',(SELECT SYSDATE FROM dual),'팥빙수','이한치한!',1
);

SELECT 	e.EMPLOYEE_ID , e.FIRST_NAME , e.HIRE_DATE ,
		jh.START_DATE , jh.END_DATE , jh.JOB_ID , jh.DEPARTMENT_ID 
FROM 	EMPLOYEES e 
 LEFT OUTER JOIN JOB_HISTORY jh 
 ON e.EMPLOYEE_ID = jh.EMPLOYEE_ID 

