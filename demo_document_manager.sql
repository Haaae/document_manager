/* root 계정으로 접속, document_manager 데이터베이스 생성, document_manager 계정 생성 */
DROP DATABASE  IF EXISTS document_manager;
DROP USER IF EXISTS document_manager@localhost;
create user document_manager@localhost identified WITH mysql_native_password by 'document';
create database document_manager;
grant all privileges on document_manager.* to document_manager@localhost with grant option;
commit;

/* document_manager DB 자료 생성 */
USE document_manager;

CREATE TABLE Repository (
    name    VARCHAR(20) PRIMARY KEY
) CHARSET=utf8;

CREATE TABLE Repository_status (
    no              INT             NOT NULL ,
    message         VARCHAR(100)    NOT NULL ,
    repository_name VARCHAR(20)     NOT NULL ,
    FOREIGN KEY (repository_name) REFERENCES Repository(name) ,
    PRIMARY KEY (no, repository_name)
) CHARSET=utf8;

CREATE TABLE Document (
    contents        VARCHAR(20000) ,
    name            VARCHAR(20) NOT NULL ,
    repository_name VARCHAR(20) NOT NULL ,
    status_no       INTEGER     NOT NULL ,
    FOREIGN KEY (repository_name)   REFERENCES Repository(name) ,
    FOREIGN KEY (status_no)      REFERENCES Repository_status(no) ,
    PRIMARY KEY (name, repository_name, status_no)
) CHARSET=utf8;