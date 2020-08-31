package backend

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CompanyController {
    // Não seria o ideal um controller de Company se comunicar com o StockService...
    StockService stockService

     def index() { 
        render status: 200, text: 'Logica da TASK 3 implementada no endpoint Company/standartDeviations'
    }

     def standartDeviations() {
        def companies = []
        companies.add(stockService.getStandardDeviation('railroad'))
        companies.add(stockService.getStandardDeviation('carriers'))
        companies.add(stockService.getStandardDeviation('navigation'))
        respond companies , formats: ['json']
    }

}
