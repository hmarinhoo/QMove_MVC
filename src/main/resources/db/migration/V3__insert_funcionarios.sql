-- Usuário administrador inicial
-- Senha: admin123 (vai ser criptografada na aplicação com BCrypt na inicialização)

INSERT INTO funcionario (nome, email, senha, ativo)
VALUES ('Administrador', 'admin@mottu.com', '$2a$10$DlS6b9vlP0xL2TPZJYoBbe7N6vQhM/JQbqJfPsFr6vWBaXP2TjFiC', TRUE);

-- Atribui o papel ADMIN ao usuário administrador
INSERT INTO funcionario_roles (funcionario_id, role_id)
SELECT f.id, r.id FROM funcionario f, role r
WHERE f.email = 'admin@mottu.com' AND r.nome = 'ROLE_ADMIN';
