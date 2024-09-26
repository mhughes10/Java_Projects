DROP TABLE IF EXISTS user_record_v1;

CREATE TABLE IF NOT EXISTS user_record_v1 
(
	id INT NOT NULL,
	name VARCHAR(250) NOT NULL,
	version INT, 
	PRIMARY KEY (id)
);