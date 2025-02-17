package com.notbadapps.core.data.local.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.notbadapps.core.data.model.MuscleGroup

@Entity(tableName = "exercise")
data class ExerciseDto(
    @PrimaryKey(autoGenerate = true)
    val exerciseId: Long,
    val name: String,
    val description: String?,
    val muscleGroup: MuscleGroup,
    val sets: Int? = null,
    val repetitions: Int? = null,
    val weight: Float? = null,
    val notes: String? = null,
)
