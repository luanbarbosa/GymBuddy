package com.notbadapps.core.data.model

data class Movement(
    val id: Long,
    val name: String,
    val description: String?,
    val muscleGroup: MuscleGroup,
)

data class Exercise(
    val id: Long,
    val movement: Movement,
    val executionParams: ExecutionParams? = null,
)

data class ExecutionParams(
    val sets: Int? = null,
    val repetitions: Int? = null,
    val weight: Float? = null,
    val notes: String? = null,
)
