package com.notbadapps.gymbuddy.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.notbadapps.gymbuddy.ui.navigation.NavigationGraph

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
    ) {
        // TODO add BottomNavigationBar
        NavigationGraph()
    }
}
