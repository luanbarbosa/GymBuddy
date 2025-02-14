package com.notbadapps.gymbuddy.ui.exercise

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.notbadapps.core.design.theme.MainTheme
import com.notbadapps.core.design.utils.LightDarkPreview

@Composable
fun ExerciseEditorScreen(navController: NavController) {

    BackHandler { navController.popBackStack() }
    ScreenContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScreenContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.background(Color.White) // TODO use color tokens
    ) {
        TopAppBar(
            title = {
                Text("Exercise editor".uppercase())
            },
        )
        ExercisesFields(
            modifier = Modifier.weight(1f)
        )
        ActionRow()
    }
}

@Composable
private fun ExercisesFields(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 16.dp),
    ) {
        // TODO use keyboard to go to next on "enter" keyboard
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Name")
            },
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Description")
            },
        )
        // TODO Add muscle group picker
        Text("[PLACEHOLDER] muscle group picker")
        // TODO Add media picker/gallery
        Text("[PLACEHOLDER] media picker/gallery")

        val numberKeyboardOption = KeyboardOptions(keyboardType = KeyboardType.Number)
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Sets")
            },
            keyboardOptions = numberKeyboardOption,
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Reps")
            },
            keyboardOptions = numberKeyboardOption,
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Weight")
            },
            keyboardOptions = numberKeyboardOption,
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            value = "",
            onValueChange = { },
            label = {
                Text(text = "Notes")
            },
            maxLines = 3,
        )
    }
}

@Composable
private fun ActionRow() {
    Button(onClick = {}) {
        Text("Save")
    }
}


@LightDarkPreview
@Composable
private fun Preview() {
    MainTheme {
        ScreenContent()
    }
}