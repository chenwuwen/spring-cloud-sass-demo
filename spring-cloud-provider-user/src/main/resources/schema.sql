-- H2数据库 目前还不完美支持使用UNIX_TIMESTAMP()函数将日期更改为时间戳
DROP TABLE TENANT IF EXISTS;

CREATE TABLE TENANT (
ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
TENANT_NAME varchar(200) NOT NULL,
SIMPLICITY varchar(200) NOT NULL,
DOMAIN varchar(200) NOT NULL,
DB_URL varchar(200) NOT NULL,
DB_USER varchar(200) NOT NULL,
DB_PASS varchar(200) NOT NULL,
REGISTER_DATE Date  DEFAULT NULL ,
PRIMARY KEY (Id)
);

