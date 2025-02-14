package com.notbadapps.gymbuddy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.notbadapps.gymbuddy.ui.home.HomeScreen
import com.notbadapps.gymbuddy.ui.exercise.ExerciseEditorScreen
import com.notbadapps.gymbuddy.ui.player.PlayerScreen
import com.notbadapps.gymbuddy.ui.routine.RoutineEditorScreen
import com.notbadapps.gymbuddy.ui.search.ExerciseSearchScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.RoutineEditor.route) {
            RoutineEditorScreen(navController = navController)
        }
        composable(route = Screen.ExerciseEditor.route) {
            ExerciseEditorScreen(navController = navController)
        }
        composable(route = Screen.ExerciseSearch.route) {
            ExerciseSearchScreen(navController = navController)
        }
        composable(route = Screen.Player.route) {
            PlayerScreen(navController = navController)
        }
    }
}