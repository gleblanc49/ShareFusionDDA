
    create table Competition (
        competitionId integer not null auto_increment,
        competitonName varchar(255),
        version integer not null,
        primary key (competitionId)
    );

    create table Dancer (
        dancerId integer not null auto_increment,
        address1 varchar(255),
        address2 varchar(255),
        city varchar(255),
        email1 varchar(255),
        email2 varchar(255),
        email3 varchar(255),
        email4 varchar(255),
        email5 varchar(255),
        firstName varchar(255),
        lastName varchar(255),
        postalCode varchar(255),
        province varchar(255),
        primary key (dancerId)
    );

    create table Invoice (
        invoiceId integer not null auto_increment,
        hst tinyint not null,
        invoiceDate datetime,
        paid tinyint not null,
        dancerSeason_dancerSeasonId integer,
        primary key (invoiceId)
    );

    create table Invoiceitem (
        invoiceItemId integer not null auto_increment,
        cost decimal(19,2),
        description varchar(255),
        itemName varchar(255),
        invoiceId integer,
        primary key (invoiceItemId)
    );

    create table Season (
        seasonId integer not null auto_increment,
        duoChoreographyCost decimal(19,2),
        fusionBaseCost decimal(19,2),
        groupChoreographyCost decimal(19,2),
        seasonName varchar(255),
        soloChoreographyCost decimal(19,2),
        trioChoreographyCost decimal(19,2),
        primary key (seasonId)
    );

    create table competition_season (
        competitionSeasonId integer not null auto_increment,
        duoCost decimal(19,2),
        groupCost decimal(19,2),
        soloCost decimal(19,2),
        trioCost decimal(19,2),
        competitionId integer,
        seasonId integer,
        primary key (competitionSeasonId)
    );

    create table dancer_competition_season (
        dancerCompetitionSeasonId integer not null auto_increment,
        competitionSeasonId integer,
        dancerSeasonId integer,
        primary key (dancerCompetitionSeasonId)
    );

    create table dancer_season (
        dancerSeasonId integer not null auto_increment,
        dancerId integer,
        seasonId integer,
        primary key (dancerSeasonId)
    );

    create table dancer_season_dance (
        dancerSeasonDanceId integer not null auto_increment,
        dancerSeasonId integer,
        seasonDanceId integer,
        primary key (dancerSeasonDanceId)
    );

    create table season_dance (
        seasonDanceId integer not null auto_increment,
        seasonDanceName varchar(255),
        seasonDanceType varchar(255),
        seasonId integer,
        primary key (seasonDanceId)
    );

    alter table Invoice 
        add index FKD80EDB0D82FE31F5 (dancerSeason_dancerSeasonId), 
        add constraint FKD80EDB0D82FE31F5 
        foreign key (dancerSeason_dancerSeasonId) 
        references dancer_season (dancerSeasonId);

    alter table Invoiceitem 
        add index FK301207A08EA30FFC (invoiceId), 
        add constraint FK301207A08EA30FFC 
        foreign key (invoiceId) 
        references Invoice (invoiceId);

    alter table competition_season 
        add index FKB28031638F960D7A (seasonId), 
        add constraint FKB28031638F960D7A 
        foreign key (seasonId) 
        references Season (seasonId);

    alter table competition_season 
        add index FKB2803163FD3B1520 (competitionId), 
        add constraint FKB2803163FD3B1520 
        foreign key (competitionId) 
        references Competition (competitionId);

    alter table dancer_competition_season 
        add index FK29A10683E7BED286 (competitionSeasonId), 
        add constraint FK29A10683E7BED286 
        foreign key (competitionSeasonId) 
        references competition_season (competitionSeasonId);

    alter table dancer_competition_season 
        add index FK29A106837818BED8 (dancerSeasonId), 
        add constraint FK29A106837818BED8 
        foreign key (dancerSeasonId) 
        references dancer_season (dancerSeasonId);

    alter table dancer_season 
        add index FKB4D9F0038F960D7A (seasonId), 
        add constraint FKB4D9F0038F960D7A 
        foreign key (seasonId) 
        references Season (seasonId);

    alter table dancer_season 
        add index FKB4D9F003A14926F2 (dancerId), 
        add constraint FKB4D9F003A14926F2 
        foreign key (dancerId) 
        references Dancer (dancerId);

    alter table dancer_season_dance 
        add index FKC23F477B9E43EA2 (seasonDanceId), 
        add constraint FKC23F477B9E43EA2 
        foreign key (seasonDanceId) 
        references season_dance (seasonDanceId);

    alter table dancer_season_dance 
        add index FKC23F4777818BED8 (dancerSeasonId), 
        add constraint FKC23F4777818BED8 
        foreign key (dancerSeasonId) 
        references dancer_season (dancerSeasonId);

    alter table season_dance 
        add index FKCAF4C7578F960D7A (seasonId), 
        add constraint FKCAF4C7578F960D7A 
        foreign key (seasonId) 
        references Season (seasonId);
