CREATE TABLE pacientes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    telefone BIGINT NOT NULL,

    -- Campos de Endereço integrados
    logradouro VARCHAR(255) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cep BIGINT NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    uf CHAR(2) NOT NULL,
    complemento VARCHAR(255),
    numero VARCHAR(20),

    PRIMARY KEY (id)
);