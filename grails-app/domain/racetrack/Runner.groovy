package racetrack

class Runner {
    String firstName
    String surname
    Date dateOfBirth
    String gender
    String address
    String city
    String county
    String postcode
    String email

    static hasMany = [registration:Registration]

    static constraints = {
        firstName(blank:false, nullable:false, maxSize:50)
        surname(blank:false, nullable:false, maxSize:70)
        dateOfBirth()
        gender(inList:['Male', 'Female', 'Other'])
        address()
        city()
        county()
        postcode()
        email(email:true)
    }

    String toString(){
        "${surname}, ${firstName} (${email})"
    }
}
