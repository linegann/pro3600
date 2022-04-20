drop database UberRitz;
use UberRitz;
create table plats (
id bigint(10) primary key auto_increment not null,
prix decimal(10) not null,
nom varchar(20) not null
);
insert into plats(nom, prix) values('Gros steak là', 17.5);
insert into plats(nom, prix) values('mangue' , 3);
insert into plats(nom, prix) values('épinard', 1);
