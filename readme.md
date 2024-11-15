# RafaelLeiteFernandes

Projeto da disciplina Arquitetura Java [24E4_2]

## Versão do Java

Este projeto utiliza a versão 17 do Java.

## Dependências

- Spring Boot Starter Web
- Spring Boot Starter Test
- Hibernate Core
- Hibernate EntityManager
- Spring Boot Starter Data JPA
- H2 Database
- JSTL
- Tomcat Embed Jasper
- Spring Boot Starter Validation

## Rotas Disponíveis

### ComponenteController

- **GET /componentes/filtrarPorPreco/{min}/{max}**: Obtém uma lista de componentes filtrados pelo preço entre `min` e `max`.
- **GET /componentes/filtrarPorNome/{nome}**: Obtém uma lista de componentes filtrados pelo nome.
- **GET /componentes/filtrarPorFornecedor/{fornecedor}**: Obtém uma lista de componentes filtrados pelo fornecedor.
- **GET /componentes/filtrarPorDataFabricacao/{dataFabricacao}**: Obtém uma lista de componentes filtrados pela data de fabricação.

### ComponenteEletronicoController

- **GET /componentes/eletronicos/{id}**: Obtém um componente eletrônico pelo ID.
- **GET /componentes/eletronicos**: Obtém uma lista de todos os componentes eletrônicos.
- **POST /componentes/eletronicos**: Adiciona um novo componente eletrônico.
- **PUT /componentes/eletronicos/{id}**: Atualiza um componente eletrônico pelo ID.
- **DELETE /componentes/eletronicos/{id}**: Exclui um componente eletrônico pelo ID.

### ComponenteMecanicoController

- **GET /componentes/mecanicos/{id}**: Obtém um componente mecânico pelo ID.
- **GET /componentes/mecanicos**: Obtém uma lista de todos os componentes mecânicos.
- **POST /componentes/mecanicos**: Adiciona um novo componente mecânico.
- **PUT /componentes/mecanicos/{id}**: Atualiza um componente mecânico pelo ID.
- **DELETE /componentes/mecanicos/{id}**: Exclui um componente mecânico pelo ID.

### LinhaProducaoController

- **GET /linha/lista/LinhaProducao**: Obtém uma lista de todas as linhas de produção.
- **GET /linha/identificadores/buscar/{identificador}**: Obtém uma lista de linhas de produção filtradas pelo identificador.
- **GET /linha/status/buscar/{status}**: Obtém uma lista de linhas de produção filtradas pelo status.
- **POST /linha/incluir**: Adiciona uma nova linha de produção.
- **PUT /linha/atualizar/{id}**: Atualiza uma linha de produção pelo ID.
- **DELETE /linha/excluir/{id}**: Exclui uma linha de produção pelo ID.

### SupervisorController

- **GET /supervisores/filtrarPorNome/{nome}**: Obtém uma lista de supervisores filtrados pelo nome.
- **GET /supervisores/all**: Obtém uma lista de todos os supervisores.
- **GET /supervisores/filtrarPorExperiencia/{experiencia}**: Obtém uma lista de supervisores filtrados pela experiência.
- **GET /supervisores/filtrarPorCertificacao/{certificacao}**: Obtém uma lista de supervisores filtrados pela certificação.
- **POST /supervisores/incluir**: Adiciona um novo supervisor.
- **PUT /supervisores/atualizar/{id}**: Atualiza um supervisor pelo ID.
- **DELETE /supervisores/excluir/{id}**: Exclui um supervisor pelo ID.

## Validações

### Supervisor

- **nome**: Não pode estar em branco, deve ter entre 2 e 100 caracteres.
- **experiencia**: Deve ser maior ou igual a zero.
- **certificacao**: Não pode estar em branco.
- **idade**: Deve ser maior ou igual a 18.

### LinhaProducao

- **identificador**: Não pode estar em branco, deve ter entre 2 e 100 caracteres.
- **supervisor**: Não pode ser nulo.
- **status**: Não pode estar em branco.
- **dataInicio**: Deve ser no passado ou presente.
- **dataFimPrevisto**: Não pode ser nula.
- **custoOperacional**: Deve ser maior ou igual a zero.

### ComponenteEletronico

- **potencia**: Deve ser maior ou igual a zero.
- **tipoCircuito**: Não pode estar em branco.
- **voltagem**: Deve ser maior ou igual a zero.
- **frequencia**: Deve ser maior ou igual a zero.

### ComponenteMecanico

- **material**: Não pode estar em branco.
- **peso**: Deve ser maior ou igual a zero.
- **resistencia**: Deve ser maior ou igual a zero.
- **processoFabricacao**: Não pode estar em branco.

## Exceções

### GlobalExceptionHandler

- **MethodArgumentNotValidException**: Trata exceções de validação de argumentos de método.
- **ConstraintViolationException**: Trata exceções de violação de restrições.