# Projeto de Saúde e Bem-estar

## Descrição do Projeto
Este projeto tem como objetivo desenvolver uma aplicação de backend para o gerenciamento de medicamentos, mapeamento de atendimentos médicos e recomendações médicas. Utilizando o framework Spring, o sistema permitirá a criação, leitura, atualização e exclusão (CRUD) de entidades relacionadas a pacientes, medicamentos, atendimentos médicos e recomendações médicas.

## Tecnologias Utilizadas
- Java 11
- Spring Boot
- Spring Data JPA
- Spring Web
- Maven

## Membros do Projeto
- João Victor Miotelli Vitali
- Theo Grings Gomide

## Configuração do Ambiente

### Pré-requisitos
- Java 11 ou superior
- Maven 3.6.3 ou superior

### Passo a Passo

1. **Clonar o Repositório**
   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   
2. **Configurar o Banco de Dados**
O projeto está configurado para usar o banco de dados H2 em memória por padrão. Você pode alterar as configurações no arquivo application.properties se desejar usar outro banco de dados.

3. **Compilar o Projeto**
Execute o comando abaixo para compilar o projeto e baixar todas as dependências necessárias:
   ```sh
   mvn clean install

4. **Executar a Aplicação**
Após a compilação, execute o comando abaixo para iniciar a aplicação:
   ```sh
   mvn spring-boot:run

5. **Acessar a Aplicação**
A aplicação estará disponível em http://localhost:8080.

## Endpoints

## Endpoints

### Pacientes
- `POST /pacientes` - Criar um novo paciente
- `GET /pacientes` - Listar todos os pacientes (com paginação)
- `GET /pacientes/{id}` - Obter detalhes de um paciente
- `PUT /pacientes/{id}` - Atualizar um paciente existente
- `DELETE /pacientes/{id}` - Remover um paciente

### Medicamentos
- `POST /medicamentos` - Criar um novo medicamento
- `GET /medicamentos` - Listar todos os medicamentos (com paginação)
- `GET /medicamentos/{id}` - Obter detalhes de um medicamento
- `PUT /medicamentos/{id}` - Atualizar um medicamento existente
- `DELETE /medicamentos/{id}` - Remover um medicamento

### Atendimentos Médicos
- `POST /atendimentos` - Criar um novo atendimento médico
- `GET /atendimentos` - Listar todos os atendimentos médicos (com paginação)
- `GET /atendimentos/{id}` - Obter detalhes de um atendimento médico
- `PUT /atendimentos/{id}` - Atualizar um atendimento médico existente
- `DELETE /atendimentos/{id}` - Remover um atendimento médico

### Recomendação Médica
- `POST /recomendacoes` - Criar uma nova recomendação médica
- `GET /recomendacoes` - Listar todas as recomendações médicas (com paginação)
- `GET /recomendacoes/{id}` - Obter detalhes de uma recomendação médica
- `PUT /recomendacoes/{id}` - Atualizar uma recomendação médica existente
- `DELETE /recomendacoes/{id}` - Remover uma recomendação médica

### Ajuda
- `GET /ajuda` - Obter informações sobre os estudantes e o projeto

## Tratamento de Erros
A aplicação inclui um manipulador global de exceções para lidar com erros do cliente e retornar respostas apropriadas. Exceções personalizadas são utilizadas para fornecer mensagens de erro claras.
