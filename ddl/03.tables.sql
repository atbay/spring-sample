-- create table organizations 
CREATE TABLE organizations
(
	id							BIGSERIAL	,
	name						VARCHAR	,
	description					VARCHAR	,
	code						VARCHAR	,
	note						VARCHAR	,
	address						VARCHAR	,
	tel							VARCHAR	,
	deleted						BOOLEAN	DEFAULT False	,
	create_date					TIMESTAMP	,
	update_date					TIMESTAMP	,
CONSTRAINT pk_organizations PRIMARY KEY(id)
)
; 

-- create table users
CREATE TABLE users
(
	id							BIGSERIAL	,
	user_id						VARCHAR	,
	name						VARCHAR	,
	password					VARCHAR	,
	email						VARCHAR	,
	tel							VARCHAR	,
	organizations_id			BIGINT	,
	deleted						BOOLEAN	DEFAULT False	,
	create_date					TIMESTAMP	,
	update_date					TIMESTAMP	,
CONSTRAINT pk_users PRIMARY KEY(id),
CONSTRAINT fk_users_1 FOREIGN KEY(organizations_id) REFERENCES organizations(id) ON DELETE CASCADE
)
;
 