package com.notbadapps.gymbuddy.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.notbadapps.gymbuddy.ui.navigation.BottomAppBar
import com.notbadapps.gymbuddy.ui.navigation.NavigationGraph

@Composable
fun MainScreen() {
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
                NavigationGraph(navController)
            }
        }
    }
}
