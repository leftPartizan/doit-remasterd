package com.example.doitremastered.ui.main.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.doitremastered.app.App
import com.example.doitremastered.ui.main.di.MainScreenComponent
import com.example.doitremastered.ui.main.viewmodel.MainViewModel
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var viewModel: MainViewModel

    private var mainScreenComponent: MainScreenComponent? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainScreenComponent = MainScreenComponent.create(this, App.appComponent)
        mainScreenComponent?.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.start()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MainViewScreen(viewModel = viewModel)
            }
        }
    }

    override fun onDestroy() {
        mainScreenComponent = null
        super.onDestroy()
    }
}