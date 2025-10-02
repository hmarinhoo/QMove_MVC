# QMove – Sistema de Gestão de Pátio da Mottu

O QMove é uma solução tecnológica desenvolvida para a Mottu com o objetivo de otimizar a gestão do pátio, facilitando a organização, identificação e localização das motocicletas de forma ágil, precisa e digital.

Através da integração entre backend robusto, aplicativo móvel e tecnologia baseada em QR Code, o QMove transforma um processo tradicionalmente manual em uma operação automatizada, segura e escalável.

---

## 👥 Integrantes

- 👩‍💻 Hellen Marinho Cordeiro – RM: 558841  
- 👩‍💻 Heloisa Alves de Mesquita – RM: 559145

---

## Tecnologias Utilizadas

- **Java 21**  
- **Spring Boot 3.x**  
- **Spring Security** (login via formulário + OAuth2 GitHub)  
- **Thymeleaf** (renderização de páginas HTML, com fragmentos para cabeçalho, rodapé e menu)  
- **Flyway** (versionamento do banco de dados)  
- **PostgreSQL**  
- **Docker / Docker Compose**  

---

## Pré-requisitos

Antes de executar a aplicação, certifique-se de ter instalado:

- Java 21 ou superior  
- Docker e Docker Compose  
- Git (para clonar o repositório)  

---

## ⚙️ Configuração

### 1. Clonar o repositório

```bash
git clone https://github.com/hmarinhoo/QMove_MVC
cd QMove_MVC


2. Configuração da Autenticação com GitHub (OAuth2)

Para rodar a aplicação com login via GitHub, siga os passos abaixo:

Acesse o GitHub Developer Settings

Vá para: https://github.com/settings/developers

Clique em OAuth Apps no menu lateral

Clique em New OAuth App

Preencha os dados do aplicativo

Application name: QMove Local (ou qualquer nome de sua preferência)

Homepage URL: http://localhost:8080

Authorization callback URL: http://localhost:8080/login/oauth2/code/github

Clique em Register application

Copie as credenciais

Clique em Generate a new client secret (se ainda não tiver)

Copie os dois valores:

Client ID (ex: a1b2c3d4e5f6...)

Client Secret (ex: ghs_abc123xyz...) → guarde com cuidado!

Configure as variáveis no seu projeto

Edite o arquivo src/main/resources/application.properties e adicione/substitua:

spring.security.oauth2.client.registration.github.client-id=SEU_CLIENT_ID_AQUI
spring.security.oauth2.client.registration.github.client-secret=SEU_CLIENT_SECRET_AQUI


Substitua SEU_CLIENT_ID_AQUI e SEU_CLIENT_SECRET_AQUI pelos valores copiados do GitHub.
