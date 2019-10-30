create table T_DEPARTMENT
                                                                                                                                                                                               (
                                                                                                                                                                                                   DEPARTMENT_ID   VARCHAR2(20)  default null not null,
                                                                                                                                                                                                   DEPARTMENT_NAME VARCHAR2(255) default null not null,
                                                                                                                                                                                                   MANAGER         VARCHAR2(255) default null,
                                                                                                                                                                                                   TOTAL_USER      NUMBER(3)     default 0    not null,
                                                                                                                                                                                                   CREATE_TIME     DATE          default null not null
                                                                                                                                                                                               )
/

INSERT INTO SCOTT.T_DEPARTMENT (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER, TOTAL_USER, CREATE_TIME) VALUES ('10001', '研发一部', '张楠', 20, TO_DATE('2013-09-09 15:05:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SCOTT.T_DEPARTMENT (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER, TOTAL_USER, CREATE_TIME) VALUES ('10002', '研发二部', '张婧研', 10, TO_DATE('2013-09-09 15:05:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SCOTT.T_DEPARTMENT (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER, TOTAL_USER, CREATE_TIME) VALUES ('10003', '研发三部', '张东', 30, TO_DATE('2013-09-09 15:05:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SCOTT.T_DEPARTMENT (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER, TOTAL_USER, CREATE_TIME) VALUES ('10004', '测试部', '王丽丽', 40, TO_DATE('2013-09-09 15:05:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SCOTT.T_DEPARTMENT (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER, TOTAL_USER, CREATE_TIME) VALUES ('10005', '质量保证部', '余力', 20, TO_DATE('2013-09-09 15:05:00', 'YYYY-MM-DD HH24:MI:SS'));