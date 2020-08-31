package com.android.cgwx.sunflower_test.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface GardenPlantingDao {

    @Transaction
    @Query("SELECT * FROM plants WHERE id IN (SELECT DISTINCT(plant_id) FROM garden_plantings)")
    fun getPlantedGardens(): LiveData<List<PlantAndGardenPlantings>>

    @Query("SELECT EXISTS(SELECT 1 FROM garden_plantings WHERE plant_id = :plantId LIMIT 1)")
    fun isPlanted(plantId: String): LiveData<Boolean>
}