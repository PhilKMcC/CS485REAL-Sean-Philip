create table Stage(
	id_stage int not null auto_increment,
	name_stage varchar(20) not null, 
	size varchar(10) not null,
	layout varchar(20) not null,
	constraint Stage_PK primary key (id_stage)
);

insert into Stage(name_stage, size, layout)
	values('Graveyard', 'large', 'walk off');

insert into Stage(name_stage, size, layout)
	values('Lab', 'medium', 'traditional');