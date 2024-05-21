package com.tttrfge.testprojectsession1.common.validators

import org.junit.Assert.*

import org.junit.Test

class CheckEmailValidationTest {

    @Test
    fun test_with_correctEmail_must_return_true() {
        var email = "aslkdalkjsfd@mail.com"
        var actual = CheckEmailValidation.check(email)
        assert(actual)
    }

    @Test
    fun test_with_incorrectEmail_must_return_false() {
        var email = "aslkdalkjsfd@mail.r8"
        var actual = CheckEmailValidation.check(email)
        assert(!actual)
    }
}