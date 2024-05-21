package com.tttrfge.testprojectsession1.common.validators

import org.junit.Assert.*

import org.junit.Test

class CheckPasswordValidationTest {

    @Test
    fun test_wit_correctPassword_must_return_true() {
        var password = "12345678"
        var actual = CheckPasswordValidation.check(password)
        assert(actual)
    }

    @Test
    fun test_wit_incorrectPassword_must_return_false() {
        var password = "1234567"
        var actual = CheckPasswordValidation.check(password)
        assert(!actual)
    }
}