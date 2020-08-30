package backend

import grails.gorm.transactions.Transactional


class StockService {

    def sessionFactory

    @Transactional(readOnly = true)
    def getStocks(String company, int numbersOfHoursUntilNow) {
        println "---------------------------------------------------------"
        println "Total time: xxxxxx ms." 
        println "total of quotes: XX"
        println "quotes: "
        println "    quote1 "
        println "    quote2 "
        println "    quote3 "
        println "---------------------------------------------------------"   
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
