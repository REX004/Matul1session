package com.tttrfge.testprojectsession1.presentation.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.tttrfge.testprojectsession1.R
import com.tttrfge.testprojectsession1.databinding.ActivityOnBoardingBinding
import com.tttrfge.testprojectsession1.presentation.main.MainActivity
import com.tttrfge.testprojectsession1.presentation.onboarding.fragments.OnBoardingOneFragment
import com.tttrfge.testprojectsession1.presentation.onboarding.fragments.OnBoardingThreeFragment
import com.tttrfge.testprojectsession1.presentation.onboarding.fragments.OnBoardingTwoFragment

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var adapter: OnBoardingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = OnBoardingAdapter(listOf(
            OnBoardingOneFragment(),
            OnBoardingTwoFragment(),
            OnBoardingThreeFragment()
        ),
            supportFragmentManager, lifecycle)

        binding.onBoardingVP.adapter = adapter

        binding.onBoardingVP.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> showFirstScreen()
                    1 -> showSecondScreen()
                    2 -> showThirdScreen()
                }
            }
        })
        binding.btn.setOnClickListener {
            if (binding.onBoardingVP.currentItem == 2){
                startActivity(Intent(this, MainActivity::class.java))

            } else {
                binding.onBoardingVP.currentItem += 1

            }
        }
    }
    private fun showFirstScreen(){
        binding.iv1.visibility = View.VISIBLE
        binding.iv2.visibility = View.GONE
        binding.iv3.visibility = View.GONE
        binding.btn.text = "Начать"
    }
    private fun showSecondScreen(){
        binding.iv1.visibility = View.GONE
        binding.iv2.visibility = View.VISIBLE
        binding.iv3.visibility = View.GONE
        binding.btn.text = "Далее"
    }
    private fun showThirdScreen(){
        binding.iv1.visibility = View.GONE
        binding.iv2.visibility = View.GONE
        binding.iv3.visibility = View.VISIBLE
        binding.btn.text = "Далее"
    }
}