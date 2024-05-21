package com.tttrfge.testprojectsession1.presentation.signin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.tttrfge.testprojectsession1.data.repository.UserRepositoryImpl
import com.tttrfge.testprojectsession1.databinding.ActivitySignInBinding
import com.tttrfge.testprojectsession1.presentation.main.MainActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    private val viewModel: SignInViewModel by  viewModels(factoryProducer = {
        SignInViewModelFactory(UserRepositoryImpl())
    })

//    private lateinit var viewModel: SignInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        viewModel = ViewModelProvider.create(
//            this,
//            SignInViewModelFactory(UserRepositoryImpl())
//        )[SignInViewModel::class]

    binding.btnSignIn.setOnClickListener {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        viewModel.signIn(email, password)

    }

    viewModel.signInState.observe(this) {
        when(it) {
            is State.Error -> {
                binding.dataContainer.visibility = View.VISIBLE
                binding.progress.visibility = View.GONE
                showErrorDialog(it.message)
            }
            is State.Loading -> {
                binding.dataContainer.visibility = View.GONE
                binding.progress.visibility = View.GONE
            }
            is State.Success -> {
                binding.dataContainer.visibility = View.VISIBLE
                binding.progress.visibility = View.GONE
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
    }
    private fun showErrorDialog(message: String){
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .setCancelable(false)
            .show()
    }
}