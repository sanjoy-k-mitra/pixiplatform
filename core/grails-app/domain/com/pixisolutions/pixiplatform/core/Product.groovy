package com.pixisolutions.pixiplatform.core

class Product {
    String name;
    String code = UUID.randomUUID();
    Double price;
    static constraints = {
    }

    String toString(){
        return name?:super.toString()
    }
}
