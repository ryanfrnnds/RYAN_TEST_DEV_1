# CONSIDERAÇÕES - Ryan Fernandes

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

