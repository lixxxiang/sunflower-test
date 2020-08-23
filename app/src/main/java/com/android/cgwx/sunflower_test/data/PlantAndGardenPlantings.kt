package com.android.cgwx.sunflower_test.data

import androidx.room.Embedded
import androidx.room.Relation

data class PlantAndGardenPlantings(
    @Embedded
    var plant:Plant,

    @Relation(parentColumn = "id", entityColumn = "plant_id")
    var gardenPlantings: List<GardenPlanting>
)