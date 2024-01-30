create table if not exists users(
    username text not null primary key,
    password text not null,
    enabled boolean not null);

create table if not exists authorities (
    username text not null,
    authority text not null,
    constraint fk_authorities_users foreign key(username) references users(username));

create unique index ix_auth_username on authorities (username,authority);