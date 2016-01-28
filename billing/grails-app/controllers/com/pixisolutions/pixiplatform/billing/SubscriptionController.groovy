package com.pixisolutions.pixiplatform.billing

import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_USER", "ROLE_ADMIN"])
class SubscriptionController {

    static scaffold = Subscription;
}
