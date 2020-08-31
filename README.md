# CONSIDERAÇÕES 
### Teste FRONT-END
- A) Não tenho nenhuma experiência com testes em FRONT-END. Já fiz algumas poucas coisas em Angular mas nada com end-to-end. Achei o Cypress interessante e 'simples'.

### Análise
- A)  Falta de definição de negócio. Os objeto não definem o que é ou não obrigatório. Dessa maneira
dificultando o pensamento de como modelar as entidade e o banco. 
- B) O método `getStocks(company, numbersOfHoursUntilNow)` também não define nenhuma estrutura de negócio. Isso afeta diretamente em como desenvolver o método. 
Supondo que `numbersOfHoursUntilNow` tenha definição de LIMITE eu poderia escrever aqui uma lógica com uma única chamadas ao banco (`Melhorar a performace`). Já se ele não possuir limites pode ser necessário uma complexidade em `LOT` (Paginado). Isso afeta diretamente o tempo de execução do método. Devido a falta de informação eu, normalmente, conversária com a área para entender a necessidade e tomar a melhor decisão. Mas irei implementar da maneira que eu vou achar mais `aceitavel` em prol da performance sem um limitador. 
    Porém se eu pensa-se em serialização de objeto para o `Front`, não seria muito bom um objeto com uma lista (`Stocks por minuto`) grande. Dependendo do tamanho serializado para FRONT poderia também nem ser viável. Mesmo funcionando em BACK-END.
- C) O click no botão GET COMPANIES do FRONT não está implementado lógica alguma. Desta forma deixando possível `Infinitos` clicks no botão. Isso pode causar problemas de requisições ou até mesmo derrubar o banco dependo do que esse click está requisitando. A boa prática diz que é melhor colocar algum tipo de bloqueio como um `loading` por exemplo ou outras soluções.
### Angular
- Seria interessante adicionar nessa avaliação o uso do NPX para utilizar versões instaladas no NODE por projeto e não globais.
Por exemplo o projeto dessa avaliação utiliza o angular 8 e muitas pessoas podem instalar o angular de forma global o que afetaria a instrução do `ng serve`
```sh
$ npm i -g @angular/cli
``` 
- Com o `npx ng serve` O usu seria do angular instalado no `NPM i` do projeto independente da versão global instalada. não afetando a intrução do `ng serve`

### GroovyOnGrails
- Me parece que o projeto do GRAILS foi criado da forma padrão: `grails create-app myApp`. Mas como ele serve como um `rest-api` existem os profiles do scafold do grails.
 O projeto poderia ter sido criado com essa estrutura `grails create-app myApp -profile rest-api`.
- O link utilizado na `TASK 2 - Then, Bootstrap (see 5.4 section) your application with some fake data containing:'` pode acabar atrapalhando.
  Pois lá é feita uma referência na `seção 5.2` localhost:8080/`DBConsole`. Porém o SpringBoot já utiliza o H2 e o GRAILS retirou a sua própria integração. 
-  O link agora é localhost:8080/`h2-console`

