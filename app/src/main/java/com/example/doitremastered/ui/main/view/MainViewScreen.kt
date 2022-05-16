package com.example.doitremastered.ui.main.view

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Photo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doitremastered.domain.entities.CategoryMain
import com.example.doitremastered.ui.main.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun MainViewScreen(viewModel: MainViewModel) {
    val scaffoldState = rememberScaffoldState()
    val categories by viewModel.mainCategories.observeAsState(emptyList())
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                navigationIcon = {
                    IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
                        Icon(Icons.Filled.Menu, "")
                    }
                }
            )
        },
        drawerContent = { MainListCategories(
            categories = categories,
            modifier = Modifier.padding(16.dp),
            viewModel = viewModel
        ) }
    ) {}
}

@Composable
fun MainListCategories(categories: List<CategoryMain>, modifier: Modifier, viewModel: MainViewModel) {

    Column(
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Filled.Photo,
            contentDescription = "",
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = Color.DarkGray,
                    shape = CircleShape
                )
                .size(32.dp)
                .padding(4.dp)
        )

        Text(
            text = " user name ",
            fontSize = 16.sp,
            textAlign = TextAlign.Left
        )
        Text(
            text = " user email ",
            fontSize = 16.sp,
            textAlign = TextAlign.Left
        )

        LazyColumn() {
            items(items = categories) { category ->
                Row(
                    modifier = Modifier.clickable { viewModel.goToCategory(category.name) }
                ) {
                    Text(
                        text = category.name,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun MainScreenPreview() {
//    MainListCategories(
//        categories = arrayListOf(
//            CategoryMain(0, "сегодня", true),
//            CategoryMain(0, "завтра", true),
//            CategoryMain(0, "все задачи", true)
//        )
//    )
//}