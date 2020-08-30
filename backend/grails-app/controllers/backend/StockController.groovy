package backend

class StockController {
    static responseFormats = ['json']

    StockService stockService

    def index() { 
        stockService.getStocks('RAILROAD', 5)
        render(status: 200, text: 'Verificar qual retorno será necessário para implementação do teste')
    }
}
