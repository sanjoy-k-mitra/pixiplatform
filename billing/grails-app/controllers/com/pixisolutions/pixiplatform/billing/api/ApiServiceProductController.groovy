package com.pixisolutions.pixiplatform.billing.api

import com.pixisolutions.pixiplatform.billing.ServiceProduct
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController
import org.springframework.web.bind.annotation.RequestMapping

@Secured(["ROLE_USER"])
class ApiServiceProductController extends RestfulController{

    static responseFormats = ['html', 'json']

    public ApiServiceProductController(){
        super(ServiceProduct)
    }
}
