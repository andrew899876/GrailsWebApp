package racetrack

class BootStrap {

    def init = { servletContext ->
        def andrew = new Runner(
                firstName: "Andrew",
                surname: "Stevenson",
                dateOfBirth: (new Date() - 364 * 24),
                gender: "Male",
                address: "163 Kincaidston Drive",
                city: "Ayr",
                county: "Ayrshire",
                postcode: "KA& 3YP",
                email: "andrew899876@gmail.com")

        andrew.save()
        if (andrew.hasErrors()) {
            println andrew.errors
        }

        def turkey = new Race(
                name: "Turkey Trot",
                startDate: (new Date() + 90),
                city: "Ayr",
                county: "Ayrshire",
                distance: 5.0,
                cost: 22.50,
                maxRunners: 350)
        turkey.save()
        if (turkey.hasErrors()) {
            println turkey.errors
        }

        def reg = new Registration(
                paid: false,
                runner: andrew,
                race: turkey)

        reg.save()
        if (reg.hasErrors()){
            println reg.errors
        }
    }
    def destroy = {
    }
}
