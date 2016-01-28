package com.pixisolutions.pixiplatform.core

class Customer {

    String name;
    String email;
    String address;

    static constraints = {
    }

    static mapping = {
        address type: 'text'
    }

    String toString(){
        return name?:super.toString()
    }
}
