package racetrack

class Race {
    String name
    Date startDate
    String city
    String states
    BigDecimal distance
    BigDecimal cost
    Integer maxRunners

    BigDecimal inMiles(){
        return distance * 0.6214
    }

    static hasMany = [registrations:Registration]

    String toString(){
        return "${name}"
    }

    static constraints = {
        name(blank:false, maxSize:50)
        startDate(validator: {return (it > new Date())})
        city()
        states(inList:["Inverness-shire", "Argyllshire", "Perthshire", "Sutherland", "Ayrshire", "Aberdeenshire",
                       "Angus", "Caithness", "Orkney"])
        distance(min:0.0)
        cost(min:0.0, max:100.0)
        maxRunners(min: 0, max: 100000)
    }

    static mapping ={
    }
}
