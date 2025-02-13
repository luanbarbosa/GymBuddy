package com.notbadapps.core.data.model

data class Exercise(
    val name: String,
    val description: String?,
    val muscleGroup: MuscleGroup,
    val mediaResources: MediaResources?,
    val executionParams: ExecutionParams? = null,
)

data class ExecutionParams(
    val sets: Int? = null,
    val repetitions: Int? = null,
    val weight: Float? = null,
    val notes: String? = null,
)

data class MediaResources(
    val images: List<String>,
    val videos: List<String>,
)