create table serverContainer(
                     containerId numeric,
                     containerName  varchar(32),
                     constraint pk_container primary key ( containerId )
);

create table server(
                    serverId    numeric,
                    serverName    varchar(32),
                    serverDescription      varchar(120),
                    serverCPU      varchar(32),
                    serverRam   numeric,
                    containerId numeric,
                    constraint pk_server primary key ( serverId ),
                    constraint fk_containerId foreign key ( containerId ) references serverContainer ( containerId )
);

insert into serverContainer values( 10, 'WEBSITES' );
insert into serverContainer values( 20, 'DATABASES' );
insert into serverContainer values( 30, 'ASSETS' );

insert into server values(
                          1, 'GAMES', 'Games to play for fun', 'Intel Xeon E5-2620',
                          2048, 10
                      );
insert into server values(
                             2, 'MONGO', 'Main MongoDB server for game stats', 'Intel Xeon E3-1220',
                             4096, 20
                         );
insert into server values(
                             3, 'SQL', 'Main SQL server for website stats', 'Intel Xeon E3-1220',
                             2048, 20
                         );
insert into server values(
                             1337, 'SECRET_MARIO_LEAK', 'Play, tell no one', 'AMD EPYC 7742',
                             16384, 10
                         );