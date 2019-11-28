package com.example.mvvmsampleapp

import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.mvvmsampleapp.country.CountryActivity
import com.example.mvvmsampleapp.util.EspressoIdlingResouce
import junit.framework.Assert
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class CountryActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(CountryActivity::class.java, false, false)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResouce.getIdlingResource())
        var intent = Intent()
        mActivityTestRule.launchActivity(intent)
    }

    @Test
    fun showList_fromWs_Test() {
        val recyclerView: RecyclerView = mActivityTestRule.activity.findViewById(R.id.recyclerView)
        onView(withId(R.id.recyclerView)).check(
            matches(
                isDisplayed()
            )
        )
        Log.e("size", "" + recyclerView.adapter?.itemCount)
        Assert.assertNotSame(0, recyclerView.adapter?.itemCount)
    }

    @Test
    fun showList_fromDb_Test() {
        val recyclerView: RecyclerView = mActivityTestRule.activity.findViewById(R.id.recyclerView)
        onView(withId(R.id.recyclerView)).check(
            matches(
                isDisplayed()
            )
        )
        Log.e("size", "" + recyclerView.adapter?.itemCount)
        Assert.assertNotSame(0, recyclerView.adapter?.itemCount)
    }

    @After
    fun destroy() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResouce.getIdlingResource());
    }

}