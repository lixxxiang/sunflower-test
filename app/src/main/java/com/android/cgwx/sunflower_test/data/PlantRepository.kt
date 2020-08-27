package com.android.cgwx.sunflower_test.data

import androidx.lifecycle.LiveData

class PlantRepository private constructor(private val plantDao: PlantDao) {
    companion object {
        private var instance: PlantRepository? = null


        fun getInstance(plantDao: PlantDao) = instance ?: synchronized(this) {
            instance ?: PlantRepository(plantDao).also { instance = it }
        }
    }

    fun getPlants(): LiveData<List<Plant>> {
        return plantDao.getPlants()
    }

    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): LiveData<List<Plant>> {
        return plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)
    }
}
