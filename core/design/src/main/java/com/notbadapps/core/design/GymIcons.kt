package com.notbadapps.core.design

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class GymIcon(
    val iconResource: Int,
    val contentDescriptionResource: Int?,
    val activeLightTint: Color = Color.Unspecified,
    val activeDarkTint: Color = Color.Unspecified,
)

object GymIcons {
    val home = GymIcon(
        iconResource = R.drawable.ic_home,
        contentDescriptionResource = null,
    )
    val statistics = GymIcon(
        iconResource = R.drawable.ic_bar_chart,
        contentDescriptionResource = null,
    )
    val settings = GymIcon(
        iconResource = R.drawable.ic_settings,
        contentDescriptionResource = null,
    )
}