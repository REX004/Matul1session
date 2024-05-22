package com.tttrfge.testprojectsession1.data.repository

import com.tttrfge.testprojectsession1.common.ResponseState
import com.tttrfge.testprojectsession1.domain.repository.UserRepository

interface TestUserRepository {
    suspend fun signIn(email:String, password : String) : ResponseState<Unit>
}

class TestUserImpl : UserRepository{
    override suspend fun signIn(email: String, password: String): ResponseState<Unit> {
        try {

        }
    }

}