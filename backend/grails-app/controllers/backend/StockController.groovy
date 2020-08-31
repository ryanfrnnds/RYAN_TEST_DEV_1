package backend

class StockController {
    StockService stockService

    def index() { 
        stockService.getStocks('railroad', 1)
        stockService.getStocks('carriers', 2)
        stockService.getStocks('navigation', 3)
        render status: 200, text: 'Logica da TASK 2 printada no CONSOLE do BACK'
    }
}
