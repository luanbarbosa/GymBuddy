package com.notbadapps.gymbuddy.ui

import androidx.lifecycle.ViewModel
import com.notbadapps.core.data.local.database.DatabaseDataSource
import com.notbadapps.core.data.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val databaseDataSource: DatabaseDataSource,
): ViewModel() {

    fun addRandomExercise() {
        // TODO delete this
        GlobalScope.launch {

            val exercise = Exercise(
                movement = Movement(
                    id = 200,
                    name = "Test Movement",
                    description = "Test Description",
                    muscleGroup = MuscleGroup.LowerBody.Hip,
                ),
                executionParams = ExecutionParams(
                    sets = 99,
                    repetitions = 88,
                    weight = 111f,
                    notes = "test notes"
                )
            )

            databaseDataSource.insertExercise(exercise = exercise)

            databaseDataSource.insertRoutine(
                Routine(
                    id = 100,
                    name = "Test Routine",
                    exercises = listOf(exercise)
                )
            )

            databaseDataSource.insertRoutine(
                Routine(
                    id = 200,
                    name = "Test Routine 2",
                    exercises = listOf(exercise)
                )
            )
        }
    }

}