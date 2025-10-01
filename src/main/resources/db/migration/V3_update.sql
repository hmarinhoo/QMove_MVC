-- Atualizar motos para os setores corretos
UPDATE moto SET setor_id = 1, status = 'Em manutenção' WHERE placa = 'ABC1234';
UPDATE moto SET setor_id = 2, status = 'Disponível' WHERE placa = 'XYZ5678';
UPDATE moto SET setor_id = 3, status = 'Com pendências' WHERE placa = 'DEF9012';
