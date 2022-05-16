package com.example.doitremastered.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.doitremastered.ui.main.view.MainFragment
import com.example.doitremastered.ui.main_categories.view.MainCategoryFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun mainScreen() = object : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return MainFragment()
        }
    }

    fun mainCategory(name: String) = object : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return MainCategoryFragment().apply {
                arguments = Bundle().apply { putString("name", name) }
            }
        }
    }
}