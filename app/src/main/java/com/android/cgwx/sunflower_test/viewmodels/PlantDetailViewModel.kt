package com.android.cgwx.sunflower_test.viewmodels

import androidx.lifecycle.ViewModel
import com.android.cgwx.sunflower_test.BuildConfig
import com.android.cgwx.sunflower_test.data.GardenPlantingRepository
import com.android.cgwx.sunflower_test.data.PlantRepository

class PlantDetailViewModel(
    plantRepository: PlantRepository,
    gardenPlantingRepository: GardenPlantingRepository,
    plantId: String
):ViewModel(){
    val isPlanted = gardenPlantingRepository.isPlanted(plantId)
    val plant = plantRepository.getPlant(plantId)

    fun hasValidUnSplashKey() = (BuildConfig.UNSPLASH_ACCESS_KEY != "null")
}