package com.notbadapps.core.data.local.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
data class ExerciseDto(
    @PrimaryKey(autoGenerate = true)
    val exerciseId: Long,
    val name: String,
    val description: String?,
    // TODO FIX this needs to be mapped from the sealed value into str and back
    val muscleGroup: String,
    val sets: Int? = null,
    val repetitions: Int? = null,
    val weight: Float? = null,
    val notes: String? = null,
)
