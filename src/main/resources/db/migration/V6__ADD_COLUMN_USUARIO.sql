CREATE TABLE usuarios
(
    id      BIGINT       NOT NULL AUTO_INCREMENT,
    usuario VARCHAR(255) NOT NULL,
    senha   VARCHAR(150) NOT NULL,

    primary key (id)

);