package com.tttrfge.testprojectsession1.presentation.signin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.tttrfge.testprojectsession1.common.ResponseState
import com.tttrfge.testprojectsession1.domain.repository.UserRepository
import kotlinx.coroutines.launch

class SignInViewModel(val userRepository: UserRepository) : ViewModel() {

    var signInState = MutableLiveData<State>()
    fun signIn(email: String, password : String){
        MutableLiveData<State>().value = State.Loading()
        viewModelScope.launch {
            val result = userRepository.signIn(email, password)
            when(result){
                is ResponseState.Error ->
                    MutableLiveData<State>().value = State.Error(result.message)
                is ResponseState.Success ->
                    MutableLiveData<State>().value = State.Success()
            }
        }
    }

}

sealed class State {
    class Success: State()

    class Error(val message: String) : State()

    class Loading: State()
}

class  SignInViewModelFactory(val userRepository: UserRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignInViewModel(userRepository) as T
    }
}