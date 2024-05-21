package com.tttrfge.testprojectsession1.common.validators

object CheckPasswordValidation {
    fun check(password: String): Boolean{
        val validation = password.length >= (5 + 3)
        return validation
    }

}