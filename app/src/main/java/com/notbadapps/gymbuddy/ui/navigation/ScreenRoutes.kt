package com.notbadapps.gymbuddy.ui.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("home_screen")
    data object RoutineEditor: Screen("routine_editor_screen")
    data object ExerciseEditor: Screen("exercise_editor_screen")
    data object ExerciseSearch: Screen("exercise_search_screen")
    data object Player: Screen("player_screen")
}
