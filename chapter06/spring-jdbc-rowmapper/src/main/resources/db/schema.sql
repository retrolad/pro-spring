CREATE TABLE developer(
    id INT NOT NULL AUTO_INCREMENT ,
    name VARCHAR(60) NOT NULL UNIQUE ,
    founded DATE ,
    PRIMARY KEY (id)
);

CREATE TABLE game(
    id INT NOT NULL AUTO_INCREMENT ,
    developer_id INT NOT NULL ,
    title VARCHAR(100) NOT NULL ,
    release_date DATE,
    UNIQUE (developer_id, title),
    PRIMARY KEY (ID),
    FOREIGN KEY (developer_id) references developer(id)
);