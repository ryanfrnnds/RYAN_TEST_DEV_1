package backend

import grails.databinding.BindingFormat
class Stock {
    @BindingFormat('dd/MM/yy HH:mm:ss')
    Date datePrice //Idela seria utilizar o LocalDateTime. Mas não fui atraz de adicionalo a LIB
    BigDecimal price
    static belongsTo = [company: Company]

    static constraints = {
        price(nullable: false, min: 0.01, scale: 2)
        // Não é necessário colocar nullable false para os atributos pois é o padrão utilizado pelo graisl.
        // Ignorando ideologias de négocio o atibuto datePrice ficara sem constraints explicitas.
    }
}
