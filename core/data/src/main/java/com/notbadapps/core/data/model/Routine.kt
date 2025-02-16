package com.notbadapps.core.data.model

data class Routine(
    val id: Long,
    val name: String,
    val exercises: List<Exercise> = emptyList(),
)
