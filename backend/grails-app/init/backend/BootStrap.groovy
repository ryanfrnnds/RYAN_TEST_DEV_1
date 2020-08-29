package backend

import groovy.time.TimeCategory

class BootStrap {
    
    def companys = []
    def init = { servletContext ->
        Company railroad = BootStrap.createCompany("railroad","land vehicles")
        Company carriers = BootStrap.createCompany("carriers","land vehicles")
        Company navigation = BootStrap.createCompany("navigation","floating vehicles")

        companys.push(railroad)
        companys.push(carriers)
        companys.push(navigation)
    }
    def destroy = {}

    public static Company createCompany(String name, String segment) {
        Company company = new Company();
        company.name = name;
        company.segment = segment
        company.stocks = BootStrap.createStockQuotes()

        return company;
    }

    public static Stock[] createStockQuotes() {
        def stocks = [];
        Date today = new Date()
        today.set(hourOfDay: 18, minute: 0, second: 0)
        Date last30Days = today.plus(-29)
        Date init = last30Days;
        BootStrap.setFirstHours(init)
        boolean isDayChange = false;

        while (init < today) {
            def isBreakTime = init.getHours() == 12
            if(isBreakTime) {
                init.set(hourOfDay: 13, minute: 0, second: 0)
            }
            use (TimeCategory) {
                if (isDayChange) {
                    BootStrap.setFirstHours(init)
                    init = init+1.day
                    isDayChange = false
                }
                if(init < today) {
                    Stock stock = new Stock()
                    stock.price = new Price()
                    stock.price.date = init;
                    BigDecimal random = BootStrap.generateRandomBigDecimalFromRange(
                        new BigDecimal(0.01).setScale(2, BigDecimal.ROUND_HALF_UP),
                        new BigDecimal(500.00).setScale(2, BigDecimal.ROUND_HALF_UP)
                    );
                    stock.price.value = random
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

    public static void setFirstHours(Date date) {
        date.set(hourOfDay: 10, minute: 0, second: 0);
    }

    public static BigDecimal generateRandomBigDecimalFromRange(BigDecimal min, BigDecimal max) {
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
    }
}
