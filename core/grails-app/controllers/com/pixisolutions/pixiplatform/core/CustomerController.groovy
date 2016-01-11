package com.pixisolutions.pixiplatform.core

import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_USER"])
class CustomerController {

    static scaffold = Customer
}
