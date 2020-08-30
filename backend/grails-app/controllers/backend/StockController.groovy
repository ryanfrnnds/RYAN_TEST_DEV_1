package backend

class StockController {
    StockService stockService

    def index() { 
        stockService.getStocks('railroad', 1)
        stockService.getStocks('carriers', 2)
        stockService.getStocks('navigation', 3)
        render status: 200, text: 'OK'
    }

    def companies() {
        def companies = []
        companies.add(stockService.getStandardDeviation('railroad'))
        companies.add(stockService.getStandardDeviation('carriers'))
        companies.add(stockService.getStandardDeviation('navigation'))
        respond companies , formats: ['json']
    }
}
