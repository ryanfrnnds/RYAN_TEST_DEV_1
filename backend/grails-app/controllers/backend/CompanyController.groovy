package backend

class CompanyController {
// Convenção por configuração. MAGIA. Injeção de dependencia feita!
    CompanyService companyService

    def index() { 
        companyService.getStocks("railroad", 1)
        render(status: 200, text: 'Procurando entender o funcionamento da ferramenta...')
        /*
        companyService.getStocks("carriers", 2)
        companyService.getStocks("navigation", 3)
        */
    }
}
