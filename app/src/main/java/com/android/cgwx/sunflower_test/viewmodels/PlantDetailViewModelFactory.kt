package com.android.cgwx.sunflower_test.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.cgwx.sunflower_test.data.GardenPlantingRepository
import com.android.cgwx.sunflower_test.data.PlantRepository

class PlantDetailViewModelFactory(
    val plantRepository: PlantRepository,
    val gardenPlantingRepository: GardenPlantingRepository,
    val plantId: String
):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlantDetailViewModel(plantRepository, gardenPlantingRepository, plantId) as T
    }

}