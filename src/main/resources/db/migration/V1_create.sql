CREATE TABLE funcionario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(10) NOT NULL
);

CREATE TABLE qrcode (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    valor VARCHAR(255) NOT NULL,
    tipo VARCHAR(255) NOT NULL
);

CREATE TABLE setor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    codigo VARCHAR(255) NOT NULL
);

CREATE TABLE moto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(7) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    qrcode_id BIGINT,
    setor_id_setor BIGINT,
    CONSTRAINT fk_moto_qrcode FOREIGN KEY (qrcode_id) REFERENCES qrcode (id),
    CONSTRAINT fk_moto_setor FOREIGN KEY (setor_id_setor) REFERENCES setor (id)
);

CREATE TABLE alerta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    descricao VARCHAR(255),
    data_hora TIMESTAMP,
    lido BOOLEAN NOT NULL,
    moto_id BIGINT,
    setor_id BIGINT,
    CONSTRAINT fk_alerta_moto FOREIGN KEY (moto_id) REFERENCES moto (id),
    CONSTRAINT fk_alerta_setor FOREIGN KEY (setor_id) REFERENCES setor (id)
);

CREATE TABLE setor_moto (
    setor_id BIGINT NOT NULL,
    moto_id BIGINT NOT NULL,
    PRIMARY KEY (setor_id, moto_id),
    CONSTRAINT fk_setor_moto_setor FOREIGN KEY (setor_id) REFERENCES setor (id),
    CONSTRAINT fk_setor_moto_moto FOREIGN KEY (moto_id) REFERENCES moto (id)
);
