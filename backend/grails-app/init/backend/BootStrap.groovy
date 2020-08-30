package backend

import groovy.time.TimeCategory

class BootStrap {
    
    StockService stockService
    
    def init = { servletContext ->
    /* Este formato de inserção por create-drop torna bem lento o desenvolvimento.
     Preferiria ter feito de alguma outra forma. Por exemplo com dataSet ja definido para um ambiente
     de teste. Uma instancia de um BANCO com os dados já existentes... Apesar de eu tentar melhora no insert com BATCH
     */
        Company railroad = BootStrap.createCompany("railroad".toUpperCase(),"land vehicles".toUpperCase())
        Stock[] stocksRailroad = BootStrap.createStockQuotes(railroad)
        stockService.save(stocksRailroad)
        
        Company carriers = BootStrap.createCompany("carriers".toUpperCase(),"land vehicles".toUpperCase())
        Stock[] stocksCarriers = BootStrap.createStockQuotes(carriers)
        stockService.save(stocksCarriers)
        Company navigation = BootStrap.createCompany("navigation".toUpperCase(),"floating vehicles".toUpperCase())
        Stock[] stocksNavigation= BootStrap.createStockQuotes(navigation)
        stockService.save(stocksNavigation)
    }
    def destroy = {}

    private static Company createCompany(String name, String segment) {
        Company company = new Company();
        company.name = name;
        company.segment = segment
        BootStrap.createStockQuotes(company)
        return company
    }

    private static Stock[] createStockQuotes(Company company ) {
        def stocks = [];
        Date today = new Date()
        today.set(hourOfDay: 18, minute: 0, second: 0)
        Date last30Days = today.plus(-29)
        Date init = last30Days;
        BootStrap.setFirstHours(init)
        boolean isDayChange = false;

        while (init < today) {
            use (TimeCategory) {
                if (isDayChange) {
                    BootStrap.setFirstHours(init)
                    init = init+1.day
                    isDayChange = false
                }
                if(init < today) {
                    Stock stock = new Stock()
                    stock.datePrice = init;
                    BigDecimal random = BootStrap.generateRandomBigDecimalFromRange(
                        new BigDecimal(0.01).setScale(2, BigDecimal.ROUND_HALF_UP),
                        new BigDecimal(500.00).setScale(2, BigDecimal.ROUND_HALF_UP)
                    );
                    stock.price = random
                    stock.company = company
                    stocks.push(stock)

                    def hours = init.getHours();
                    init = init+1.minute
                    def hoursChange = hours != init.getHours()
                    
                    def isLastMinute = init.getHours() == 18
                    if(isLastMinute) {
                        isDayChange = true
                    } 
                }
            }
        }

        return stocks;
    }

    private static void setFirstHours(Date date) {
        date.set(hourOfDay: 10, minute: 0, second: 0);
    }

    private static BigDecimal generateRandomBigDecimalFromRange(BigDecimal min, BigDecimal max) {
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
    }
}
