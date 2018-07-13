package racetrack

import static org.junit.Assert.*;
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import grails.test.*

class RaceSpec extends Specification implements DomainUnitTest<Race> {

    def setup() {
    }

    def cleanup() {
    }

    void inMilesTest() {
        def race = new Race(distance:5.0)
        expect:
        assertEquals 3.10700, race.inMiles()
    }
}

