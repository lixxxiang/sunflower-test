package com.android.cgwx.sunflower_test.viewmodels

import androidx.lifecycle.ViewModel
import com.android.cgwx.sunflower_test.data.GardenPlantingRepository
import com.android.cgwx.sunflower_test.data.PlantRepository

class PlantDetailViewModel(
    gardenPlantingRepository: GardenPlantingRepository, plantId: String
):ViewModel(){
    val isPlanted = gardenPlantingRepository.isPlanted(plantId)
}