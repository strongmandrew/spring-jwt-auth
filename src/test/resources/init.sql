CREATE TABLE IF NOT EXISTS USERS(
    UUID varchar(256) PRIMARY KEY,
    NAME varchar(128) not null,
    SURNAME varchar(128) not null,
    PASSWORD varchar(256) not null
);