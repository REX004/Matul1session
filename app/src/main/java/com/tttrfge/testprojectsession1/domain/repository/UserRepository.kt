package com.tttrfge.testprojectsession1.domain.repository

import com.tttrfge.testprojectsession1.common.ResponseState

interface UserRepository {

    suspend fun signIn(email: String, password: String): ResponseState<Unit>
}