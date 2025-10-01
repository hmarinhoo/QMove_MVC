
CREATE TABLE funcionario (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(10) NOT NULL
);

CREATE TABLE setor (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    codigo VARCHAR(255) NOT NULL
);

CREATE TABLE moto (
    id BIGSERIAL PRIMARY KEY,
    placa VARCHAR(7) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    setor_id BIGINT,
    CONSTRAINT fk_moto_setor FOREIGN KEY (setor_id) REFERENCES setor (id)
);

CREATE TABLE setor_moto (
    setor_id BIGINT NOT NULL,
    moto_id BIGINT NOT NULL,
    PRIMARY KEY (setor_id, moto_id),
    CONSTRAINT fk_setor_moto_setor FOREIGN KEY (setor_id) REFERENCES setor (id),
    CONSTRAINT fk_setor_moto_moto FOREIGN KEY (moto_id) REFERENCES moto (id)
);

