package com.pixisolutions.pixiplatform.billing

import com.pixisolutions.pixiplatform.core.PixiTask

/**
 * Created by sanjoy on 1/11/16.
 */
class BillingTask implements PixiTask{

    @Override
    void executeTask() {
        println "Billling Performed " + new Date().toString()
    }
}
