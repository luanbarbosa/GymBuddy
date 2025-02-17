package com.notbadapps.core.data.local.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "routine_with_exercise",
    foreignKeys = [
        ForeignKey(
            entity = RoutineDto::class,
            parentColumns = arrayOf(RoutineDto.ROUTINE_ID_KEY_NAME),
            childColumns = arrayOf(RoutineDto.ROUTINE_ID_KEY_NAME),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = ExerciseDto::class,
            parentColumns = arrayOf(ExerciseDto.EXERCISE_ID_KEY_NAME),
            childColumns = arrayOf(ExerciseDto.EXERCISE_ID_KEY_NAME),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        )
    ],
    primaryKeys = [RoutineDto.ROUTINE_ID_KEY_NAME, ExerciseDto.EXERCISE_ID_KEY_NAME]
)
data class RoutineWithExerciseDto(
    @ColumnInfo(name = RoutineDto.ROUTINE_ID_KEY_NAME)
    val routineId: Long,
    @ColumnInfo(name = ExerciseDto.EXERCISE_ID_KEY_NAME)
    val exerciseId: Long,
)