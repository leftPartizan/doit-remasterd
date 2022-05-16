package com.example.doitremastered.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.doitremastered.R
import com.example.doitremastered.app.App
import com.example.doitremastered.navigation.Screens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private var activityComponent: ActivityComponent? = null

    private val navigator = AppNavigator(this, R.id.activity_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = ActivityComponent.create(this, App.appComponent)
        activityComponent?.inject(this)
        setContentView(R.layout.activity_main)
        router.newRootScreen(Screens.mainScreen())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onDestroy() {
        activityComponent = null
        super.onDestroy()
    }
}