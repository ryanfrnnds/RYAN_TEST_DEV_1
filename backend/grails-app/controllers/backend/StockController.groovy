package backend

class StockController {
    static responseFormats = ['json']

    StockService stockService

    def index() { 
        stockService.getStocks('railroad', 1)
        stockService.getStocks('carriers', 2)
        stockService.getStocks('navigation', 3)
        render(status: 200, text: 'Verificar qual retorno será necessário para implementação do teste')
    }
}
