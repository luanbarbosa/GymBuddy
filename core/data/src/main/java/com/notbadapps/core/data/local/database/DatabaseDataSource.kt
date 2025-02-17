package com.notbadapps.core.data.local.database

import androidx.room.withTransaction
import com.notbadapps.core.data.local.database.model.ExerciseDto
import com.notbadapps.core.data.local.database.model.RoutineDto
import com.notbadapps.core.data.local.database.model.RoutineWithExerciseDto
import com.notbadapps.core.data.model.*

interface DatabaseDataSource {
    suspend fun insertExercise(exercise: Exercise): Result<Unit>
    suspend fun insertRoutine(routine: Routine): Result<Unit>
}

class DatabaseDataSourceImpl(
    private val appDatabase: AppDatabase,
) : DatabaseDataSource {

    override suspend fun insertExercise(exercise: Exercise): Result<Unit> {
        return Result.runCatching {
            appDatabase.exerciseDao().insert(
                exercise = exercise.toExerciseDto()
            )
        }
    }

    override suspend fun insertRoutine(routine: Routine): Result<Unit> {
        return Result.runCatching {
            appDatabase.withTransaction {
                appDatabase.routineDao().insert(routine = routine.toRoutineDto())
                routine.exercises.forEach { exercise ->
                    appDatabase.routineWithExerciseDao().insert(
                        routine.toRoutineWithExerciseDto(exerciseId = exercise.movement.id)
                    )
                }
            }
        }
    }

}

private fun Exercise.toExerciseDto(): ExerciseDto {
    return ExerciseDto(
        exerciseId = movement.id,
        name = movement.name,
        description = movement.description,
        muscleGroup = movement.muscleGroup,
        sets = executionParams?.sets,
        repetitions = executionParams?.repetitions,
        weight = executionParams?.weight,
        notes = executionParams?.notes,
    )
}

private fun Routine.toRoutineDto(): RoutineDto {
    return RoutineDto(
        routineId = id,
        name = name,
    )
}

private fun Routine.toRoutineWithExerciseDto(exerciseId: Long): RoutineWithExerciseDto {
    return RoutineWithExerciseDto(routineId = id, exerciseId = exerciseId)
}
