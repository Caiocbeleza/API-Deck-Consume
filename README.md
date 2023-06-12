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


5. Voltar ao eclipse e rodar DeckApplication.java como Java Application.

6. Com a aplicação rodando, para utilizar as funções, acessar http://localhost:8080/index.html

7. Para começar, você pode criar um novo baralho no botão "novo baralho", ou inserir um "id" de um baralho já existente. Se escolher criar um novo baralho, o "id" desse novo baralho criado aparecerá na tela, para que possa ser utilizado.

8. Para saber qual o jogador vencedor, é preciso informar o "id" de um baralho no campo "Deck ID", e clicar no botão "Jogar". Depois de apertado o botão, aparecerá, na tela, o resultado do jogo. Se Um jogador só tiver a maior soma de cartas na mão, aprecerá como vencedor, da rodada. Caso, dois ou mais jogadores empatarem, será mostrado na tela as mãos de todos os jogadores e as somas dos valores das cartas de suas respectivas mãos.

9. Sempre, após apertar o botão "Jogar", é preciso embaralhar o baralho novamente, para que as cartas não acabem, informando um "Deck ID" válido.

10. Se preferir não utilizar a interface web, os seguintes são os endereços das funções da aplicação:
```
 10.1 Com a aplicação rodando, para criar um novo baralho e salvar seu id no seu database, acessar: http://localhost:8080/create

10.2 Para embaralhar o baralho, acessar: http://localhost:8080/shuffle (Baralhar o baralho sempre que jogar uma vez, para não acabarem as cartas.)

10.3 Para mostrar a mão vencedora(com a soma maior de cartas), acessar: http://localhost:8080/calculates
```
11. Para rodar os testes unitários:
```
src/test/java -> DeckApplicationTests.Java -> Run As -> JUnit Test

```