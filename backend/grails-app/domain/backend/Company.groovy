package backend

class Company {

    String name 
    String segment
    static hasMany = [stocks: Stock]

    static constraints = {
        name size:  blank: false, unique: true
        segment size: blank: false
    }
}


