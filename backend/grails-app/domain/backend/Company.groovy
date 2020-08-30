package backend

class Company {

    String name 
    String segment

    static constraints = {
        name blank: false, unique: true
        segment blank: false
    }
}


