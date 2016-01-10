package com.pixisolutions.pixiplatform.divosurvey

class Section {
    String name;
    String description;

    Boolean isRequired;

    String created;
    String updated;

    static hasMany = [questions: Question]

    static constraints = {
    }
}
