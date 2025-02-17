package com.notbadapps.core.data.local.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "routine")
data class RoutineDto(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ROUTINE_ID_KEY_NAME)
    val routineId: Long,
    val name: String,
) {
    companion object {
        const val ROUTINE_ID_KEY_NAME = "routine_id"
    }
}
