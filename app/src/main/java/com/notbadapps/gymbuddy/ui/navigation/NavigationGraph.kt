package com.notbadapps.gymbuddy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.notbadapps.gymbuddy.ui.dashboard.DashboardScreen
import com.notbadapps.gymbuddy.ui.exerciseeditor.ExerciseEditorScreen
import com.notbadapps.gymbuddy.ui.routineeditor.RoutineEditorScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard.route
    ) {
        composable(route = Screen.Dashboard.route) {
            DashboardScreen(navController = navController)
        }
        composable(route = Screen.RoutineEditor.route) {
            RoutineEditorScreen(navController = navController)
        }
        composable(route = Screen.ExerciseEditor.route) {
            ExerciseEditorScreen(navController = navController)
        }
    }
}