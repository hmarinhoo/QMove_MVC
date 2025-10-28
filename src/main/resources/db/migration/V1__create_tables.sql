-- Criação das tabelas principais do sistema QMove Web

CREATE TABLE role (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE funcionario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE funcionario_roles (
    funcionario_id INTEGER NOT NULL REFERENCES funcionario(id) ON DELETE CASCADE,
    role_id INTEGER NOT NULL REFERENCES role(id) ON DELETE CASCADE,
    PRIMARY KEY (funcionario_id, role_id)
);

CREATE TABLE setor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    codigo VARCHAR(50)
);

CREATE TABLE moto (
    id SERIAL PRIMARY KEY,
    placa VARCHAR(10) NOT NULL UNIQUE,
    modelo VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    setor_id INTEGER REFERENCES setor(id)
);

CREATE TABLE alerta (
    id SERIAL PRIMARY KEY,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    moto_id INTEGER REFERENCES moto(id)
);
