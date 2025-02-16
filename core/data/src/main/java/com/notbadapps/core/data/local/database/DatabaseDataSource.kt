package com.notbadapps.core.data.local.database

import com.notbadapps.core.data.local.database.model.ExerciseDto
import com.notbadapps.core.data.model.*

interface DatabaseDataSource {
    suspend fun getAllRoutines(): Result<List<Routine>>
}

class DatabaseDataSourceImpl(
    private val appDatabase: AppDatabase,
) : DatabaseDataSource {

    override suspend fun getAllRoutines(): Result<List<Routine>> {
        return Result.runCatching {
            appDatabase.routineDao()
                .getAll()
                .map {
                    Routine(
                        id = it.routine.routineId,
                        name = it.routine.name,
                        exercises = it.exercises.map { exerciseDto ->
                            exerciseDto.toExercise()
                        },
                    )
                }
        }
    }

}

private fun ExerciseDto.toExercise(): Exercise {
    return Exercise(
        movement = Movement(
            name = name,
            description = description,
            // TODO fix this! we have to map the muscle group to string and back
            muscleGroup = MuscleGroup.LowerBody.Hip,
        ),
        executionParams = ExecutionParams(
            sets = sets,
            repetitions = repetitions,
            weight = weight,
            notes = notes
        )
    )
}