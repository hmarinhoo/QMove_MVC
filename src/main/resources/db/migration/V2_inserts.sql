-- Inserir setores
INSERT INTO setor (id, nome, codigo) VALUES (1, 'Manutenção', 'Cor Laranja');
INSERT INTO setor (id, nome, codigo) VALUES (2, 'Disponível', 'Cor Verde');
INSERT INTO setor (id, nome, codigo) VALUES (3, 'Pendências', 'Cor Amarela');


-- Inserir motos
INSERT INTO moto (placa, modelo, status, setor_id) VALUES ('ABC1234', 'Mottu Sport', 'Manutenção', 1);
INSERT INTO moto (placa, modelo, status, setor_id) VALUES ('XYZ5678', 'Mottu E', 'Disponível', 1);
INSERT INTO moto (placa, modelo, status, setor_id) VALUES ('DEF9012', 'Mottu Pop', 'Pendências', 2);
