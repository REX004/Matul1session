package com.tttrfge.testprojectsession1.data.repository

import com.tttrfge.testprojectsession1.common.ResponseState
import com.tttrfge.testprojectsession1.common.SupabaseService
import com.tttrfge.testprojectsession1.common.validators.CheckEmailValidation
import com.tttrfge.testprojectsession1.common.validators.CheckPasswordValidation
import com.tttrfge.testprojectsession1.domain.repository.UserRepository
import io.github.jan.supabase.exceptions.HttpRequestException
import io.github.jan.supabase.exceptions.RestException
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.ktor.client.plugins.HttpRequestTimeoutException

class UserRepositoryImpl: UserRepository {
    override suspend fun signIn(email: String, password: String): ResponseState<Unit> {
            try {
                if(CheckEmailValidation.check(email)) {
                    if (CheckPasswordValidation.check(password)) {

                        var result = SupabaseService.supabase.auth.signInWith(Email) {
                            this.email = email
                            this.password = password
                        }
                        return ResponseState.Success(Unit)
                    } else {
                        throw InvalidPasswordException()
                    }
                } else {
                    throw EmailException()
                }

            }
            catch (e: RestException) {
                return ResponseState.Error("Неправильный Email или пароль")
            }
            catch (e: HttpRequestTimeoutException) {
                return ResponseState.Error("Время ожидания истекло")

            } catch (e: HttpRequestException) {
                return ResponseState.Error("Проверьте соединение с интернетом")
            } catch (e: EmailException) {
                return ResponseState.Error("Невалидная почта")
            } catch (e: InvalidPasswordException){
                return ResponseState.Error("Введен неверный пароль")
            }
        }


}
class EmailException: Exception() {}
class RepeatPasswordException: Exception()

class InvalidPasswordException : Exception()