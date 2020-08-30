package backend

import grails.gorm.transactions.Transactional

import groovy.time.TimeCategory


class StockService {

    def sessionFactory

    @Transactional(readOnly = true)
    def getStocks(String companyName, int numbersOfHoursUntilNow) {
        long initProcessMS = new Date().getTime();
         if (numbersOfHoursUntilNow < 1) {
             /* Essa validação, partindo do pre suposte de que é uma api-rest, poderia 
                ser feita com beanValidator. que age antes mesmo de bater no CONTROLLER.
            */
            throw new Exception("Number of hours until now must be greater than zero")
        }

        if (numbersOfHoursUntilNow > 720) {
            /* limite de horas em 30 dias... Não faz sentido por mais horas do quê isso já que no 
            banco não tem isso. Por falta de requisito estou 'inventando'. Mas esse parâmetro influencia
            fortemente no custo da consulta e na lógica que poderia ser implementado.
            CONSIDERAÇÕES feitas no README -> Setor Análise item B.
            */
            throw new Exception("Number of hours exceeds number of quotas. Use a lower value")
        }
        Date lastDateCreated;
        Date dateWithNumbersOfHoursUntilNow;
         use (TimeCategory) {
            lastDateCreated = Stock.listOrderByDatePrice(max: 1, order: "desc")[0].datePrice+0.hours 
            dateWithNumbersOfHoursUntilNow= lastDateCreated-numbersOfHoursUntilNow.hours
        } 
        def stocks = Stock.createCriteria().list{
                company{
                    eq('name', companyName.toLowerCase(), [ignoreCase: true])
                }
                and {
                    between('datePrice', dateWithNumbersOfHoursUntilNow,lastDateCreated ) 
                }
                order('datePrice', 'desc')
            }
            println "-------------------------"+companyName.toUpperCase()+"-------------------------------"
            println "Total time: "+ ((new Date().getTime()) - initProcessMS)+" ms."
            println "total of quotes: " + stocks.size()
            println "quotes: "
            stocks.each {stock ->
                println  stock.datePrice.format("dd/MM/yyyy HH:mm:ss") + " - "+ stock.price   
            }
        // CONSIDERAÇÕES feitas no README -> Setor Análise item B.  
    }


    @Transactional
    def save(Stock[] stocks) {
        int positionArray = 0;
        def aindaPossuirStock = true
        def session = sessionFactory.openSession();
        def tx = session.beginTransaction();
        int count = 0

        stocks.each {stock ->
            session.save(stock) 

            if (count == 500) {
                count = 0
                session.flush();
                session.clear();
            }
        }
        tx.commit();
        session.close(); 
    }

}
