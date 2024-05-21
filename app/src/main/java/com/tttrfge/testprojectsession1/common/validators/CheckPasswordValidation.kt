package com.tttrfge.testprojectsession1.common.validators

object CheckPasswordValidation {
    fun check(password: String): Boolean{
        return password.length == 7
    }
}