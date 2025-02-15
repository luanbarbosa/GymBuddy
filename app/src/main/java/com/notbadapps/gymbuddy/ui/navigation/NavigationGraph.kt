package com.notbadapps.gymbuddy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.notbadapps.gymbuddy.ui.home.HomeScreen
import com.notbadapps.gymbuddy.ui.exercise.ExerciseEditorScreen
import com.notbadapps.gymbuddy.ui.player.PlayerScreen
import com.notbadapps.gymbuddy.ui.routine.RoutineEditorScreen
import com.notbadapps.gymbuddy.ui.search.ExerciseSearchScreen
import com.notbadapps.gymbuddy.ui.settings.SettingsScreen
import com.notbadapps.gymbuddy.ui.statistics.StatisticsScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        // main navigation screens
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen(navController = navController)
        }
        composable(route = Screen.Statistics.route) {
            StatisticsScreen(navController = navController)
        }

        // other navigation screens
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