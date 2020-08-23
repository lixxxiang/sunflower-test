package com.android.cgwx.sunflower_test.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.cgwx.sunflower_test.data.GardenPlantingRepository
import com.android.cgwx.sunflower_test.data.PlantAndGardenPlantings

class GardenPlantingListViewModel internal constructor(
    gardenPlantingRepository: GardenPlantingRepository
):ViewModel(){
    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> =
        gardenPlantingRepository.getPlantedGardens()
}