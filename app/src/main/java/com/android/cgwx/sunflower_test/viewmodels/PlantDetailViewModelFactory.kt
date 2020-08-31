package com.android.cgwx.sunflower_test.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.cgwx.sunflower_test.data.GardenPlantingRepository

class PlantDetailViewModelFactory(
    val gardenPlantingRepository: GardenPlantingRepository,
    val plantId: String
):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlantDetailViewModel(gardenPlantingRepository, plantId) as T
    }

}