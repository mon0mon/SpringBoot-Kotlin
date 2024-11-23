DROP SEQUENCE IF EXISTS AUTHOR_ID_SEQ;
CREATE SEQUENCE AUTHOR_ID_SEQ START WITH 1 INCREMENT BY 50;

DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS
(
    ID          BIGINT NOT NULL,
    NAME        VARCHAR(512),
    AGE         smallint,
    DESCRIPTION VARCHAR(512),
    IMAGE       VARCHAR(512),
    CONSTRAINT PK_AUTHORS PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS "books";
CREATE TABLE BOOKS
(
    ISBN        VARCHAR(19) NOT NULL,
    TITLE       VARCHAR(512),
    DESCRIPTION VARCHAR(2048),
    IMAGE       VARCHAR(512),
    AUTHOR_ID   BIGINT,
    CONSTRAINT PK_BOOKS PRIMARY KEY (ISBN)
);

ALTER TABLE BOOKS
    ADD CONSTRAINT FK_BOOKS_ON_AUTHOR FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHORS (ID);