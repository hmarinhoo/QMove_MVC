-- Dados iniciais de exemplo para teste

INSERT INTO setor (nome, codigo) VALUES
('Disponível', 'Verde'),
('Manutenção', 'Amarelo'),
('Pendências', 'Azul');

INSERT INTO moto (placa, modelo, status, setor_id) VALUES
('XYZ1234', 'Mottu Sport', 'Disponível', 1),
('ABC5678', 'Mottu City', 'Manutenção', 2),
('DEF9012', 'Mottu Cargo', 'Pendências', 3);
