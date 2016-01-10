package com.pixisolutions.pixiplatform.divosurvey

class Survey {

    String name;
    String description;
    Organization organization;
    Date created;
    Date updated;

    static hasMany = [
            sections: Section
    ]

    static constraints = {
    }
}
