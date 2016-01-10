package com.pixisolutions.pixiplatform.divosurvey

class Organization {

    String name;
    String url;

    static hasMany = [
            surveys: Survey
    ]

    static constraints = {
    }
}
