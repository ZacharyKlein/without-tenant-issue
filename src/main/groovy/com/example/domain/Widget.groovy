package com.example.domain

import grails.gorm.MultiTenant
import grails.gorm.annotation.Entity

@Entity
class Widget implements MultiTenant<Widget> {

    Long id
    Long version

    String name
    String company
    String uuid

    static mapping = {
        tenantId name: "company"
    }

    static constraints = {
        name nullable: false
        company blank: false
        uuid unique: true
    }
}
