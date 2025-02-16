package com.notbadapps.core.data.model

data class Movement(
    val name: String,
    val description: String?,
    val muscleGroup: MuscleGroup,
)

data class Exercise(
    val movement: Movement,
    val executionParams: ExecutionParams? = null,
)

data class ExecutionParams(
    val sets: Int? = null,
    val repetitions: Int? = null,
    val weight: Float? = null,
    val notes: String? = null,
)
