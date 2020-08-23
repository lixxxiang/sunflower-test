package com.android.cgwx.sunflower_test.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.cgwx.sunflower_test.data.GardenPlantingRepository

class GardenPlantingListViewModelFactory (
    private val repository: GardenPlantingRepository
):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GardenPlantingListViewModel(repository) as T
    }

}

