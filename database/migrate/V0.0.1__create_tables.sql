create table if not exists "user"
(
    id      varchar(255) primary key,
    name    varchar(255) NOT NULL,
    email   varchar(255) NOT NULL,
    from_at timestamp    NOT NULL,
    to_at   timestamp    NOT NULL,
    in_z    timestamp    NOT NULL,
    out_z   timestamp    NOT NULL,
    UNIQUE (email)

);
create index on "user"(name);
