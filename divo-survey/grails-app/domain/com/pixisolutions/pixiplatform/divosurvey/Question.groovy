package com.pixisolutions.pixiplatform.divosurvey

class Question {

    Section section;
    String questionText;

    Boolean isRequired;
    Boolean isAnswerRequired;
    Boolean allowMultipleAnswer;

    Question dependentQuestion;
    Integer dependentType;
    String depentArguments;

    static hasMany = [
            options: Option,
            answers: Answer
    ]

    static constraints = {
    }
}
