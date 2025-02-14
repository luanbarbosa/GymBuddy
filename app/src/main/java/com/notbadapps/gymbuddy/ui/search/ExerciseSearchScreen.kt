package com.notbadapps.gymbuddy.ui.search

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ExerciseSearchScreen(navController: NavController) {
    BackHandler {
        navController.popBackStack()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = "Exercise Search",
            modifier = Modifier.align(Alignment.Center),
        )
    }
}