package com.example

import com.example.domain.Widget
import grails.gorm.multitenancy.Tenants
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic
import io.micronaut.runtime.server.event.ServerStartupEvent

import javax.inject.Singleton

@Singleton
@CompileStatic
class Application implements ApplicationEventListener<ServerStartupEvent> {
    static void main(String[] args) {
        Micronaut.run(Application)
    }

    @Override
    void onApplicationEvent(ServerStartupEvent event) {

        Tenants.withId("acme-inc") {
            Widget.withNewSession {
                new Widget(name: "Widget A", uuid: "000").save()
                new Widget(name: "Widget B", uuid: "001").save()
                new Widget(name: "Widget C", uuid: "002").save()
            }
        }

        Tenants.withId("acme-llc") {
            Widget.withNewSession {
                new Widget(name: "Widget A", uuid: "003").save()
                new Widget(name: "Widget B", uuid: "004").save()
                new Widget(name: "Widget C", uuid: "005").save()
            }
        }

    }
}