package com.notbadapps.gymbuddy.ui.routine

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.notbadapps.gymbuddy.ui.navigation.Screen

@Composable
fun RoutineEditorScreen(navController: NavController) {

    BackHandler {
        navController.popBackStack()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .navigationBarsPadding(),
    ) {
        Text(
            text = "Routine Editor",
            modifier = Modifier.align(Alignment.TopCenter),
        )
        Button(
            onClick = { navController.navigate(route = Screen.ExerciseSearch.route) },
            content = {
                Text("Search exercise")
            },
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
