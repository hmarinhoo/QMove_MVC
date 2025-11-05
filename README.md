# QMove – Sistema de Gestão de Pátio da Mottu
# QMove MVC - Sistema de Gestão de Pátio de Motos

## 👥 Integrantes
* 👩‍💻 Hellen Marinho Cordeiro - RM: 558841
* 👩‍💻 Heloisa Alves de Mesquita - RM: 559145

## 🌐 Visão Geral

O **QMove** é uma aplicação web completa desenvolvida com Spring Boot para otimizar a gestão do pátio da Mottu. O sistema auxilia na organização, identificação e localização de motos de forma tecnológica, ágil e eficiente através de cadastro automatizado e geração de QR Codes únicos.

Esta versão MVC do projeto foca no gerenciamento administrativo, fornecendo uma interface web robusta para cadastro e controle de motos e setores do pátio.

## 🎯 Objetivo da Solução

Automatizar o controle de motos no pátio através de:
- Cadastro centralizado de motos
- Organização por setores
- Geração automática de QR Codes únicos
- Interface administrativa intuitiva
- Controle de acesso seguro com diferentes perfis

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
  - Spring Web MVC
  - Spring Data JPA
  - Spring Security
  - Spring Validation
- **Thymeleaf** - Template Engine para views
- **Flyway** - Versionamento de Banco de Dados
- **MySQL** - Banco de Dados Relacional
- **Bootstrap 5** - Framework CSS
- **Maven** - Gerenciamento de Dependências

## 🏗️ Arquitetura do Projeto

```
src/
├── main/
│   ├── java/com/fiap/qmove/
│   │   ├── config/          # Configurações (Security, etc)
│   │   ├── controller/      # Controladores MVC
│   │   ├── model/           # Entidades JPA
│   │   ├── repository/      # Repositórios Spring Data
│   │   ├── service/         # Lógica de negócio
│   │   └── dto/             # Data Transfer Objects
│   └── resources/
│       ├── templates/       # Views Thymeleaf
│       │   ├── fragments/   # Fragmentos reutilizáveis (header, footer, menu)
│       │   ├── auth/        # Páginas de autenticação
│       │   ├── moto/        # CRUD de motos
│       │   ├── setor/       # CRUD de setores
│       │   ├── funcionario/ # Gestão de funcionários
│       │   └── dashboard/   # Painel administrativo
│       ├── static/          # CSS, JS, imagens
│       │   ├── css/
│       │   ├── js/
│       │   └── img/
│       └── db/migration/    # Scripts Flyway (mínimo 4 versões)
└── test/                    # Testes unitários e integração
```

## ✨ Funcionalidades por Perfil de Usuário

### 👑 ADMINISTRADOR - Acesso Total

O perfil de Administrador possui controle completo sobre o sistema:

#### 🏍️ Gestão de Motos
- ✅ **Cadastro** de novas motos
- ✅ **Edição** de informações existentes
- ✅ **Exclusão** de motos
- ✅ **Listagem** completa com filtros
- ✅ **Visualização** de detalhes e QR Code

#### 📍 Gestão de Setores
- ✅ **Criação** de novos setores
- ✅ **Edição** de setores existentes
- ✅ **Exclusão** de setores (com validação)
- ✅ **Visualização** completa
- ✅ **Monitoramento** de capacidade e ocupação

#### 👥 Gestão de Funcionários
- ✅ **Cadastro** de novos perfis de funcionários
- ✅ **Edição** de dados de funcionários
- ✅ **Exclusão** de perfis
- ✅ **Atribuição** de permissões
- ✅ **Gerenciamento** de credenciais de acesso

---

### 👷 FUNCIONÁRIO - Acesso Operacional

O perfil de Funcionário possui acesso focado nas operações diárias:

#### 🏍️ Gestão de Motos (Acesso Total)
- ✅ **Cadastro** de novas motos no sistema
- ✅ **Edição** de informações das motos
- ✅ **Exclusão** de motos
- ✅ **Listagem** completa 
- ✅ **Visualização** de código do QR Code gerado
- ✅ **Associação** de motos aos setores

#### 📍 Setores (Somente Leitura)
- 👁️ **Visualização** de todos os setores
- 👁️ **Consulta** de quantas motos há em cada setor
- 👁️ **Acesso** às informações de ocupação
- ❌ **Sem permissão** para criar, editar ou excluir setores

#### 🚫 Restrições
- ❌ Não pode gerenciar outros funcionários
- ❌ Não pode criar/editar/excluir setores

---

## 🔐 Sistema de Autenticação (Spring Security)

### Configuração de Perfis

```java
public enum Role {
    ADMIN,      // Acesso total ao sistema
    FUNCIONARIO // Acesso operacional limitado
}
```

## 🗄️ Versionamento do Banco de Dados (Flyway)

 A aplicação utiliza PostgreSQL e o Flyway para migração automática do banco de dados. As migrações estão localizadas em:
 
 ```
src/main/resources/db/migration/
 ```


## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java 17 ou superior
- Maven 3.8+
- MySQL 8.0+
- Git

### Passo a Passo

**1. Clone o repositório**
```bash
git clone https://github.com/hmarinhoo/QMove_MVC
cd QMove_MVC
```

**2. Configure o banco de dados**

Edite `src/main/resources/application.properties`:
```properties
# Datasource
spring.datasource.url=jdbc:mysql://localhost:3306/qmove_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# Flyway
spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true

# JPA
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Security
spring.security.user.name=admin
spring.security.user.password=admin123
```

**4. Execute o projeto**
```bash
mvn spring-boot:run
```

**5. Acesse a aplicação**
```
http://localhost:8080
```

### 🔑 Credenciais de Acesso

**Administrador:**
- E-mail: `admin@qmove.com`
- Senha: `admin123`
- **Permissões:** Acesso total ao sistema

**Funcionário:**
- E-mail: `funcionario@qmove.com`
- Senha: `func123`
- **Permissões:** Gestão de motos + visualização de setores

## 📦 Build e Deploy

### Gerar JAR
```bash
mvn clean package
```

### Executar JAR
```bash
java -jar target/qmove-0.0.1-SNAPSHOT.jar
```

### Deploy em Produção
Aplicação preparada para deploy em:
- Render

## 🧪 Validações Implementadas

### Validações de Motos:
- ✅ Placa no formato Mercosul (ABC1D23)
- ✅ Placa única no sistema
- ✅ Modelo obrigatório (mín. 3 caracteres)
- ✅ Ano entre 1990 e ano atual
- ✅ Cor obrigatória
- ✅ Setor obrigatório e existente

### Validações de Setores:
- ✅ Nome único (mín. 3 caracteres)
- ✅ Capacidade mínima de 1 moto
- ✅ Descrição opcional
- ✅ Verificação de motos antes de exclusão

### Validações de Funcionários:
- ✅ E-mail válido e único
- ✅ Senha forte (mín. 6 caracteres)
- ✅ Perfil obrigatório


### 💡 Fluxo Completo da Solução:
1. **Cadastro (MVC):** Admin ou Funcionário cadastra moto → sistema gera QR Code único
2. **Identificação (IoT):** QR Code físico é impresso e fixado na moto
3. **Operação (Mobile):** Funcionário em campo escaneia QR Code com smartphone
4. **Consulta (API):** Sistema retorna dados da moto e localização atual
6. **Visualização (MVC):** Administradores monitoram em tempo real pelo dashboard


**Equipe:**
- Hellen Marinho Cordeiro - RM: 558841
- Heloisa Alves de Mesquita - RM: 559145

---
