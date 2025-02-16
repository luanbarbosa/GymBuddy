package com.notbadapps.core.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.notbadapps.core.data.local.database.model.RoutineWithExercises

@Dao
interface RoutineDao {

    @Transaction
    @Query("SELECT * FROM routine")
    suspend fun getAll(): List<RoutineWithExercises>
}