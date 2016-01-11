package com.pixisolutions.pixiplatform.billing

import com.pixisolutions.pixiplatform.core.Customer;

class Subscription {

    Customer customer;
    ServiceProduct serviceProduct;

    Date created;
    Date modified;

    Date lastBilled;

    static constraints = {
        lastBilled nullable: true
    }
}
