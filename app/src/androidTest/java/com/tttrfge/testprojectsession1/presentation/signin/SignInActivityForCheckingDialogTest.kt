package com.tttrfge.testprojectsession1.presentation.signin


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.tttrfge.testprojectsession1.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.`is`
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class SignInActivityForCheckingDialogTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(SignInActivity::class.java)

    @Test
    fun signInActivityForCheckingDialogTest() {
        val textInputEditText = onView(
            allOf(
                withId(R.id.etEmail),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText("qwert@gmail.co"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.etPassword),
                isDisplayed()
            )
        )
        textInputEditText2.perform(replaceText("111234566777778"), closeSoftKeyboard())

        val materialButton = onView(
            allOf(
                withId(R.id.btnSignIn),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val view = onView(
            allOf(
                withId(androidx.appcompat.R.id.textSpacerNoTitle),
                withParent(withParent(withId(androidx.appcompat.R.id.scrollView))),
                isDisplayed()
            )
        )
        view.check(matches(isDisplayed()))
    }
}