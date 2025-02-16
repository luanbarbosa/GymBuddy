package com.notbadapps.core.data.local.database.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.notbadapps.core.data.model.Exercise
import com.notbadapps.core.data.model.Routine

@Entity(tableName = "routine")
data class RoutineDto(
    @PrimaryKey(autoGenerate = true)
    val routineId: Long,
    val name: String,
)

data class RoutineWithExercises(
    @Embedded
    val routine: RoutineDto,
    @Relation(
        parentColumn = "routineId",
        entityColumn = "exerciseId"
    )
    val exercise: List<ExerciseDto>
)