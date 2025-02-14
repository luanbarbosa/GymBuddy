package com.notbadapps.gymbuddy.ui.search

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.notbadapps.core.design.theme.MainTheme
import com.notbadapps.core.design.utils.LightDarkPreview

@Composable
fun ExerciseSearchScreen(navController: NavController) {
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
                Text("Find exercise")
            },
        )
        SearchBarContent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onSearchValueChange = {}
        )
        SearchBody(modifier = Modifier)
    }
}

@Composable
fun SearchBody(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 16.dp),
        verticalArrangement = spacedBy(12.dp)
    ) {
        Button(onClick = {}) {
            Text("+ Add custom")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray, shape = RoundedCornerShape(8.dp))
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            // TODO Add already in use exercises box
            Text("[PLACEHOLDER] already in use exercises")
        }

        Text("Full exercises catalog")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray, shape = RoundedCornerShape(8.dp))
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            // TODO Add search filters
            Text("[PLACEHOLDER] search filters")
        }

        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(color = Color.LightGray, shape = RoundedCornerShape(8.dp))
                .padding(all = 16.dp),
            verticalArrangement = spacedBy(8.dp),
        ) {
            repeat(10) {
                item {

                    // TODO Add exercise card
                    Text("[PLACEHOLDER] exercise card")
                }
            }
        }
    }
}

@Composable
fun SearchBarContent(
    onSearchValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(Unit) { focusRequester.requestFocus() }

    DisposableEffect(keyboardController) {
        keyboardController?.show()
        onDispose {
            keyboardController?.hide()
        }
    }

    Column(
        modifier = modifier
            .focusRequester(focusRequester)
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(24.dp),
            ),
    ) {
        var searchValue by rememberSaveable { mutableStateOf("") }
        TextField(
            modifier = Modifier.background(Color.Transparent),
            value = searchValue,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardController?.hide()
                    onSearchValueChange(searchValue)
                }
            ),
            onValueChange = {
                searchValue = it
                onSearchValueChange(it)
            },
            placeholder = {
                Text(text = "Search")
            },
            colors = TextFieldDefaults.colors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
            ),
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        )
    }
}


@LightDarkPreview
@Composable
private fun Preview() {
    MainTheme {
        ScreenContent()
    }
}
