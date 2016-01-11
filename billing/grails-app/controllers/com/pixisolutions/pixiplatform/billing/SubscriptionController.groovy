package com.pixisolutions.pixiplatform.billing

import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_USER"])
class SubscriptionController {

    static scaffold = Subscription;
}
