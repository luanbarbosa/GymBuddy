package com.notbadapps.gymbuddy.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.notbadapps.core.data.model.*
import com.notbadapps.gymbuddy.ui.navigation.BottomAppBar
import com.notbadapps.gymbuddy.ui.navigation.NavigationGraph
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val viewModel: MainScreenViewModel = hiltViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
    ) {
        val navController = rememberNavController()

        Scaffold(
            bottomBar = {
                BottomAppBar(navController)
            }
        ) { contentPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding)
                    .consumeWindowInsets(contentPadding)
            ) {
                val scope = rememberCoroutineScope()
                NavigationGraph(
                    navController = navController,
                    onAddRandomExercise = {
                        // TODO remove this
                        viewModel.addRandomExercise()
                    }
                )
            }
        }
    }
}
