package webapp

import grails.plugin.springsecurity.annotation.Secured

class ApplicationController {

    @Secured(['ROLE_USER', 'ROLE_ADMIN'])
    def index() {
        return [:]
    }
}
