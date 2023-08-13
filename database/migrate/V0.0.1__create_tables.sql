create table if not exists "user"
(
    id      varchar(255) primary key,
    name    varchar(255) NOT NULL,
    email   varchar(255) NOT NULL,
    UNIQUE (email)
);
create index on "user"(name);
