package com.pixisolutions.pixiplatform.billing

import grails.plugin.springsecurity.annotation.Secured;

@Secured(["ROLE_USER"])
class ServiceProductController {

    static scaffold = ServiceProduct;
}
