package backend

import grails.gorm.transactions.Transactional
// Anotação deve ser utilizada quando conter transação em BANCO. Como estou fazendo em memória não seria necessária.
// Tentei utilizar o H2 como referencia a seção 5.4 do link: https://guides.grails.org/creating-your-first-grails-app/guide/index.html 
// Mas não conseguir fazer o uso do H2. Precisaria de tempo para entender e lê sobre as magias do GORM para entender melhor o fluxo de convenção sobre configuração.
@Transactional
class CompanyService {

    def getStocks(company, numbersOfHoursUntilNow) {
        println "---------------------------------------------------------"
        println company + " "+ numbersOfHoursUntilNow
        println "Utilizar o GORM para implementacao dos itens inseridos da classe 'Company'." 
        println "Criar os relacionamentos com anotação do Hibernate e tentar fazer o grails salvar em memoria com a lib do H2"
        println "---------------------------------------------------------"
        /*
        BootStrap.companys.each { companyBD ->
            println companyBD.name
        }
        */
    }
}
