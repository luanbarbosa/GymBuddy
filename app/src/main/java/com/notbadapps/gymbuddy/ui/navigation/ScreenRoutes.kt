package com.notbadapps.gymbuddy.ui.navigation

sealed class Screen(val route: String) {
    data object Dashboard: Screen("dashboard_screen")
    data object RoutineEditor: Screen("routine_editor_screen")
    data object ExerciseEditor: Screen("exercise_editor_screen")
}
