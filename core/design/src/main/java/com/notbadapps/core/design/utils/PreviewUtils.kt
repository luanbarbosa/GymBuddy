package com.notbadapps.core.design.utils

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Preview",
    group = "Light",
)
@Preview(
    name = "Preview (dark)",
    group = "Dark",
    uiMode = UI_MODE_NIGHT_YES
)
annotation class LightDarkPreview