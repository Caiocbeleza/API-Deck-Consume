# desafio-tecnico

## Instruções para Rodar a aplicação 
1. Clonar o repositório
```
git clone https://github.com/Caiocbeleza/desafio-tecnico.git
```

2. Abrir em um editor/IDE de sua preferência. Usei o Eclipse, então vou mostrar por ele.
```
File -> Import -> Maven -> Existing Maven Projects -> procurar a pasta do projeto -> Finish.

```

3. Criar um database PostgresSQL. Nesse database criar uma tabela "decks", com os campos "id"(bigint) e "deck_id"(varchar).

4. Configurar o src/main/resources/application.propperties de acordo com as informações do seu database criado.
```
spring.datasource.url=jdbc:postgresql://localhost:5432/<nome_database>
spring.datasource.username=<username_postgres>
spring.datasource.password=<senha_postgres>
```


5. Voltar ao eclipse e rodar DeckApplication.java como projeto java.

6. Com a aplicação rodando, acessar http://localhost:8080/calculates.