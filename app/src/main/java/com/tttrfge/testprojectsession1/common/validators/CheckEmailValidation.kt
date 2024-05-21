package com.tttrfge.testprojectsession1.common.validators

import java.util.regex.Pattern

object CheckEmailValidation {
    fun check(email: String) : Boolean{
        return Pattern.matches("[a-z0-9\\+\\.\\_\\%\\-\\+]" +
                "{1,256}" +
                "\\@" +
                "[a-z0-9][a-z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-z0-9][a-z0-9\\-]{2,25}" +
                ")+", email)
    }
}