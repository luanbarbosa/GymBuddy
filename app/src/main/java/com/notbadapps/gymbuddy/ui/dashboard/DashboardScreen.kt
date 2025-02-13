package com.notbadapps.gymbuddy.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.notbadapps.gymbuddy.ui.navigation.Screen

@Composable
fun DashboardScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding(),
    ) {

        Text(
            text = "Dashboard",
            modifier = Modifier.align(Alignment.TopCenter),
        )

        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = spacedBy(10.dp),
        ) {
            Button(
                onClick = { navController.navigate(route = Screen.RoutineEditor.route) },
                content = {
                    Text("Edit exercise")
                },
            )
            Button(
                onClick = { navController.navigate(route = Screen.ExerciseEditor.route) },
                content = {
                    Text("new routine")
                },
            )
        }

    }
}
