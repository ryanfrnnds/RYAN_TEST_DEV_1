package backend

import grails.gorm.transactions.Transactional
class CompanyService {
    
    @Transactional(readOnly = true)
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

    @Transactional
    def save(Company company) {
        println "------------------SALVANDO------------------------------"
        company.save(flush: true, failOnError: true);
        println "-------------------TERMINADO------------------------------"
    }

     @Transactional(readOnly = true)
    def findBy(String name) {
        return Company.findByName(name);
    }
}
