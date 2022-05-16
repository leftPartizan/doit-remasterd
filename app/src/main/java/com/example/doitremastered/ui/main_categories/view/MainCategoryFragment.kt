package com.example.doitremastered.ui.main_categories.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.doitremastered.ui.main_categories.view_model.MainCategoryViewModel
import javax.inject.Inject


class MainCategoryFragment : Fragment() {

    @Inject
    lateinit var viewModel: MainCategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MainCategoryViewScreen()
            }
        }
    }
}