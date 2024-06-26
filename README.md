# Projeto de Saúde e Bem-estar

## Descrição do Projeto
Este projeto tem como objetivo desenvolver uma aplicação de backend para o gerenciamento de medicamentos, mapeamento de atendimentos médicos e recomendações médicas. Utilizando o framework Spring, o sistema permitirá a criação, leitura, atualização e exclusão (CRUD) de entidades relacionadas a pacientes, medicamentos, atendimentos médicos e recomendações médicas.

## Funcionalidades
- Cadastro de paciente;
- Geração do atendimento médico;
- Cadastro do medicamento;
- Geração da recomendação médica com base nas informações disponibilizadas no atendimento.

## Tecnologias Utilizadas
- Java
- Spring Boot
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

### Pacientes
- `POST /pacientes` - Criar um novo paciente

  ```json
  {
     "nome":"Teste",
     "sobrenome":"da Silva",
     "idade":21
  }
  
- `GET /pacientes` - Listar todos os pacientes

  ```java
  http://localhost:8080/pacientes
  
- `GET /pacientes/{id}` - Obter detalhes de um paciente

  ```java
  http://localhost:8080/pacientes/{id}
  
- `PUT /pacientes/{id}` - Atualizar um paciente existente

  ```java
  http://localhost:8080/pacientes/{id}

- ```java
  {
     "nome":"Teste",
     "sobrenome":"da Silva Ribeiro",
     "idade":21
  }
  
- `DELETE /pacientes/{id}` - Remover um paciente

  ```java
  http://localhost:8080/pacientes/{id}

### Medicamentos
- `POST /medicamentos` - Criar um novo medicamento

  ```java
   {
    "nome":"Medicamento Teste",
    "descricao":"Descrição medicamento teste"
   }
  
- `GET /medicamentos` - Listar todos os medicamentos

  ```java
   http://localhost:8080/medicamentos
  
- `GET /medicamentos/{id}` - Obter detalhes de um medicamento

  ```java
   http://localhost:8080/medicamentos/{id}
  
- `PUT /medicamentos/{id}` - Atualizar um medicamento existente

  ```java
   http://localhost:8080/medicamentos/{id}

- ```java
  {
    "nome":"Medicamento Teste 2",
    "descricao":"Descrição medicamento teste 2"
  }
  
- `DELETE /medicamentos/{id}` - Remover um medicamento

  ```java
  http://localhost:8080/medicamentos/{id}

### Atendimentos Médicos
- `POST /atendimentos` - Criar um novo atendimento médico

  ```java
  {
    "paciente":{
        "id": 1,
        "nome":"Teste",
        "idade":1},
    "dataAtendimento":"2024-06-19T14:30:00",
    "observacoes":"Teste"
   }
  
- `GET /atendimentos` - Listar todos os atendimentos médicos

  ```java
   http://localhost:8080/atendimentos
  
- `GET /atendimentos/{id}` - Obter detalhes de um atendimento médico

  ```java
   http://localhost:8080/atendimentos/{id}
  
- `PUT /atendimentos/{id}` - Atualizar um atendimento médico existente

  ```java
   http://localhost:8080/atendimentos/{id}

- ```java
     {
       "paciente":{
           "id": 1,
           "nome":"Teste",
           "idade":2},
       "dataAtendimento":"2024-06-19T14:30:00",
       "observacoes":"Teste mudança"
     }
  
- `DELETE /atendimentos/{id}` - Remover um atendimento médico

  ```java
   http://localhost:8080/atendimentos/{id}
  
### Recomendação Médica
- `POST /recomendacoes` - Criar uma nova recomendação médica

   ```java
   {
       "atendimentoMedico":{
       "id": 1,
       "paciente": {
           "id": 1,
           "nome": "Teste",
           "sobrenome": "Sobrenome Teste",
           "idade": 1
       },
       "dataAtendimento": "2024-06-19T14:30:00",
       "observacoes": "Teste"
   },  
       "descricao":"Teste"
   }

- `GET /recomendacoes` - Listar todas as recomendações médicas

   ```java
   http://localhost:8080/recomendacoes-medicas
   
- `GET /recomendacoes/{id}` - Obter detalhes de uma recomendação médica

   ```java
   http://localhost:8080/recomendacoes-medicas/{id}
   
- `PUT /recomendacoes/{id}` - Atualizar uma recomendação médica existente

   ```java
   http://localhost:8080/recomendacoes-medicas/{id}

- ```java
     {
       "atendimentoMedico":{
       "id": 1,
       "paciente": {
           "id": 1,
           "nome": "Teste",
           "sobrenome": "Sobrenome Teste",
           "idade": 1
       },
       "dataAtendimento": "2024-06-19T14:30:00",
       "observacoes": "Teste"
   },  
       "descricao":"Teste 2"
   }
  
- `DELETE /recomendacoes/{id}` - Remover uma recomendação médica

   ```java
   http://localhost:8080/recomendacoes-medicas/{id}

### Ajuda
- `GET /ajuda` - Obter informações sobre os estudantes e o projeto

   ```java
   http://localhost:8080/ajuda

## Tratamento de Erros
A aplicação inclui um manipulador global de exceções para lidar com erros do cliente e retornar respostas apropriadas. Exceções personalizadas são utilizadas para fornecer mensagens de erro claras.
