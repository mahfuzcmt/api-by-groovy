package com.bitsoft.amr.user

import com.bitsoft.amr.UserService
import grails.converters.JSON
import grails.rest.Resource
import grails.rest.RestfulController

class UserController {

    UserService userService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", list: "GET"]
   def test(){
       render([message: "Tested"] as JSON)
   }

    def save() {
        Map params = request.JSON
        if(userService.isUserExists(params.email)){
            render([message: "Email already exits!"])
        } else {
            if(userService.saveUser(params)){
                render([message: "Saved"] as JSON)
            } else {
                render([message: "Sorry, failed to save user!"] as JSON)
            }
        }
    }

    def delete() {
        render([message: "deleted"] as JSON)
    }

    def update() {
        render([message: "updated"] as JSON)
    }

    def list() {
        def users = userService.loadUsers()
        render([data: users] as JSON)
    }
    def index() {
        render([message: "index"] as JSON)
    }
}