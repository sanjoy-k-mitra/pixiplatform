import com.pixisolutions.pixiplatform.billing.BillingTask

// Place your Spring DSL code here
beans = {

    billingTask(BillingTask){

    }

    xmlns task: "http://www.springframework.org/schema/task"

    task.'scheduled-tasks'{
        task.scheduled(ref:'billingService', method: 'performBilling', cron: '0 0-59 * * * *')
    }
}
