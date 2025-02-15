package com.notbadapps.gymbuddy.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.notbadapps.core.design.GymIcon
import com.notbadapps.core.design.GymIcons
import kotlinx.coroutines.flow.map

sealed class MainNavigation(
    val title: String,
    val icon: GymIcon,
    val screenRoute: Screen
) {
    data object Home : MainNavigation(
        title = "My workout",
        icon = GymIcons.home,
        screenRoute = Screen.Home,
    )
    data object Statistics : MainNavigation(
        title = "Statistics",
        icon = GymIcons.statistics,
        screenRoute = Screen.Statistics,
    )
    data object Settings : MainNavigation(
        title = "Settings",
        icon = GymIcons.settings,
        screenRoute = Screen.Settings,
    )
}

@Composable
fun BottomAppBar(
    navController: NavController,
) {
    val currentRoute = navController.currentBackStackEntryFlow.map { backStackEntry ->
        backStackEntry.destination.route
    }.collectAsState(initial = Screen.Home.route)
    val items = listOf(
        MainNavigation.Home,
        MainNavigation.Statistics,
        MainNavigation.Settings
    )
    var selectedItem by remember { mutableIntStateOf(0) }
    items.forEachIndexed { index, navigationItem ->
        if (navigationItem.screenRoute.route == currentRoute.value) {
            selectedItem = index
        }
    }
    NavigationBar {
        items.forEachIndexed { index, navItem ->
            NavigationBarItem(
                alwaysShowLabel = true,
                icon = { Icon(
                    painter = painterResource(navItem.icon.iconResource),
                    contentDescription = navItem.title
                ) },
                label = { Text(navItem.title) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(navItem.screenRoute.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}