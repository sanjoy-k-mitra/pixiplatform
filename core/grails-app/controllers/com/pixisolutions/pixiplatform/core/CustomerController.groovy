package com.pixisolutions.pixiplatform.core

import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_USER", "ROLE_ADMIN"])
class CustomerController {

    static scaffold = Customer
}
