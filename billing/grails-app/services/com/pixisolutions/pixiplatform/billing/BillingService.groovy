package com.pixisolutions.pixiplatform.billing

import grails.transaction.Transactional
import groovy.json.internal.Byt
import org.joda.time.Days
import org.joda.time.DateTime
import org.springframework.web.servlet.view.AbstractTemplateViewResolver

import java.text.SimpleDateFormat


@Transactional
class BillingService {
    def mailService;
    def groovyPageRenderer;
    def pdfRenderingService

    def performBilling() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Subscription.list().each {subscription ->
            if(!subscription.lastBilled || Days.daysBetween(new DateTime(), new DateTime(subscription.lastBilled)).getDays() > subscription.serviceProduct.billingCycle){
                println "Sending Bill"
                try {
                    def content = groovyPageRenderer.render(view: "/emails/billing", model: [customer: subscription.customer, product: subscription.serviceProduct]);
                    ByteArrayOutputStream byteArrayOutputStream = pdfRenderingService.render(template: '/emails/memo', model: [product: subscription.serviceProduct]);

                    String name = subscription.serviceProduct.name + " Bill " + simpleDateFormat.format(new Date());
                    mailService.sendMail {
                        multipart true
                        from "sanjoy@pixigame.com"
                        to subscription.customer.email
                        subject name
                        html content
                        attach(name + ".pdf", "application/pdf", byteArrayOutputStream.toByteArray() )
                    }
                    subscription.lastBilled = new Date()
                    subscription.save()
                    println "Mail Sent"
                }catch (Exception err){
                    err.printStackTrace()
                }
            }
        }
    }
}
