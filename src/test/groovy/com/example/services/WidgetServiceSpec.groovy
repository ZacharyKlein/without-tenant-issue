package com.example.services

import grails.gorm.multitenancy.Tenants
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest(packages = ["com.example.domain"])
class WidgetServiceSpec extends Specification {

    @Inject WidgetService widgetService

    void "test multitenant"() {
        expect:
        Tenants.withId("acme-inc") {
            widgetService.find(1)
        }

        and:
        Tenants.withId("acme-inc") {
            widgetService.findAll()
        }
    }

    void "test without tenant"() {
        expect:
        widgetService.findByUuid("000")
    }

}
