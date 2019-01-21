package com.example.services

import com.example.domain.Widget
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.multitenancy.WithoutTenant
import grails.gorm.services.Service

@Service(Widget)
abstract class WidgetService {

    @CurrentTenant
    abstract Widget find(Serializable id)

    @CurrentTenant
    abstract List<Widget> findAll()

    @WithoutTenant
    abstract Widget findByUuid(String uuid)


}
