package racetrack

import grails.testing.mixin.integration.Integration
import static org.junit.Assert.*;
import grails.transaction.*
import spock.lang.Specification

@Integration
@Rollback
class RaceIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void testRaceDatesBeforeToday() {
        def lastWeek = new Date() - 7
        def race = new Race(startDate:lastWeek)
        expect:
        assertFalse "Validation should not succeed",
                race.validate()
        // It should have errors after validation fails
        assertTrue "There should be errors",
                race.hasErrors()

        println "\nErrors:"
        println race.errors ?: "no errors found"

        def badField = race.errors.getFieldError('startDate')
        println "\nBadField:"
        println badField ?: "startDate wasn't a bad field"
        assertNotNull "Expecting to find an error on the startDate field",
                badField
        def code = badField?.codes.find {
            it == 'race.startDate.validator.invalid'
        }
        println "\nCode:"
        println code ?:
                "the custom validator for startDate wasn't found"
        assertNotNull "startDate field should be the culprit",
                code
    }
}
