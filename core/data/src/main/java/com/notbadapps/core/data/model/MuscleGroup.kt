package com.notbadapps.core.data.model

sealed interface MuscleGroup {

    sealed interface UpperBody : MuscleGroup {
        data object Chest : UpperBody
        data object Back : UpperBody
        data object Shoulders : UpperBody

        sealed interface Arms : UpperBody {
            data object Biceps : Arms
            data object Triceps : Arms
            data object Forearms : Arms
        }
    }

    sealed interface Core : MuscleGroup {
        data object Abs : Core
        data object Obliques : Core
        data object LowerBack : Core
    }

    sealed interface LowerBody : MuscleGroup {
        data object Quadriceps : LowerBody
        data object Hamstrings : LowerBody
        data object Glutes : LowerBody
        data object Calves : LowerBody
        data object Hip : LowerBody
    }
}
