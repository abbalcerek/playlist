
create table song (id bigint not null, author varchar(255), name varchar(255), primary key (id))
create table url (id bigint not null, url varchar(255), song_id bigint not null, primary key (id))
create table user (id bigint not null, ip varchar(255), name varchar(255), primary key (id))
create table user_vote (song binary(255) not null, user binary(255) not null, rating integer, primary key (song, user))
alter table user add constraint UK_bufuib3l7ce7eg9kl552msn11 unique (ip)
alter table url add constraint FK_vav40iooes28vy3g12453tem foreign key (song_id) references song