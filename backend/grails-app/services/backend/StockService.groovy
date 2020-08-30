package backend

import grails.gorm.transactions.Transactional


class StockService {

    def sessionFactory

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
