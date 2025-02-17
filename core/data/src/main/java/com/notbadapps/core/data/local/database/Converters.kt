package com.notbadapps.core.data.local.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.notbadapps.core.data.model.MuscleGroup

class Converters {
    @TypeConverter
    fun fromMuscleGroup(muscleGroup: MuscleGroup): String {
        return Gson().toJson(muscleGroup)
    }

    @TypeConverter
    fun toMuscleGroup(muscleGroup: String): MuscleGroup? {
        return runCatching {
            Gson().fromJson(muscleGroup, MuscleGroup::class.java)
        }.getOrNull()
    }
}