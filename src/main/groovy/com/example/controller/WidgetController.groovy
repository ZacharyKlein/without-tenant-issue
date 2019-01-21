package com.example.controller

import com.example.domain.Widget
import com.example.services.WidgetService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import javax.inject.Inject

@Controller("/widget")
class WidgetController {

    @Inject WidgetService widgetService

    @Get("/")
    HttpResponse<List<Widget>> list() {
        HttpResponse.ok(widgetService.findAll())
    }

    @Get("/{id}")
    HttpResponse<Widget> show(Serializable id) {
        HttpResponse.ok(widgetService.find(id))
    }


    @Get("/uuid/{uiid}")
    HttpResponse<Widget> byUuid(String uiid) {
        HttpResponse.ok(widgetService.findByUuid(uiid))
    }
}
