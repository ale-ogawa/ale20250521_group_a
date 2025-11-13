--アプリの起動ごとにテーブルを作り直す
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS diaries;
DROP TABLE IF EXISTS medicine_taking;
DROP TABLE IF EXISTS medicines;
DROP TABLE IF EXISTS takings;
DROP TABLE IF EXISTS diseases;
DROP TABLE IF EXISTS groups;
DROP TABLE IF EXISTS scopes;
DROP TABLE IF EXISTS reactions;
DROP TABLE IF EXISTS choices;

CREATE TABLE accounts(
	id serial PRIMARY KEY,
	address varchar(50),
	password varchar(100),
	nickname varchar(10),
	attribute boolean,
	share varchar(10000),
	group_id Integer,
	follow_id Integer
);

CREATE TABLE diaries(
	id serial PRIMARY KEY,
	account_id Integer,
	feeling Integer,
	text varchar(1000),
	date date
);

CREATE TABLE scopes(
	diary_id Integer,
	group_id Integer,
	setting boolean
);


CREATE TABLE medicines(
	id serial PRIMARY KEY,
	account_id Integer,
	name varchar(50),
	quantity varchar(20),
	type varchar(20),
	effect varchar(500),
	side_effect varchar(500)
);

CREATE TABLE takings(
	id serial PRIMARY KEY,
	account_id Integer,
	time timestamp
);

CREATE TABLE medicine_taking (
    taking_id Integer REFERENCES takings(id) ON DELETE CASCADE,
    medicine_id Integer REFERENCES medicines(id),
    dose Integer,
    PRIMARY KEY (taking_id, medicine_id)
);

CREATE TABLE diseases(
	id serial PRIMARY KEY,
	name varchar(30)
);

CREATE TABLE groups(
	id serial PRIMARY KEY,
	account_id Integer,
	name varchar(20),
	code Integer
);

CREATE TABLE reactions(
	id serial PRIMARY KEY,
	account_id Integer,
	diary_id Integer,
	stamp Integer,
	comment varchar(30)
);
/*髙田さん分*/
CREATE TABLE choices(
	account_id Integer,
	disease_id Integer
);