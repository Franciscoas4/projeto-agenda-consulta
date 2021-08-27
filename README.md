# Agenda Consulta

Esse projeto consiste de uma API Rest onde é possível cadastrar médicos e agendar consultas de pacientes em uma data e hora solicitada.

## Tecnologias utilizadas

- Spring Boot: frameworks muito utilizada para criação de API´s Rest em Java e de fácil utilização devido a grande quantidade de recursos que a mesma trás.
- Maven: É uma ferramenta muito utilizada para realizar várias operações como build e install, e também para o gerenciamento de dependências.
- H2 Database: Nesse projeto, foi utilizado o banco de dados H2, que gera um banco em memoria e facilita o processo de persistência de dados para testar o funcionamento da aplicação.
- Lombok: Muito utilizado para a criação de códigos mais limpos, evitando os chamados códigos "boilerplates", melhorando a leitura dos códigos e agilizando o tempo do desenvolvedor.

## Execução do projeto.

Para execução do projeto, é necessário clonar ou baixar o zip contendo todos os arquivos.

## Executando o Backend

Para executar o backend, basta abrir o projeto na IDE de sua preferência e clicar em run, ou atravéz de um terminal, digitar o seguinte comando:
```
mvn spring-boot:run
```

## Utilizando a API

Para utilizar a API, basta utilizar o Postman, com os seguintes endpoints.

### Para Médicos

Deverá seguir os seguintes modelos:

Cadastrando um médico. Método ```POST``` - /medico

http://localhost:8080/medico

Utilizando o endereço acima, juntamente com o formato JSON informado a seguir, é possível cadastrar um médico no banco:

```JSON
{
  "nome": "João",
  "crm": "2222/DF",
  "idade": 41
}
```

Listando os médicos cadastrados. Método ```GET```

http://localhost:8080/medico

Listando os médicos por um id específico. Método ```GET``` - /medico/{medicoId}

http://localhost:8080/medico/1

### Para Consultas

Cadastrando uma consulta. Método ```POST``` - /consulta

http://localhost:8080/consulta

Utilizando o endereço acima, juntamente com o formato JSON informado a seguir, é possível cadastrar uma consulta no banco:

```JSON
{
  "nomePaciente": "Felipe",
  "especialidade": "Cirurgião",
  "dataConsulta": "26/08/2021 15:15",
  "consultorio": 22,
  "medico": {
    "medicoId": 1
  }
}
```

Listando as consultas cadastradas. Método ```GET```

http://localhost:8080/consulta

Listando as consultas por um id específico. Método ```GET``` - /consulta/{consultaId}

http://localhost:8080/consulta/1